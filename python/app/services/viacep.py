
from select import select
import requests
from app.messaging.pika import Pika

class ViaCepService():
       
    def getAddressInfo(self, cep: str) -> dict:
        url = f"https://viacep.com.br/ws/{cep}/json/"
        response = requests.get(url)
        return response.json()
