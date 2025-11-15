package decorator;

import Classes.Message;

public class ExpiringDecorator extends Decorator{
    public ExpiringDecorator(SendingTypes sendingTypes){
        super(sendingTypes);
    }

    @Override
    public Message createMessage() {
        return null;
    }
}
