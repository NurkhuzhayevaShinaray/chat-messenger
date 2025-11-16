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
        System.out.println("3. Text + Translate");
        System.out.println("4. Text + Expiring");

        String choice = ctx.sc.nextLine();

        SendingTypes creator;

        switch (choice) {
            case "1" ->
                    creator = new TextMessage(ctx.api.getCurrentChatId(), ctx.user);

            case "2" ->
                creator = new  VoiceRecorder(ctx.api.getCurrentChatId(), ctx.user , new VoskAdapter());


            case "3" ->
                    creator = new TranslateDecorator(
                            new TextMessage(ctx.api.getCurrentChatId(), ctx.user));

            case "4" ->
                    creator = new ExpiringDecorator(
                            new TextMessage(ctx.api.getCurrentChatId(), ctx.user));

            default -> {
                System.out.println("Unknown option.");
                return;
            }
        }

        Message msg = creator.createMessage();

        msg.accept(new SendVisitor(ctx.api));
    }
}