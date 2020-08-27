package espacodetupla;
import net.jini.space.JavaSpace;
import java.util.Scanner;

public class WriteMessage {

    public void SendMessage(JavaSpace space, String message){
        try {
            Message msg = new Message();
            msg.content = message;
            space.write(msg, null, 60 * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
