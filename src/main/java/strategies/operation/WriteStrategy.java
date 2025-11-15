package strategies.operation;

import facades.FlowFacade;
import facades.AccountFacade;
import java.util.Scanner;

public class WriteStrategy implements strategies.operation.OperationStrategy {

    private final FlowFacade flow;
    private final AccountFacade acc;

    public WriteStrategy(FlowFacade f, AccountFacade a) {
        this.flow = f;
        this.acc = a;
    }

    @Override
    public void run(int chatId) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Text: ");
        String t = sc.nextLine();

        flow.sendMessage(chatId, acc.getCurrentUser(), t);
        System.out.println("Sent!");
    }
}
