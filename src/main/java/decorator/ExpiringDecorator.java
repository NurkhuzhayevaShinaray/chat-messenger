package decorator;
import Classes.Message;
import Classes.MessageType;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class ExpiringDecorator extends Decorator {
    public ExpiringDecorator(SendingTypes sendingTypes){
        super(sendingTypes);
    }

    @Override
    public Message createMessage() {
        Message message = super.createMessage();
        message.setType(MessageType.EXPIRING);


        if (message.getCreatedAt() == null) {
            message.setCreatedAt(LocalDateTime.now());
        }


        startExpirationTimer(message);

        return message;
    }

    private void startExpirationTimer(Message message) {
        Timer timer = new Timer();
        final int expirationSeconds = 10; // Сообщение исчезает через 10 секунд
        message.setExpiringTime(expirationSeconds);
        TimerTask task = new TimerTask() {
            int secondsLeft = expirationSeconds;

            @Override
            public void run() {
                if (secondsLeft > 0) {
                    System.out.println("💬 Expiring message will disappear in " + secondsLeft + " seconds");
                    secondsLeft--;
                } else {
                    System.out.println("💬 Message expired and disappeared!");
                    timer.cancel();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}