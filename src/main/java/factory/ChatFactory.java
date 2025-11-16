package factory;

import Classes.Chat;

public interface ChatFactory {
    Chat createChat(String chatName, int ownerId);

}