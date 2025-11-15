package decorator;
import Classes.Message;
import Classes.User;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TextMessage implements SendingTypes{
    private int messageId;
    private int chatId;
    private User user;

    public TextMessage(int messageId, int chatId, User user) {
        this.messageId = messageId;
        this.chatId = chatId;
        this.user = user;
    }

    @Override
    public Message createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your text-message: ");
        String text = sc.nextLine();
        Message message = new Message();
        message.setMessageId(messageId);
        message.setChatId(chatId);
        message.setUser(user);
        message.setText(text);
        message.setCreatedAt(LocalDateTime.now());
        return message;
    }
}
