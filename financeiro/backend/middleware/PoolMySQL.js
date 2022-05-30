const mysql = require('mysql');

var fs = require('fs');
var config = JSON.parse(fs.readFileSync('./config/banco.json', 'utf8'));

const pool = mysql.createPool({
    connectionLimit: 15,
    host : config.host,
    port: config.port,
    user : config.username,
    password : config.password,
    database : config.database
});

console.log('pool => criado');

pool.on('release', () => console.log('pool => conexão retornada'));

process.on('SIGINT', () => pool.end(err => {
    if(err) return console.log(err);
    console.log('pool => fechado');
    process.exit(0);
}));

module.exports = pool;