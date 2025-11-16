package factory;
import Classes.Chat;

public class PrivateChat implements ChatType {
    private String chatName;
    private int type;
    private int ownerId;

    public PrivateChat(String chatName, int type, int ownerId) {
        this.chatName = chatName;
        this.type = type;
        this.ownerId = ownerId;
    }

    @Override
    public Chat createChat() {
         Chat chat = new Chat();
         chat.setChatName(chatName);
         chat.setType(type);
         chat.setOwnerId(ownerId);
        return chat;
    }
}
