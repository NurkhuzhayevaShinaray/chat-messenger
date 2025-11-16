package Classes;
import visitor.MessageVisitor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Message {
    private int messageId;
    private int chatId;
    private User user;
    private String text;
    private LocalDateTime createdAt;
    private int ExpiringTime = 0;

    public int getExpiringTime() {
        return ExpiringTime;
    }

    public void setExpiringTime(int expiringTime) {
        ExpiringTime = expiringTime;
    }


    public int getMessageId() {
        return messageId;
    }
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getChatId() {
        return chatId;
    }
    public void setChatId(int chatId) {
        this.chatId = chatId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getFormattedDate() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        return createdAt.format(fmt);
    }

    private MessageType type;

    public MessageType getType() {
        return type;
    }
    public void setType(MessageType type) {
        this.type = type;
    }

    public void accept(MessageVisitor visitor) {
        switch (type) {
            case TEXT -> visitor.visitText(this);
            case VOICE -> visitor.visitVoice(this);
            case TRANSLATED -> visitor.visitTranslated(this);
            case EXPIRING -> visitor.visitExpiring(this);
        }
    }

}
