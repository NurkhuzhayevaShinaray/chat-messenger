package strategies.action;

import Classes.Chat;
import Classes.User;
import strategies.ActionContext;

public class CreateChatStrategy implements ActionStrategy {
    @Override
    public void execute(ActionContext ctx) {
        try {
            System.out.print("Enter chat name: ");
            String name = ctx.sc.nextLine();

            Chat c = new Chat();
            c.setChatName(name);
            c.setOwnerId(ctx.user.getUserId());
            c.setType(1); // normal group

            Chat created = ctx.api.createChat(c);

            System.out.println("✔ Chat created! ID = " + created.getChatId());

        } catch (Exception e) {
            System.out.println("❌ ERROR: " + e.getMessage());
        }
    }
}
