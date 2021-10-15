package server;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAuthenticationProvider implements AuthenticationProvider{
    private ConnectionDb connectionDb;

    @Override
    public void init() {
        connectionDb = new ConnectionDb();

    }
    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        String query = String.format("select nickname from users login = '%s' and password = '%s';", login, password);
        try (ResultSet rs = connectionDb.getStmt().executeQuery(query)){

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public void shutdown() {
        connectionDb.close();

    }
}
