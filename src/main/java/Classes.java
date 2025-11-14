import java.util.List;
import java.sql.Date;

public class Classes {
}


// Основные модели
class Message {
    private int messageId;
    private int chatId;
    private int userId;
    private String text;
    private Date createdAt; // Date вместо DateTime

    // Геттеры и сеттеры
    public int getMessageId() { return messageId; }
    public void setMessageId(int messageId) { this.messageId = messageId; }

    public int getChatId() { return chatId; }
    public void setChatId(int chatId) { this.chatId = chatId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}

class User {
    private int userId;
    private String userName;
    private String password; // nullable можно просто оставить String

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class Chat {
    private int chatId;
    private String chatName;
    private int type;
    private int ownerId;
    private List<User> members;

    public int getChatId() { return chatId; }
    public void setChatId(int chatId) { this.chatId = chatId; }

    public String getChatName() { return chatName; }
    public void setChatName(String chatName) { this.chatName = chatName; }

    public int getType() { return type; }
    public void setType(int type) { this.type = type; }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    public List<User> getMembers() { return members; }
    public void setMembers(List<User> members) { this.members = members; }
}

// Вспомогательные DTO
class PrivateChatRequest {
    private int user1;
    private int user2;

    public int getUser1() { return user1; }
    public void setUser1(int user1) { this.user1 = user1; }

    public int getUser2() { return user2; }
    public void setUser2(int user2) { this.user2 = user2; }
}

class AddUserRequest {
    private int Owner;
    private int NewUser;

    public int getOwner() { return Owner; }
    public void setOwner(int owner) { this.Owner = owner; }

    public int getNewUser() { return NewUser; }
    public void setNewUser(int newUser) { this.NewUser = newUser; }
}

