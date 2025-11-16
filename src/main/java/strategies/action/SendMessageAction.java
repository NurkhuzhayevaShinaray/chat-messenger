package strategies.action;

import Classes.Message;
import Classes.MessageType;
import adapter.VoskAdapter;
import decorator.*;
import visitor.SendVisitor;
import strategies.ActionContext;

public class SendMessageAction implements ActionStrategy {

    @Override
    public void execute(ActionContext ctx) {

        System.out.println("Choose message type:");
        System.out.println("1. Text");
        System.out.println("2. Voice");

        String messageTypeChoice = ctx.sc.nextLine();

        System.out.println("Choose sending type:");
        System.out.println("1. Common");
        System.out.println("2. Translate");
        System.out.println("3. Expiring");
        System.out.println("4. Translate + Expiring");

        String sendingTypeChoice = ctx.sc.nextLine();

        SendingTypes creator;

        switch (messageTypeChoice) {
            case "1" -> creator = new TextMessage(ctx.api.getCurrentChatId(), ctx.user);
            case "2" -> creator = new  VoiceRecorder(ctx.api.getCurrentChatId(), ctx.user , new VoskAdapter());
            default -> {System.out.println("Unknown option.");
                return;
            }
        }
        switch (sendingTypeChoice) {
            case "1" -> {}
            case "2" -> creator = new TranslateDecorator(creator);
            case "3" -> creator = new ExpiringDecorator(creator);
            case "4" -> creator = new ExpiringDecorator(new TranslateDecorator(creator));
            default -> {System.out.println("Unknown option.");
                return;
            }
        }

        Message msg = creator.createMessage();

        msg.accept(new SendVisitor(ctx.api));
    }
}