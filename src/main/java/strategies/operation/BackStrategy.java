package strategies.operation;

public class BackStrategy implements strategies.operation.OperationStrategy {
    @Override
    public void run(int chatId) {
        System.out.println("Going back...");
    }
}
