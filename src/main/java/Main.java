import api.ChatApi;
import Classes.*;
import strategies.ActionContext;
import strategies.action.*;

import java.time.LocalDateTime;
import java.util.Scanner;
import adapter.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ChatApi api = new ChatApi("http://26.125.182.80:5000");

        VoskLibrary vosk = new VoskLibrary("src/main/resources/vosk-model-small-en-us-0.15");

        System.out.println(vosk.recognize());
        User currentUser = null;

        while (currentUser == null) {
            System.out.println("1) Register\n2) Login");
            String c = sc.nextLine();

            switch (c) {
                case "1":
                    currentUser = register(sc, api);
                    break;
                case "2":
                    currentUser = login(sc, api);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

        System.out.println("\nWelcome, " + currentUser.getUserName());

        ActionContext context = new ActionContext(api, currentUser, sc);

        while (true) {
            System.out.println("\n====== MENU ======");
            System.out.println("1) Create Chat");
            System.out.println("2) Join Chat");
            System.out.println("3) Open Chat");
            System.out.println("4) Exit");

            String c = sc.nextLine();

            switch (c) {
                case "1":
                    context.setStrategy(new CreateChatStrategy());
                    break;
                case "2":
                    context.setStrategy(new JoinChatStrategy());
                    break;
                case "3":
                    context.setStrategy(new OpenChatStrategy());
                    break;
                case "4":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid option");
                    continue;
            }

            context.execute();
        }
    }

    // ---------- REGISTRATION ----------
    public static User register(Scanner sc, ChatApi api) {
        while (true) {
            try {
                User u = new User();
                System.out.print("Enter username: ");
                u.setUserName(sc.nextLine());

                System.out.print("Enter password: ");
                u.setPassword(sc.nextLine());

                User result = api.register(u);

                if (result.getUserId() == -1) {
                    System.out.println("❌ Username already exists. Try again.");
                    continue;
                }

                System.out.println("✔ Registered successfully!");
                return result;

            } catch (Exception e) {
                System.out.println("API ERROR: " + e.getMessage());
            }
        }
    }

    // ---------- LOGIN ----------
    public static User login(Scanner sc, ChatApi api) {
        while (true) {
            try {
                User u = new User();
                System.out.print("Username: ");
                u.setUserName(sc.nextLine());

                System.out.print("Password: ");
                u.setPassword(sc.nextLine());

                User result = api.login(u);

                if (result.getUserId() == -1) {
                    System.out.println("❌ Wrong username or password.");
                    continue;
                }

                System.out.println("✔ Logged in!");
                return result;

            } catch (Exception e) {
                System.out.println("API ERROR: " + e.getMessage());
            }
        }
    }
}
