package builder;

import Classes.Message;
import Classes.MessageType;
import Classes.User;

public class MessageBuilder implements IMessageBuilder{

    private final Message message = new  Message();

    @Override
    public IMessageBuilder addChatId(int chatId) {
        message.setChatId(chatId);
        return this;
    }

    @Override
    public IMessageBuilder addText(String text) {
        message.setText(text);
        return this;
    }

    @Override
    public IMessageBuilder addUser(User user) {
        message.setUser(user);
        return this;
    }

    @Override
    public IMessageBuilder addType(MessageType type) {
        message.setType(type);
        return this;
    }

    @Override
    public Message build() {
        return message;
    }
}
