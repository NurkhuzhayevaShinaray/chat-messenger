package decorator;
import Classes.Message;
import Classes.User;
import java.util.Scanner;

public class TextMessage implements SendingTypes{
    private int chatId;
    private User user;

    public TextMessage( int chatId, User user) {
        this.chatId = chatId;
        this.user = user;
    }

    @Override
    public Message createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your text-message: ");
        String text = sc.nextLine();
        Message message = new Message();
        message.setChatId(chatId);
        message.setUser(user);
        message.setText(text);
        return message;
    }
}
