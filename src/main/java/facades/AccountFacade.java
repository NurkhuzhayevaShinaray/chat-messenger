package facades;

import Classes.*;
import api.ChatApi;

public class AccountFacade {
    private final ChatApi api;
    private User currentUser;

    public AccountFacade(ChatApi api) {
        this.api = api;
    }

    public User register(String name, String pass) throws Exception {
        User u = new User();
        u.setUserName(name);
        u.setPassword(pass);
        currentUser = api.register(u);
        return currentUser;
    }

    public User login(String name, String pass) throws Exception {
        User u = new User();
        u.setUserName(name);
        u.setPassword(pass);
        currentUser = api.login(u);
        return currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
