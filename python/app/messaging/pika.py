import pika

class Pika():
    channel = None
    connection = None
    instance = None
    def __init__(self):
        if not self.instance:
            self.connection = pika.BlockingConnection(
                pika.URLParameters(
                    'amqp://guest:guest@rabbitmq-server:5673/%2F'
                )
            )
            self.channel = self.connection.channel()

    @staticmethod
    def getInstance():
        if not Pika.instance:
            Pika.instance = Pika()
        return Pika.instance

    def declare_queue(self, queue) -> None:
        self.channel.queue_declare(queue, durable=True)

    def publish_message(self, exchange='', routing_key='hello', body="empty") -> None:
        self.channel.basic_publish(exchange=exchange, routing_key=routing_key, body=body)

    def __exit__(self):
        self.connection.close()