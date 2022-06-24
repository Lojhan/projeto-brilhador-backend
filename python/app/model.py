import uuid
from pydantic import BaseModel, Field, EmailStr

class User(BaseModel):
    id: uuid.UUID = Field(default_factory=uuid.uuid4)
    name: str = Field(...)
    email: str = Field(...)
    cpf: str = Field(...)
    phone: str = Field(...)
    role: str = Field(...)

class TokenResponse(BaseModel):
    valid: bool = Field(default=False)
    user: User = Field(default=None)