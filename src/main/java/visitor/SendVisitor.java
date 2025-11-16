package visitor;

import Classes.Message;
import api.ChatApi;

public record SendVisitor(ChatApi api) implements MessageVisitor {

    @Override
    public void visitText(Message m) {
        try {
            api.sendMessage(m);
            System.out.println("Text message sent ");
        } catch (Exception e) {
            System.out.println("Error sending text message: " + e.getMessage());
        }
    }

    @Override
    public void visitVoice(Message m) {
        try {
            api.sendMessage(m);
            System.out.println("Voice message sent ");
        } catch (Exception e) {
            System.out.println("Error sending voice message: " + e.getMessage());
        }
    }

    @Override
    public void visitTranslated(Message m) {
        try {
            api.sendMessage(m);
            System.out.println("Translated message sent ");
        } catch (Exception e) {
            System.out.println("Error sending translated message: " + e.getMessage());
        }
    }

    @Override
    public void visitExpiring(Message m) {
        try {
            api.sendMessage(m);
            System.out.println("Expiring message sent ");
        } catch (Exception e) {
            System.out.println("Error sending expiring message: " + e.getMessage());
        }
    }
}