package decorator;

import Classes.Message;

public abstract class Decorator implements SendingTypes {
    protected SendingTypes sendingTypes;
    public Decorator(SendingTypes sendingTypes){
        this.sendingTypes = sendingTypes;
    }

    public Message createMessage() {
        return sendingTypes.createMessage();
    }
}