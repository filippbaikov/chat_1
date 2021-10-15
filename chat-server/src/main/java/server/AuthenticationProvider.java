package server;

public interface AuthenticationProvider {
    void init();
    String getUsernameByLoginAndPassword(String login, String password);
    void shutdown();
}
