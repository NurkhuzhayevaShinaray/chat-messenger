package builder;

import Classes.Chat;

public class ChatBuilder implements IChatBuilder {

    private final Chat chat = new Chat();

    @Override
    public IChatBuilder addName(String name) {
        chat.setChatName(name);
        return this;
    }

    @Override
    public IChatBuilder addType(int type) {
        chat.setType(type);
        return this;
    }

    @Override
    public IChatBuilder addOwnerId(int ownerId) {
        chat.setOwnerId(ownerId);
        return this;
    }

    @Override
    public Chat build() {
        return chat;
    }
}
