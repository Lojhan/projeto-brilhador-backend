module.exports = () => (req, res, next) => {
    req.absoluteUrl = req.url
    if(req.url.toLowerCase() == "/financeiro/auth"){
        next()
        return
    }
    if (isNotValid(req.headers) || isNotValid(req.session)) {
        var json = getJsonFail()
        json.msg = "Sua sessão expirou! Faça o login novamente!";
        json.code = 200
        res.status(401).send(json);
        return;
    }
    next()
};