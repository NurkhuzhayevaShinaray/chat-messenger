package factory;

import Classes.Chat;

public class GroupChatFactory implements ChatFactory{
    @Override
    public Chat createChat(String chatName, int ownerId) {
        Chat chat = new Chat();
        chat.setChatName(chatName);
        chat.setOwnerId(ownerId);
        chat.setType(1);
        return chat;
    }
}
