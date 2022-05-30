let jwt = require('jsonwebtoken');
let config = require('config');
let secret = config.get("secret");

exports.auth = async (req, res, next) => {
    var json = getJsonFail()
    var body = req.body
    if(isNotValid(body.secret) || body.secret != "dsf2sd56f5ds1f56sd1f65sd1df65sd5f5ssdf65")json.msg = "Secret invalido!"
    if(isNotValid(body.credential) || body.credential != "dsa551fd5sfd5asds56fsdsd548dsgd5f")json.msg = "Credential invalido!"
    if(isValid(json.msg)){
        res.status(500).send(json)
        return
    }

    var session = {}
    session.feature = "Faturamento"
    session.expiresIn = 60 * 60 * 24
    var token = jwt.sign({session}, secret, {
        expiresIn: 60 * 60 * 24 // expires in 24 hours
    });

    var json = getJsonFail()
    json.code = 1
    json.status = "OK"
    json.msg = "Autenticado com sucesso!"
    json.token = token
    res.status(200).send(json)
}