package decorator;

import java.util.List;

public class Message implements SendingTypes{
    public int MessageId;
    public int UserId;
    public String UserName;
    public String MessageText;
    public String CreatedAt;

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
    public void send() {

    }
}