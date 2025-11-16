package builder;

import Classes.User;

public class UserBuilder implements IUserBuilder {

    private final User user = new User();

    @Override
    public IUserBuilder addName(String name) {
        user.setUserName(name);
        return this;
    }

    @Override
    public IUserBuilder addPassword(String password) {
        user.setPassword(password);
        return this;
    }

    @Override
    public User build() {
        return user;
    }
}