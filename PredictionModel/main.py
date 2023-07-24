import pika, sys, os
from threading import Thread
import json
import joblib
import pandas as pd


DataMlToServer = {
    "name": "",
    "popularity": 0.0,
}

DataServerToMl = {
    "name" : "",
    "latitude" : 0.0,
    "longitude" : 0.0,
    "coeffNearestPopularity" : 0.0,
    "carAvailability" : False,
    "busAvailability" : False,
    "bigCarAvailability" : False,
    "shipAvailability" : False,
    "planeAvailability" : False,
    "theatre" : False,
    "ethnicCenter" : False,
    "museum" : False,
    "childrensTourism" : False,
    "cityAttractions" : False,
    "attraction" : False,
    "culturalCentre" : False,
    "shipbuilding" : False,
    "nationalPark" : False,
    "sanatorium" : False,
    "lookout" : False,
    "skiResort" : False,
}

class MLPredictor():

    def __init__(self):
        super().__init__()

        connectionSend = pika.BlockingConnection(pika.ConnectionParameters(host="localhost"))
        self.channelSend = connectionSend.channel()

        try:
            self.channelSend.exchange_declare('ml2server', exchange_type='direct')
            self.channelSend.queue_declare(queue='ml2server-q1')
        except Exception:
            print('ml2server has already declared')
        self.channelSend.queue_bind(queue='ml2server-q1', exchange='ml2server', routing_key='ml2server-q1')

        connectionReceive = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
        self.channelReceive = connectionReceive.channel()

        try:
            self.channelReceive.exchange_declare('server2ml', exchange_type='direct')
            self.channelReceive.queue_declare(queue='server2ml-q1')
        except Exception:
            print('server2ml has already declared')

        self.channelReceive.basic_consume(queue='server2ml-q1', on_message_callback=self.regularMessageCallback, auto_ack=True)
        self.channelReceive.start_consuming()

    def regularMessageCallback(self, ch, method, properties, body):
        dataServerToMl = json.loads(body)
        print("Received %r" % dataServerToMl)

        paramsVector = {'Широта': [dataServerToMl['latitude']],
                        'Долгота': [dataServerToMl['longitude']],
                        'Коэффициент кол-ва запросов в месяц окружающих объектов': [dataServerToMl['coeffNearestPopularity']],
                        'Доступность автомобиля': [dataServerToMl['carAvailability']],
                        'Доступность автобуса': [dataServerToMl['busAvailability']],
                        'Доступность внедорожника': [dataServerToMl['bigCarAvailability']],
                        'Доступность водныого транспорта': [dataServerToMl['shipAvailability']],
                        'Доступность самолета': [dataServerToMl['planeAvailability']],
                        'Театр': [dataServerToMl['theatre']],
                        'Этнический центр': [dataServerToMl['ethnicCenter']],
                        'Музей': [dataServerToMl['museum']],
                        'Детский туризм': [dataServerToMl['childrensTourism']],
                        'Городские достопримечательности': [dataServerToMl['cityAttractions']],
                        'Достопримечательность': [dataServerToMl['attraction']],
                        'Культурный центр': [dataServerToMl['culturalCentre']],
                        'Судостроение': [dataServerToMl['shipbuilding']],
                        'Нац. парк': [dataServerToMl['nationalPark']],
                        'Санаторий': [dataServerToMl['sanatorium']],
                        'Обзорная площадка': [dataServerToMl['lookout']],
                        'Горнолыжный курорт': [dataServerToMl['skiResort']]}
        data = pd.DataFrame(paramsVector)
        print(data)
        reg = joblib.load('regression_model.joblib')
        predictions = reg.predict(data)

        dataMlToServer = DataMlToServer
        dataMlToServer["name"] = dataServerToMl['name']
        dataMlToServer["popularity"] = predictions.data.item(0)
        print(dataMlToServer["popularity"])
        self.channelSend.basic_publish(exchange='ml2server', routing_key='ml2server-q1', body=json.dumps(dataMlToServer))
        print("Messagew sent")


def main():
    mlPredictor = MLPredictor()

if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        print('Interrupted')
        try:
            sys.exit(0)
        except SystemExit:
            os._exit(0)
