exports.listaPagamentos = async (req, res, next) => {
    var json = getJsonFail()
    var sql = "SELECT * FROM contaspagar"
    var resSQL = await req.connectionAsync.query(sql, [])
    json.listaPagamentos = resSQL
    json.code = 1
    json.status = "OK"
    res.status(200).send(json)
}

exports.faturamentoMes = async (req, res, next) => {
    var json = getJsonFail()
    var body = req.body
    if(isNotValid(body.mes))json.msg = "Mês invalido!"
    if(isValid(json.msg)){
        res.status(500).send(json)
        return
    }
    var sql = "SELECT COUNT(valorDaVenda) AS `quantidadeVenda`, SUM(valorDaVenda) AS `somaDeVenda` FROM vendas WHERE MONTH(horaDaVenda) = ?"
    var resSQLFaturamento = await req.connectionAsync.query(sql, [body.mes])
    sql = "SELECT * FROM vendas WHERE MONTH(horaDaVenda) = ?"
    var resSQLVendas = await req.connectionAsync.query(sql, [body.mes])
    json.faturamento = resSQLFaturamento[0]
    json.listaVendas = resSQLVendas
    json.code = 1
    json.status = "OK"
    res.status(200).send(json)
}

exports.faturamentoAno = async (req, res, next) => {
    var json = getJsonFail()
    var body = req.body
    if(isNotValid(body.ano))json.msg = "Ano invalido!"
    if(isValid(json.msg)){
        res.status(500).send(json)
        return
    }
    var sql = "SELECT COUNT(valorDaVenda) AS `quantidadeVenda`, SUM(valorDaVenda) AS `somaDeVenda` FROM vendas WHERE YEAR(horaDaVenda) = ?"
    var resSQLFaturamento = await req.connectionAsync.query(sql, [body.ano])
    sql = "SELECT * FROM vendas WHERE YEAR(horaDaVenda) = ?"
    var resSQLVendas = await req.connectionAsync.query(sql, [body.ano])
    json.faturamento = resSQLFaturamento[0]
    json.listaVendas = resSQLVendas
    json.code = 1
    json.status = "OK"
    res.status(200).send(json)
}