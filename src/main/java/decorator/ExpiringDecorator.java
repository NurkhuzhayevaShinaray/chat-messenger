package decorator;
import Classes.Message;
import Classes.MessageType;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

public class ExpiringDecorator extends Decorator{
    public ExpiringDecorator(SendingTypes sendingTypes){
        super(sendingTypes);
    }

    Timer timer = new Timer();
    @Override
    public Message createMessage() {
        Message message = super.createMessage();
        message.setType(MessageType.EXPIRING);
        message.setExpiringTime(5);
        TimerTask task = new TimerTask() {
            int sec = 5;
            @Override
            public void run() {
                if (sec>0){
                    System.out.println("Message expires in " + sec +" seconds" );
                    sec--;
                } else {
                    System.out.println("Message expired in: " + new Date());
                    timer.cancel();
                    timer.purge();
                }
            }
        };
        timer.scheduleAtFixedRate(task,0,1000);

        return message;
    }
}
