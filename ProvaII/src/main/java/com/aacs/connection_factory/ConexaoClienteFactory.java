package com.aacs.connection_factory;

import java.sql.Connection;

/**
 * ClienteConexaoFactory fornece conexões sob demanda.
 * Em vez de armazenar uma Connection como campo, cada chamada cria/obtém
 * uma nova Connection a partir do respectivo provider (BD_MySQL_Clientes / BD_Postgres_Clientes).
 */
public class ConexaoClienteFactory {
    public Connection getMysqlConnection() {
        return new BD_MySQL_Clientes().getConnection();
    }

    public Connection getPgConnection() {
        return new BD_Postgre_Clientes().getConnection();
    }
}
