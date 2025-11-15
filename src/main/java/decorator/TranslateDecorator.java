package decorator;
import Classes.Message;
import java.util.Scanner;

public class TranslateDecorator extends Decorator{
    public TranslateDecorator(SendingTypes sendingTypes){
        super(sendingTypes);
    }

    @Override
    public Message createMessage() {
        Message message = super.createMessage();
        String text = message.getText();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose which language you want translate to: ");
        System.out.println("1.Kazakh");
        System.out.println("2.Russian");
        System.out.println("3.English");
        String choice = sc.nextLine();
        String translated = switch (choice){
            case "1" -> "Message was translated to Kazakh";
            case "2" -> "Message was translated to Russian";
            case "3" -> "Message was translated to English";
            default -> text;
        };
        message.setText(translated);
        return message;
    }
}
