

from fastapi import Depends, Request, APIRouter

from app.model import User
from app.auth.auth_bearer import JWTBearer

router = APIRouter()

@router.get("/", tags=["root"])
async def read_root() -> dict:
    return {"message": "Welcome to your blog!."}

@router.get("/posts", dependencies=[Depends(JWTBearer())], tags=["posts"])
async def add_post(request: Request) -> dict:
    user: User = request._state.user
    print(user)

    return { "hello": "world 2" }