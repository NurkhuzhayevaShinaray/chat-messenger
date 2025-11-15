package decorator;

import Classes.Message;

public class TranslateDecorator extends Decorator{
    public TranslateDecorator(SendingTypes sendingTypes){
        super(sendingTypes);
    }

    @Override
    public Message createMessage() {
        return null;
    }
}
