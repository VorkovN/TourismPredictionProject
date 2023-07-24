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
    "nearestHotels": [TourismObjectType],
    "nearestCafe": [TourismObjectType],
}

class EmulGui(QWidget):

    def __init__(self):
        super().__init__()

        self.initUI()

    def send(self):
        dataGuiToServer = DataGuiToServer
        dataGuiToServer["tourismObjectType"] = self.le0.text()
        dataGuiToServer["latitude"] = self.le1.text()
        dataGuiToServer["longitude"] = self.le2.text()
        self.le0.setText("")
        self.le1.setText("")
        self.le2.setText("")
        self.channelSend.basic_publish(exchange='gui2server', routing_key='gui2server-q1', body=json.dumps(dataGuiToServer))
        print("Messagew sent")

    def regularMessageCallback(self, ch, method, properties, body):
        dataServerToGui = json.loads(body)
        print("Received %r" % dataServerToGui)
        prediction = str(dataServerToGui["prediction"])
        nearestHotels = dataServerToGui["nearestHotels"]
        nearestCafe = dataServerToGui["nearestCafe"]

        self.lbl4.setText(prediction)

        i = 0
        outputStr = ""
        for hotel in nearestHotels:
            i += 1
            outputStr = outputStr + str(i) + ". Название КСР: " + str(hotel["name"]) + "\n" + \
                        "    Широта: " + str(hotel["latitude"]) + "\n" + \
                        "    Долгота: " + str(hotel["longitude"]) + "\n"
            self.lbl6.setText(outputStr + "\n")
        i = 0
        outputStr = ""
        for cafe in nearestCafe:
            i += 1
            outputStr = outputStr + str(i) + ". Название общепита: " + str(cafe["name"]) + "\n" + \
                        "    Широта: " + str(cafe["latitude"]) + "\n" + \
                        "    Долгота: " + str(cafe["longitude"]) + "\n"
            self.lbl8.setText(outputStr + "\n")

    def initUI(self):

        connectionReceive = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
        self.channelReceive = connectionReceive.channel()

        try:
            self.channelReceive.exchange_declare('server2gui', exchange_type='direct')
            self.channelReceive.queue_declare(queue='server2gui-q1')
        except Exception:
            print('server2gui has already declared')

        self.channelReceive.basic_consume(queue='server2gui-q1', on_message_callback=self.regularMessageCallback, auto_ack=True)

        recvThread = Thread(target=self.channelReceive.start_consuming)
        recvThread.start()


        connectionSend = pika.BlockingConnection(pika.ConnectionParameters(host="localhost"))
        self.channelSend = connectionSend.channel()

        try:
            self.channelSend.exchange_declare('gui2server', exchange_type='direct')
            self.channelSend.queue_declare(queue='gui2server-q1')
        except Exception:
            print('gui2server has already declared')
        self.channelSend.queue_bind(queue='gui2server-q1', exchange='gui2server', routing_key='gui2server-q1')


        self.lbl0 = QLabel('Тип туристического объекта:')
        self.lbl1 = QLabel('Широта:')
        self.lbl2 = QLabel('Долгота:')

        self.le0 = QLineEdit()
        self.le1 = QLineEdit()
        self.le2 = QLineEdit()

        self.btn1 = QPushButton('Запросить данные')
        self.btn1.clicked.connect(self.send)
        # self.btn1.resize(self.btn1.sizeHint())

        self.lbl3 = QLabel('Оценка кол-ва запросов в месяц:')
        self.lbl4 = QLabel('')
        self.lbl5 = QLabel('Список ближайших КСР:')
        self.lbl6 = QLabel('')
        self.lbl7 = QLabel('Список ближайших общепитов:')
        self.lbl8 = QLabel('')

        grid = QGridLayout()
        grid.setSpacing(10)

        grid.addWidget(self.lbl0, 1, 0)
        grid.addWidget(self.le0, 1, 1)

        grid.addWidget(self.lbl1, 2, 0)
        grid.addWidget(self.le1, 2, 1)

        grid.addWidget(self.lbl2, 3, 0)
        grid.addWidget(self.le2, 3, 1)

        grid.addWidget(self.btn1, 4, 0)

        grid.addWidget(self.lbl3, 5, 0)
        grid.addWidget(self.lbl4, 5, 1)
        grid.addWidget(self.lbl5, 6, 0)
        grid.addWidget(self.lbl6, 6, 1)
        grid.addWidget(self.lbl7, 7, 0)
        grid.addWidget(self.lbl8, 7, 1)

        self.setLayout(grid)

        self.setGeometry(300, 300, 350, 300)
        self.setWindowTitle('Review')
        self.show()

        self.setGeometry(300, 300, 720, 480)
        self.setWindowTitle('Quit button')
        self.show()

def main():
    app = QApplication(sys.argv)
    gui = EmulGui()
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
