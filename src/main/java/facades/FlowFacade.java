package facades;

import Classes.Chat;
import Classes.Message;
import Classes.User;
import api.ChatApi;


public class FlowFacade {

    private final ChatApi api;

    public FlowFacade(ChatApi api) {
        this.api = api;
    }

    public Chat createGroup(String name, int ownerId) throws Exception {
        Chat c = new Chat();
        c.setChatName(name);
        c.setOwnerId(ownerId);
        c.setType(1); // 1 = group

        return api.createChat(c);
    }

    public Chat joinChat(int chatId, User user) throws Exception {
        return api.joinChat(chatId, user);
    }

    public void sendMessage(int chatId, User user, String txt) throws Exception {
        Message m = new Message();
        m.setChatId(chatId);
        m.setUser(user);
        m.setText(txt);

        api.sendMessage(chatId, m);
    }

    public Message[] getMessages(int chatId) throws Exception {
        return api.getMessages(chatId);
    }
}

