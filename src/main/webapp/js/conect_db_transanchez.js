/*Archivo para hacer la conexion a base de datos*/

var mysql = require('mysql');

var con = mysql.createConnection({
    host: "localhost/phpmyadmin",
    user: "root@localhost",
    password: "",
    database: "transanchez"
});

$(document).ready(function () {

    $('#logueo').on('click', connMySQL);
});

/*con.connect(function(err) {
 if (err) throw err;
 console.log("Connected!");
 });**/

/*con.connect(function(err) {
 if (err) throw err;
 console.log("Connected!");
 sql:"SELECT `ID_EMPLEADO`, `TIPO_EMPLEADO` FROM `CREDENCIAL_EMPLE` INNER JOIN `EMPLEADO` ON `ID_EMPLEADO` = `ID_EMPLE` WHERE `USUARIO` = " + $('#user').val() + " AND PASSWORD = " + $('#key').val();
 con.query(sql, function (err, result) {
 if (err) throw err;
 console.log("Result: " + result);
 });
 });*/

function connMySQL(err) {
    con.connect(function (err) {
        if (err)
            throw err;
        console.log("Connected!");
        sql:"SELECT `ID_EMPLEADO`, `TIPO_EMPLEADO` FROM `CREDENCIAL_EMPLE` INNER JOIN `EMPLEADO` ON `ID_EMPLEADO` = `ID_EMPLE` WHERE `USUARIO` = " + $('#user').val() + " AND PASSWORD = " + $('#key').val();
        con.query(sql, function (err, result) {
            if (err)
                throw err;
            console.log("Result: " + result);
        });
    });

}
;