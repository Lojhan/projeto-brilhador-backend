const jwt = require('jsonwebtoken');
let config = require('config');
let secret = config.get("secret");

module.exports = () => (req, res, next) => {
    if(req.headers != undefined) {
        var headers = req.headers
        if (isValidAndLegth(headers.authorization, 7)) {
            var json = getJsonFail()
            json.msg = "Você não possui autorização para acessar essa API";
            var list = req.headers.authorization.split(" ");
            if (list.length != 2) {
                res.status(401).send(json);
                return;
            }
            if (list[0].toLowerCase() != "bearer") {
                if (list[0].toLowerCase() != "basic") {
                    res.status(401).send(json);
                    return;
                } else {
                    next()
                    return
                }
            }
            if (list[0].toLowerCase() == "bearer") {
                var token = list[1]
                jwt.verify(token, secret, (err, authData) => {
                    if(err) {
                        req.session = null
                        next()
                    } else {
                        req.session = authData.session
                        req.session.token = token
                        next()
                    }
                });
                return
            }
        }
    }
    next()
};