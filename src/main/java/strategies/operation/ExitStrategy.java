package strategies.operation;

public class ExitStrategy implements strategies.operation.OperationStrategy {
    @Override
    public void run(int chatId) {
        System.out.println("Bye!");
        System.exit(0);
    }
}
