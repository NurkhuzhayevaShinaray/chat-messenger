package decorator;
import Classes.Message;
import adapter.Speech;
import adapter.VoskAdapter;
import adapter.VoskLibrary;

public class VoiceRecorder implements SendingTypes {
    public int MessageId;
    public int UserId;
    public String UserName;
    public String MessageText;
    public String CreatedAt;
    private Speech speech;

    private VoskLibrary vosk = new VoskLibrary("src/main/resources/vosk-model-small-en-us-0.15/vosk-model-small-en-us-0.15");

    public VoiceRecorder(VoskAdapter vosk) {
    }

    public int getMessageId() {
        return MessageId;
    }

    public int getUserId() {
        return UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public String getMessageText() {
        return MessageText;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setMessageId(int messageId) {
        MessageId = messageId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setMessageText(String messageText) {
        MessageText = messageText;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    @Override
    public Message createMessage() {

        return null;
    }

    public String recording() {
        System.out.println("Content of voice recorder: ");
        MessageText = vosk.recognize();
        return MessageText;
    }
}