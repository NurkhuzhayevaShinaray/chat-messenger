package strategies.action;

import Classes.Chat;
import strategies.ActionContext;

public class JoinChatStrategy implements ActionStrategy {

    @Override
    public void execute(ActionContext ctx) {
        try {
            System.out.print("Enter chat ID: ");
            int id = Integer.parseInt(ctx.sc.nextLine());

            Chat joined = ctx.api.joinChat(id, ctx.user);

            System.out.println("✔ Joined chat: " + joined.getChatName());

        } catch (Exception e) {
            System.out.println("❌ Cannot join: " + e.getMessage());
        }
    }
}
