package builder;

import Classes.User;

public interface IUserBuilder {

    public IUserBuilder addName(String name);
    public IUserBuilder addPassword(String password);

    public User build();
}
