import java.io.*;
import java.net.*;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws Exception {
        ChatApi api = new ChatApi("http://localhost:5000");

        // Регистрация
        User u = new User();
        u.setUserName("Ayawaska");
        u.setPassword("123123");

        User created = api.login(u);
        System.out.println("User ID: " + created.getUserId());

        // Создать чат
        Chat chat = new Chat();
        chat.setChatName("Chat");
        chat.setOwnerId(created.getUserId());

        Chat createdChat = api.createChat(chat);
        System.out.println("Chat ID: " + createdChat.getChatId());
    }

}