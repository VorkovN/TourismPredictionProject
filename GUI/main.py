import pika, sys, os
from threading import Thread
import time
import json
from PyQt5.QtWidgets import QWidget, QPushButton, QApplication, QLabel, QGridLayout, QLineEdit

class EmulGui(QWidget):

    def __init__(self, channelSend):
        super().__init__()

        self.initUI(channelSend)

    def sendMessage1(self, channelSend):
        channelSend.basic_publish(exchange='gui2server', routing_key='gui2server-q1', body='Hello World! 2')
        print("Sent 'Hello World! 2'")

    def initUI(self, channelSend):

        lbl1 = QLabel('Широта')
        lbl2 = QLabel('Долгота')

        le1 = QLineEdit()
        le2 = QLineEdit()

        btn1 = QPushButton('Запросить данные')
        btn1.clicked.connect(lambda: self.sendMessage1(channelSend))
        btn1.resize(btn1.sizeHint())

        lbl3 = QLabel('') # Оценка кол-ва запросов в месяц
        lbl4 = QLabel('') # Список ближайших КСР
        lbl5 = QLabel('') # Список ближайших общепитов

        grid = QGridLayout()
        grid.setSpacing(10)

        grid.addWidget(lbl1, 1, 0)
        grid.addWidget(le1, 1, 1)

        grid.addWidget(lbl2, 2, 0)
        grid.addWidget(le2, 2, 1)

        grid.addWidget(btn1, 3, 0)

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
    print(" [x] Received %r" % body)

def handleRegularMessage(channelReceive):
    channelReceive.basic_consume(queue='server2gui-q1', on_message_callback=regularMessageCallback, auto_ack=True)
    channelReceive.start_consuming()

def sendRegularMessage(channelSend):
    while(True):
        data = {
            "id": 1,
            "name": "My Name",
            "description": "This is description about me"
        }

        message = json.dumps(data)
        channelSend.basic_publish(exchange='gui2server', routing_key='gui2server-q1', body='Hello World! 3')
        # print("Regular message sent")
        time.sleep(1)

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
    sendThread = Thread(target=sendRegularMessage, args=(channelSend,))
    sendThread.start()

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
