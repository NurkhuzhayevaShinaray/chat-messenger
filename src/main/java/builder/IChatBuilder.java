package builder;

import Classes.Chat;

public interface IChatBuilder {

    public IChatBuilder addName(String name);
    public IChatBuilder addType(int type);
    public IChatBuilder addOwnerId(int ownerId);

    public Chat build();
}
