package com.db.estudo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class SQLiteDBConfig {

    private static final String databaseFile = "db/local.db";

    public static Connection getConnection() throws SQLException {
        String jdbcURL = String.format("jdbc:sqlite:%s", databaseFile);
        return DriverManager.getConnection(jdbcURL);
    }

}
