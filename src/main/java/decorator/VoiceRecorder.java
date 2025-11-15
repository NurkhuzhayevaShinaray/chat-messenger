package decorator;
import Classes.Message;
import Classes.User;
import adapter.Speech;
import adapter.VoskLibrary;
import java.time.LocalDateTime;

public class VoiceRecorder implements SendingTypes {
    public int chatId;
    public int messageId;
    private User user;
    private Speech speech;
    private VoskLibrary vosk = new VoskLibrary("src/main/resources/vosk-model-small-en-us-0.15/vosk-model-small-en-us-0.15");

    public VoiceRecorder(int chatId, int messageId, User user, Speech speech) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.user = user;
        this.speech = speech;
    }


    @Override
    public Message createMessage() {
        System.out.println("Recording voice recorder: ");
        String recognizedText = speech.recognize();
        Message message = new Message();
        message.setChatId(chatId);
        message.setMessageId(messageId);
        message.setUser(user);
        message.setText(recognizedText);
        message.setCreatedAt(LocalDateTime.now());
        return message;
    }
}