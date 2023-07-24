import pika, sys, os
from threading import Thread
import json
from PyQt5.QtWidgets import QWidget, QPushButton, QApplication, QLabel, QGridLayout, QLineEdit

TourismObjectType = {
    "name": "",
    "latitude": 0.0,
    "longitude": 0.0
}

DataGuiToServer = {
    "tourismObjectType": "",
    "latitude": 0.0,
    "longitude": 0.0
}

DataServerToGui = {
    "prediction": 0,
    "nearestHotels": TourismObjectType,
    "nearestCafe": TourismObjectType,
}

class EmulGui(QWidget):

    def __init__(self, channelSend):
        super().__init__()

        self.initUI(channelSend)

    def send(self, channelSend):
        dataGuiToServer = DataGuiToServer
        channelSend.basic_publish(exchange='gui2server', routing_key='gui2server-q1', body=json.dumps(dataGuiToServer))
        print("Messagew sent")

    def initUI(self, channelSend):

        self.lbl1 = QLabel('Широта')
        self.lbl2 = QLabel('Долгота')

        self.le1 = QLineEdit()
        self.le2 = QLineEdit()

        self.btn1 = QPushButton('Запросить данные')
        self.btn1.clicked.connect(lambda: self.send(channelSend))
        self.btn1.resize(self.btn1.sizeHint())

        lbl3 = QLabel('') # Оценка кол-ва запросов в месяц
        lbl4 = QLabel('') # Список ближайших КСР
        lbl5 = QLabel('') # Список ближайших общепитов

        grid = QGridLayout()
        grid.setSpacing(10)

        grid.addWidget(self.lbl1, 1, 0)
        grid.addWidget(self.le1, 1, 1)

        grid.addWidget(self.lbl2, 2, 0)
        grid.addWidget(self.le2, 2, 1)

        grid.addWidget(self.btn1, 3, 0)

        grid.addWidget(lbl3, 4, 0)
        grid.addWidget(lbl4, 5, 0)
        grid.addWidget(lbl5, 6, 0)

        self.setLayout(grid)

        self.setGeometry(300, 300, 350, 300)
        self.setWindowTitle('Review')
        self.show()

        self.setGeometry(300, 300, 720, 480)
        self.setWindowTitle('Quit button')
        self.show()


def regularMessageCallback(ch, method, properties, body):
    print("Received %r" % json.loads(body))
    dataServerToGui = DataServerToGui


def handleRegularMessage(channelReceive):
    channelReceive.basic_consume(queue='server2gui-q1', on_message_callback=regularMessageCallback, auto_ack=True)
    channelReceive.start_consuming()

def main():

    connectionReceive = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
    channelReceive = connectionReceive.channel()

    try:
        channelReceive.exchange_declare('server2gui', exchange_type='direct')
        channelReceive.queue_declare(queue='server2gui-q1')
    except Exception:
        print('server2gui has already declared')

    recvThread = Thread(target=handleRegularMessage, args=(channelReceive,))
    recvThread.start()

    connectionSend = pika.BlockingConnection(pika.ConnectionParameters(host="localhost"))
    channelSend = connectionSend.channel()

    try:
        channelSend.exchange_declare('gui2server', exchange_type='direct')
        channelSend.queue_declare(queue='gui2server-q1')
    except Exception:
        print('gui2server has already declared')
    channelSend.queue_bind(queue='gui2server-q1', exchange='gui2server', routing_key='gui2server-q1')

    app = QApplication(sys.argv)
    gui = EmulGui(channelSend)
    sys.exit(app.exec_())


if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        print('Interrupted')
        try:
            sys.exit(0)
        except SystemExit:
            os._exit(0)
