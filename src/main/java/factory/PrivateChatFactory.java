package factory;

import Classes.Chat;

public class PrivateChatFactory implements ChatFactory {
    @Override
    public Chat createChat(String chatName, int ownerId) {
        Chat chat = new Chat();
        chat.setChatName(chatName);
        chat.setOwnerId(ownerId);
        chat.setType(0);
        return chat;
    }
}
