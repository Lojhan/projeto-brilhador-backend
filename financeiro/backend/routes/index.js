var express = require('express');
var router = express.Router();
var controllerFinanceiro = require('../controllers/FinanceiroController')
var controllerAuth = require('../controllers/AuthController')
router.get('/', function(req, res, next) {
  res.status(200).send("OK")
});
router.post('/financeiro/auth', controllerAuth.auth)
router.get('/financeiro/listapagamentos', controllerFinanceiro.listaPagamentos)
router.post('/financeiro/faturamentomes', controllerFinanceiro.faturamentoMes)
router.post('/financeiro/faturamentoano', controllerFinanceiro.faturamentoAno)

module.exports = router;
