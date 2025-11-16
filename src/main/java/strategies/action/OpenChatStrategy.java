package strategies.action;

import Classes.Chat;
import Classes.Message;
import Classes.User;
import strategies.ActionContext;

import java.util.Arrays;

public class OpenChatStrategy implements ActionStrategy {

    @Override
    public void execute(ActionContext ctx) {
        try {
            Chat[] chats = ctx.api.getChatsOfUser(ctx.user.getUserId());
            for(Chat chat : chats) {
                System.out.println("[" + chat.getChatId() + "] " + chat.getChatName());
            }
            System.out.print("Chat ID: ");
            int id = Integer.parseInt(ctx.sc.nextLine());

            Chat chat = ctx.api.getChat(id);
            boolean isOwner = chat.getOwnerId() == ctx.user.getUserId();
            int chatType = chat.getType();

            while (true) {
                System.out.println("\n CHAT: " + chat.getChatName() );


                if (chatType == 0) {
                    System.out.println("1) View messages");
                    System.out.println("2) Send message");
                    System.out.println("3) Clear chat");
                    System.out.println("4) Delete chat");
                    System.out.println("5) Back");
                }

                else if (chatType == 1) {
                    System.out.println("1) View messages");
                    System.out.println("2) Send message");
                    if (isOwner) {
                        System.out.println("3) Add user to chat");
                        System.out.println("4) Delete message");
                        System.out.println("5) Leave chat (delete)");
                        System.out.println("6) Back");
                    } else {
                        System.out.println("3) Delete my messages");
                        System.out.println("4) Leave chat");
                        System.out.println("5) Back");
                    }
                }

                else if (chatType == 2) {
                    System.out.println("1) View messages");
                    if (isOwner) {
                        System.out.println("2) Send message");
                        System.out.println("3) Delete message");
                        System.out.println("4) Leave channel (delete)");
                        System.out.println("5) Back");
                    } else {
                        System.out.println("2) Leave channel");
                        System.out.println("3) Back");
                    }
                }

                String c = ctx.sc.nextLine();


                if (chatType == 0) {
                    switch (c) {
                        case "1":
                            showMessages(ctx, id);
                            break;
                        case "2":
                            ctx.setStrategy(new SendMessageAction());
                            ctx.execute();
                            break;
                        case "3":
                            clearChat(ctx, id);
                            break;
                        case "4":
                            deleteChat(ctx, id);
                            return;
                        case "5":
                            return;
                        default:
                            System.out.println("Invalid option");
                    }
                }

                else if (chatType == 1) {
                    if (isOwner) {
                        switch (c) {
                            case "1":
                                showMessages(ctx, id);
                                break;
                            case "2":
                                ctx.setStrategy(new SendMessageAction());
                                ctx.execute();
                                break;
                            case "3":
                                addUserToChat(ctx, id);
                                break;
                            case "4":
                                deleteAnyMessage(ctx, id);
                                break;
                            case "5":
                                deleteChat(ctx, id);
                                return;
                            case "6":
                                return;
                            default:
                                System.out.println("Invalid option");
                        }
                    } else {
                        switch (c) {
                            case "1":
                                showMessages(ctx, id);
                                break;
                            case "2":
                                ctx.setStrategy(new SendMessageAction());
                                ctx.execute();
                                break;
                            case "3":
                                deleteMyMessages(ctx, id);
                                break;
                            case "4":
                                leaveChat(ctx, id);
                                return;
                            case "5":
                                return;
                            default:
                                System.out.println("Invalid option");
                        }
                    }
                }

                else if (chatType == 2) {
                    if (isOwner) {
                        switch (c) {
                            case "1":
                                showMessages(ctx, id);
                                break;
                            case "2":
                                ctx.setStrategy(new SendMessageAction());
                                ctx.execute();
                                break;
                            case "3":
                                deleteAnyMessage(ctx, id);
                                break;
                            case "4":
                                deleteChat(ctx, id);
                                return;
                            case "5":
                                return;
                            default:
                                System.out.println("Invalid option");
                        }
                    } else {
                        switch (c) {
                            case "1":
                                showMessages(ctx, id);
                                break;
                            case "2":
                                leaveChat(ctx, id);
                                return;
                            case "3":
                                return;
                            default:
                                System.out.println("Invalid option");
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void showMessages(ActionContext ctx, int chatId) throws Exception {
        Message[] msgs = ctx.api.getMessages(chatId);

        if (msgs.length == 0) {
            System.out.println("(empty)");
            return;
        }

        for (Message m : msgs) {
            String messageId = "[" + m.getMessageId() + "]";
            String formattedDate = m.getFormattedDate() != null ? m.getFormattedDate() : "unknown date";
            String userName = m.getUser() != null ? m.getUser().getUserName() : "Unknown";
            String text = m.getText() != null ? m.getText() : "";

            System.out.println(messageId + " (" + formattedDate + ") " + userName + ": " + text);
        }
    }

    private void deleteAnyMessage(ActionContext ctx, int chatId) throws Exception {
        System.out.print("Message ID to delete: ");
        int msgId = Integer.parseInt(ctx.sc.nextLine());
        ctx.api.deleteMessage(chatId, msgId, ctx.user);
    }

    private void deleteMyMessages(ActionContext ctx, int chatId) throws Exception {
        System.out.print("Your message ID to delete: ");
        int msgId = Integer.parseInt(ctx.sc.nextLine());


        Message[] messages = ctx.api.getMessages(chatId);
        boolean isMyMessage = false;

        for (Message m : messages) {
            if (m.getMessageId() == msgId && m.getUser() != null &&
                    m.getUser().getUserId() == ctx.user.getUserId()) {
                isMyMessage = true;
                break;
            }
        }

        if (isMyMessage) {
            ctx.api.deleteMessage(chatId, msgId, ctx.user);
            System.out.println("Your message deleted!");
        } else {
            System.out.println("You can only delete your own messages!");
        }
    }

    private void addUserToChat(ActionContext ctx, int chatId) throws Exception {
        System.out.print("Enter user ID to add: ");
        int newUserId = Integer.parseInt(ctx.sc.nextLine());

        ctx.api.addUserToGroup(chatId, ctx.user.getUserId(), newUserId);
        System.out.println("User added successfully!");
    }

    private void leaveChat(ActionContext ctx, int chatId) throws Exception {
        ctx.api.leaveChat(chatId, ctx.user);
        System.out.println("You left the chat!");
    }

    private void clearChat(ActionContext ctx, int chatId) throws Exception {
        ctx.api.clearChat(chatId, ctx.user);
        System.out.println("Chat cleared!");
    }

    private void deleteChat(ActionContext ctx, int chatId) throws Exception {
        ctx.api.deleteChat(chatId, ctx.user);
        System.out.println("Chat deleted!");
    }
}