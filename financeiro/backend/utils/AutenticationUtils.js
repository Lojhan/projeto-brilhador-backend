validarBasicAuthLogin = function (req, res, next, callback) {
    var json = {}
    json.status = "NOK";
    json.code = 0;
    json.msg = "Você não possui autorização para acessar essa API";
    if (req.headers.authorization == undefined) {
        res.status(401).send(json);
    } else {
        var list = req.headers.authorization.split(" ");
        if (list.length == 2) {
            if (list[0].toLowerCase() == "basic") {
                if (list[1] == "YXNrZ2ZrZGtsZmpzbGtmajpzZGZzNDUxZHM1ZnNkcw==") {
                    callback();
                } else {
                    res.status(401).send(json);
                }
            } else {
                res.status(401).send(json);
            }
        } else {
            res.status(401).send(json);
        }
    }
}
getInformationsEstacionamento = async function (req, res, next, callback) {
    try {
        var raw = req.body;
        var json = {}
        json.status = "NOK";
        json.code = 0;
        json.msg = "Você não possui autorização para acessar essa API";
        if (isNotValid(raw.code)) {
            res.status(401).send(json);
            return;
        }
        if (!isValidAndLegth(raw.user, 3)) {
            res.status(401).send(json);
            return;
        }
        if (!isValidAndLegth(raw.nomeEmpresa,3)) {
            res.status(401).send(json);
            return;
        }
        // var list = req.headers.authorization.split(" ");
        // if(list.length != 2){ res.status(401).send(json); return; }
        // if(list[0].toLowerCase() != "bearer") { res.status(401).send(json); return; }
        var sql = "SELECT NOMEFANTASIA,DATABASECENTRAL FROM central.empresa WHERE NOME = ?"
        var rs = await req.connectionAsync.query(sql, [raw.nomeEmpresa])
        if (rs.length == 0) {
            res.status(401).send(json);
            return;
        }
        var base = rs[0].DATABASECENTRAL;
        var nomeFantasiaEmpresa = rs[0].NOMEFANTASIA;
        sql = "SELECT usuario FROM " + base + ".codelogin WHERE usuario = ? AND code = ?"
        rs = await req.connectionAsync.query(sql, [raw.user, raw.code])
        if (rs.length == 0) {
            json.msg = "Usuário ou código errados!"
            res.status(401).send(json);
            return;
        }
        var infos = {}
        infos.empresa = raw.nomeEmpresa
        infos.base = base
        infos.user = raw.user
        infos.authorization = raw.authorization
        infos.code = raw.authorization
        infos.nomeFantasiaEstacionamento = nomeFantasiaEmpresa
        callback(infos)
    } catch (e) {
        console.log(e)
        var json = {}
        json.status = "NOK";
        json.code = 0;
        json.msg = "Você não possui autorização para acessar essa API";
        res.status(401).send(json);
    }
}
verifyAccessModuleADM = async function (req, res, next, modulo, callback) {
    try {
        if(req.session.acessoPonto == undefined)req.session.acessoPonto = []
        if(req.session.acessoPonto[req.session.ponto] == undefined)req.session.acessoPonto[req.session.ponto] = {}
        if(req.session.acessoPonto[req.session.ponto].acessoModulos == undefined)req.session.acessoPonto[req.session.ponto].acessoModulos = []
        if(req.session.acessoPonto[req.session.ponto].acessoModulos[modulo.str] == undefined)req.session.acessoPonto[req.session.ponto].acessoModulos[modulo.str] = []
        if(req.session.acessoPonto[req.session.ponto].acessoModulos[modulo.str].acesso != undefined && req.session.acessoPonto[req.session.ponto].acessoADM != undefined){
            if(req.session.acessoPonto[req.session.ponto].acessoModulos[modulo.str].acesso && req.session.acessoPonto[req.session.ponto].acessoADM){
                callback(true)
            }else{
                callback(false)
            }
            return
        }

        var acessoModulo = false
        sql = "SELECT acesso FROM " + req.session.baseEmpresa + ".definicaoadm WHERE tipo = ? AND tipoacesso = ?"
        var rsAcessoUser = await req.connectionAsync.query(sql, [req.session.funcao, ModuleAccess.ADM.cod])
        if (rsAcessoUser.length != 0 && rsAcessoUser[0].acesso){
            acessoModulo = true
            req.session.acessoPonto[req.session.ponto].acessoModulos[modulo.str].acesso = true
        }else{
            acessoModulo = false
            req.session.acessoPonto[req.session.ponto].acessoModulos[modulo.str].acesso = false
        }

        var acessoADMPonto = false
        sql = "SELECT acesso FROM " + req.session.baseEmpresa + ".acessoponto WHERE cargo = ? AND ponto = ?"
        var rsAcesso = await req.connectionAsync.query(sql, [req.session.funcao, req.session.ponto])
        if (rsAcesso.length != 0 && rsAcesso[0].acesso) {
            acessoADMPonto = true
            req.session.acessoPonto[req.session.ponto].acessoADM = true
        }else{
            acessoADMPonto = false
            req.session.acessoPonto[req.session.ponto].acessoADM = false
        }

        var acesso = acessoADMPonto && acessoModulo
        req.session.acessoPonto[req.session.ponto].acessoOperacional = true
        if (modulo == ModuleAccess.ADM) {
            callback(acesso)
            return
        }
        if(acesso){
            callback(acesso)
            return
        }
        var json = {}
        req.session.ponto = undefined
        json.status = "NOK";
        json.code = 1001;
        json.msg = "Você não pode acessar o esse modulo!";
        res.status(401).send(json)
        return
    } catch (e) {
        console.log(e)
        await registerError(req, e)
        req.session.ponto = undefined
        var json = {}
        json.status = "NOK";
        json.code = 1001;
        json.msg = "Você não pode acessar o esse modulo!";
        res.status(401).send(json);
        return
    }
}