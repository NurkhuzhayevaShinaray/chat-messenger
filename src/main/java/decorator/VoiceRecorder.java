package decorator;
import Classes.Message;
import Classes.MessageType;
import Classes.User;
import adapter.Speech;
import builder.MessageBuilder;

import java.time.LocalDateTime;

public class VoiceRecorder implements SendingTypes {
    public int chatId;
    private User user;
    private Speech speech;

    public VoiceRecorder(int chatId, User user, Speech speech) {
        this.chatId = chatId;
        this.user = user;
        this.speech = speech;
    }

    @Override
    public Message createMessage() {
        System.out.println("Recording voice recorder: ");
        String recognizedText = speech.recognize();
        Message message = new MessageBuilder()
                .addUser(user)
                .addText(recognizedText)
                .addChatId(chatId)
                .addType(MessageType.VOICE)
                .build();
        return message;
    }
}