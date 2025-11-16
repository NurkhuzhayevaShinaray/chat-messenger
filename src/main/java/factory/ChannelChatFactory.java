package factory;

import Classes.Chat;

public class ChannelChatFactory implements ChatFactory{
    @Override
    public Chat createChat(String chatName, int ownerId) {
        Chat chat = new Chat();
        chat.setChatName(chatName);
        chat.setOwnerId(ownerId);
        chat.setType(2);
        return chat;
    }
}
