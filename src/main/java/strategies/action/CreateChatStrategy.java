package strategies.action;

import Classes.Chat;
import Classes.User;
import factory.*;
import strategies.ActionContext;

public class CreateChatStrategy implements ActionStrategy {
    @Override
    public void execute(ActionContext ctx) {
        try {
            System.out.println("Choose chat type:");
            System.out.println("1) Private Chat");
            System.out.println("2) Group Chat");
            System.out.println("3) Channel");
            System.out.print("Your choice: ");

            String typeChoice = ctx.sc.nextLine();

            System.out.print("Enter chat name: ");
            String name = ctx.sc.nextLine();

            ChatFactory factory;
            Chat chat;

            switch (typeChoice) {
                case "1":
                    System.out.print("Enter second user ID for private chat: ");
                    int secondUserId = Integer.parseInt(ctx.sc.nextLine());

                    factory = new PrivateChatFactory();
                    chat = factory.createChat(name, ctx.user.getUserId());


                    Chat createdPrivate = ctx.api.createChat(chat, secondUserId);
                    System.out.println("Private chat created! ID = " + createdPrivate.getChatId());
                    break;

                case "2":
                    factory = new GroupChatFactory();
                    chat = factory.createChat(name, ctx.user.getUserId());

                    Chat createdGroup = ctx.api.createChat(chat);
                    System.out.println("Group chat created! ID = " + createdGroup.getChatId());
                    break;

                case "3":
                    factory = new ChannelChatFactory();
                    chat = factory.createChat(name, ctx.user.getUserId());

                    Chat createdChannel = ctx.api.createChat(chat);
                    System.out.println("Channel created! ID = " + createdChannel.getChatId());
                    break;

                default:
                    System.out.println("Invalid chat type!");
                    return;
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}