package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionDb {
    private Connection connection;
    private Statement stmt;

    public Statement getStmt() {
        return stmt;
    }

    public ConnectionDb() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:database.db3");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Невозможно подключится к БД!!!");
        }

    }

    public void close(){
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
