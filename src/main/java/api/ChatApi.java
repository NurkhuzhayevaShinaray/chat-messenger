package api;

import Classes.*;


public class ChatApi {
    private final ApiClient client;

    public ChatApi(String baseUrl) {
        client = new ApiClient(baseUrl);
    }

    // ---------------- Пользователи ----------------

    public User register(User user) throws Exception {
        return client.post("/api/chat/register", user, User.class);
    }

    public User login(User user) throws Exception {
        return client.post("/api/chat/login", user, User.class);
    }

    // ---------------- Чаты ----------------

    public int createPrivateChat(int u1, int u2) throws Exception {
        PrivateChatRequest req = new PrivateChatRequest();
        req.setUser1(u1);
        req.setUser2(u2);
        return client.post("/api/chat/private/create", req, Integer.class);
    }

    public Chat createChat(Chat chat) throws Exception {
        return client.post("/api/chat/create", chat, Chat.class);
    }

    public Chat joinChat(int chatId, User user) throws Exception {
        return client.post("/api/chat/" + chatId + "/join", user, Chat.class);
    }

    public void addUserToGroup(int chatId, int owner, int newUser) throws Exception {
        AddUserRequest req = new AddUserRequest();
        req.setOwner(owner);
        req.setNewUser(newUser);
        client.post("/api/chat/" + chatId + "/addUser", req, Object.class);
    }

    public void leaveChat(int chatId, User user) throws Exception {
        client.post("/api/chat/" + chatId + "/leave", user, Object.class);
    }

    public void clearChat(int chatId, User user) throws Exception {
        client.post("/api/chat/" + chatId + "/clear", user, Object.class);
    }

    public void deleteChat(int chatId, User user) throws Exception {
        client.delete("/api/chat/" + chatId + "/delete", Object.class);

    }

    public Chat getChat(int chatId) throws Exception {
        return client.get("/api/chat/" + chatId + "/getChat", Chat.class);
    }

    public void sendMessage(int chatId, Message msg) throws Exception {
        client.post("/api/chat/" + chatId + "/send", msg, Object.class);
    }

    public void deleteMessage(int chatId, int msgId, User user) throws Exception {
        client.delete("/api/chat/" + chatId + "/message/" + msgId, user);
    }

    public User[] getMembers(int chatId) throws Exception {
        return client.get("/api/chat/" + chatId + "/members", User[].class);
    }

    public Message[] getMessages(int chatId) throws Exception {
        return client.get("/api/chat/" + chatId + "/messages", Message[].class);
    }

    public Chat[] getChatsOfUser(int userId) throws Exception {
        return client.get("/api/chat/" + userId + "/chats", Chat[].class);
    }
}
