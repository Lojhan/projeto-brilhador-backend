import uuid
from pydantic import BaseModel, Field, EmailStr
class Address(BaseModel):
    cep: str
    logradouro: str
    complemento: str
    bairro: str
    localidade: str
    uf: str
    ibge: str
    gia: str
    ddd: str
    siafi: str

    @staticmethod 
    def fromDict(data: dict):
        return Address(**data)
    
    def toDict(self):
        return self.dict()
class User(BaseModel):
    id: str = Field(default_factory=lambda: str(uuid.uuid4()))
    name: str = Field(...)
    email: str = Field(...)
    cpf: str = Field(...)
    phone: str = Field(...)
    role: str = Field(...)
    address: Address = Field(default=None)

    @staticmethod
    def fromDict(data: dict):
        return User(**data)

    def toDict(self):
        return self.dict()
class TokenResponse(BaseModel):
    valid: bool = Field(default=False)
    user: User = Field(default=None)
class SetCepRequestDto(BaseModel):
    cep: str