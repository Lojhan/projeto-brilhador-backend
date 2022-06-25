from fastapi import Depends, Request, APIRouter, HTTPException

from app.model import User, SetCepRequestDto
from app.auth.auth_bearer import JWTBearer
from app.messaging.pika import Pika
from app.services.viacep import ViaCepService
from app.messaging.kafka import Kafka
import json


router = APIRouter()

pika = Pika.getInstance()

kafka = Kafka.getInstance()
# kafka.declare_topic('deconto')

routing_key = "viacep-add-usr-addr"

pika.declare_queue(routing_key)

viaCepService = ViaCepService()

@router.post("/set-user-address", dependencies=[Depends(JWTBearer())], tags=["address"])
async def add_post(
    body: SetCepRequestDto,
    request: Request,
    ) -> dict:
    try:
        user: User = User.fromDict(request._state.user)
        addrinfo = viaCepService.getAddressInfo(body.cep)
        user.address = addrinfo
        body = json.dumps(user.toDict()).encode()
        kafka.publish_message(body)
        # pika.publish_message(routing_key=routing_key, body=body)
        return { "user": user }
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))