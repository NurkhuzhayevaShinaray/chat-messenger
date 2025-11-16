package builder;

import Classes.Message;
import Classes.MessageType;
import Classes.User;

import java.time.LocalDateTime;

public interface IMessageBuilder
{
    public IMessageBuilder addChatId(int chatId);
    public IMessageBuilder addText(String text);
    public IMessageBuilder addUser(User user);
    public IMessageBuilder addType(MessageType type);

    public Message build();
}
