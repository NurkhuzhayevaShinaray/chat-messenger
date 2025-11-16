package decorator;
import Classes.Message;
import Classes.MessageType;
import Classes.User;
import builder.MessageBuilder;

import java.util.Scanner;

public class TextMessage implements SendingTypes{
    private int chatId;
    private User user;

    public TextMessage(int chatId, User user) {
        this.chatId = chatId;
        this.user = user;
    }

    @Override
    public Message createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your text-message: ");
        String text = sc.nextLine();
        Message message = new MessageBuilder()
                .addUser(user)
                .addText(text)
                .addChatId(chatId)
                .addType(MessageType.TEXT)
                .build();
        return message;
    }
}