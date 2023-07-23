import pika, sys, os
from threading import Thread
import time
import json

def regularMessageCallback(ch, method, properties, body):
    print(" [x] Received %r" % body)

def handleRegularMessage(channelReceive):
    channelReceive.basic_consume(queue='server2ml-q1', on_message_callback=regularMessageCallback, auto_ack=True)
    channelReceive.start_consuming()

def sendRegularMessage(channelSend):
    while(True):
        data = {
            "id": 1,
            "name": "My Name",
            "description": "This is description about me"
        }

        message = json.dumps(data)
        channelSend.basic_publish(exchange='ml2server', routing_key='ml2server-q1', body='Hello World! 3')
        time.sleep(1)

def main():

    connectionReceive = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
    channelReceive = connectionReceive.channel()

    try:
        channelReceive.exchange_declare('server2ml', exchange_type='direct')
        channelReceive.queue_declare(queue='server2ml-q1')
    except Exception:
        print('server2ml has already declared')

    recvThread = Thread(target=handleRegularMessage, args=(channelReceive,))
    recvThread.start()

    connectionSend = pika.BlockingConnection(pika.ConnectionParameters(host="localhost"))
    channelSend = connectionSend.channel()

    try:
        channelSend.exchange_declare('ml2server', exchange_type='direct')
        channelSend.queue_declare(queue='ml2server-q1')
    except Exception:
        print('ml2server has already declared')

    channelSend.queue_bind(queue='ml2server-q1', exchange='ml2server', routing_key='ml2server-q1')
    sendThread = Thread(target=sendRegularMessage, args=(channelSend,))
    sendThread.start()

if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        print('Interrupted')
        try:
            sys.exit(0)
        except SystemExit:
            os._exit(0)
