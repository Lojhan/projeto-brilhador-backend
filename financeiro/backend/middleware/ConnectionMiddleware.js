var util = require('util')

module.exports = pool => (req, res, next) => {
    pool.getConnection((err, connection) => {
        if(err) return next(err);
        console.log('pool => obteve conexão');
        req.connection = connection;
        req.connectionAsync = {}
        req.connectionAsync.query = util.promisify(connection.query).bind(connection);
        next();
        res.on('finish', () => {
            if(req.isAsync == undefined || !req.isAsync) {
                if (req.isTransaction) {
                    req.connection.query("COMMIT", [], function (err, rs) {
                        if (err) return next(err);
                        console.log("commit")
                        req.connection.release();
                    });
                } else {
                    req.connection.release();
                }
            }
        });
    });
};