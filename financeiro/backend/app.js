var express = require('express');
var cookieParser = require('cookie-parser');

//MySQL
const pool = require('./middleware/PoolMySQL');

//Middleware
const connectionMiddleware = require('./middleware/ConnectionMiddleware');
const authHeaderMiddleware = require('./middleware/AuthHeaderMiddleware');
const sessionExpirateMiddleware = require('./middleware/SessionExpirateMiddleware');

//Session
const session = require('express-session');

//Utils
require('./utils/VerifyUtils');
require('./utils/AutenticationUtils');

var app = express();

//Parser
app.use(authHeaderMiddleware());
app.use(sessionExpirateMiddleware());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());

app.use(connectionMiddleware(pool));
app.use(session({
    secret: '123456789abc',
    name: "auth",
    proxy: true,
    resave: false,
    saveUninitialized: false,
}));

var indexRouter = require('./routes/index');

app.use('/', indexRouter);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var json = {}
  json.status = "NOT"
  json.msg = "NOT FOUND"
  res.status(404).send(json)
});

// error handler
app.use((errsystem, req, res, next) => {
  if(errsystem){
      console.log(errsystem)
      var json = {};
      json.status = "NOK";
      json.code = 0;
      json.msg = "Não foi possível completar sua solicitação!"
      res.status(500).send(json);
  }else{
    next();
  }
});

module.exports = app;
