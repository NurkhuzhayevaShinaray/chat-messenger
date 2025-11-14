package strategies.action;

import strategies.ActionContext;

public interface ActionStrategy {
    void execute(ActionContext ctx);
}
