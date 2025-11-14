package strategies.action;

import Classes.Chat;
import Classes.Message;
import strategies.ActionContext;

public class OpenChatStrategy implements ActionStrategy {

    @Override
    public void execute(ActionContext ctx) {
        try {
            System.out.print("Chat ID: ");
            int id = Integer.parseInt(ctx.sc.nextLine());

            Chat chat = ctx.api.getChat(id);

            while (true) {
                System.out.println("\n--- CHAT: " + chat.getChatName() + " ---");
                System.out.println("1) View messages");
                System.out.println("2) Send message");
                System.out.println("3) Delete message");
                System.out.println("4) Back");

                String c = ctx.sc.nextLine();

                switch (c) {
                    case "1":
                        showMessages(ctx, id);
                        break;

                    case "2":
                        sendMessage(ctx, id);
                        break;

                    case "3":
                        deleteMessage(ctx, id);
                        break;

                    case "4":
                        return;

                    default:
                        System.out.println("Invalid option");
                }
            }

        } catch (Exception e) {
            System.out.println("❌ ERROR: " + e.getMessage());
        }
    }

    private void showMessages(ActionContext ctx, int chatId) throws Exception {
        Message[] msgs = ctx.api.getMessages(chatId);

        if (msgs.length == 0) {
            System.out.println("(empty)");
            return;
        }

        for (Message m : msgs) {
            System.out.println(m.getUserId() + ": " + m.getText());
        }
    }

    private void sendMessage(ActionContext ctx, int chatId) throws Exception {
        System.out.print("Text: ");
        String text = ctx.sc.nextLine();

        Message m = new Message();
        m.setText(text);
        m.setChatId(chatId);
        m.setUserId(ctx.user.getUserId());

        ctx.api.sendMessage(chatId, m);
    }

    private void deleteMessage(ActionContext ctx, int chatId) throws Exception {
        System.out.print("Message ID to delete: ");
        int msgId = Integer.parseInt(ctx.sc.nextLine());

        ctx.api.deleteMessage(chatId, msgId, ctx.user);
    }
}
