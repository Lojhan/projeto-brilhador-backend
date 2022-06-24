from fastapi import FastAPI
from app.messaging.pika import Pika
from app.router import router

pika = Pika.getInstance()

app = FastAPI()

app.include_router(router, tags=["root"])
