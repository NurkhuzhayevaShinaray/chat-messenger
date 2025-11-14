package strategies;

import api.ChatApi;
import Classes.*;
import strategies.action.ActionStrategy;

import java.util.Scanner;

public class ActionContext {

    private ActionStrategy strategy;

    public final ChatApi api;
    public final User user;
    public final Scanner sc;

    public ActionContext(ChatApi api, User user, Scanner sc) {
        this.api = api;
        this.user = user;
        this.sc = sc;
    }

    public void setStrategy(ActionStrategy s) {
        this.strategy = s;
    }

    public void execute() {
        strategy.execute(this);
    }
}
