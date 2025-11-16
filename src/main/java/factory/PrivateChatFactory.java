package factory;

public class PrivateChatFactory implements ChatFactory {
    @Override
    public ChatType createChatType() {
        return new PrivateChat();
    }
}
