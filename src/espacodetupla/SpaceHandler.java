package espacodetupla;
import net.jini.space.JavaSpace;

/**
 *
 * @author Matheus
 */
public class SpaceHandler {
    private static SpaceHandler instance;
    private JavaSpace space;
    private Lookup finder;
    private SpaceHandler(){
        try{
            finder = new Lookup(JavaSpace.class);
            space = (JavaSpace) finder.getService();
        }catch(Exception e){
            System.out.println("Não foi possível encontrar o espaço!");
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    public static SpaceHandler getInstance(){
        if(instance == null){
            instance = new SpaceHandler();
        }
        return instance;
    }
    
    public void writeMessage(String message){
        try{
            Message msg = new Message();
            msg.content = message;
            space.write(msg, null, 60 * 1000);
        }
        catch(Exception e){e.printStackTrace();}
    }
    
    public void readMessage(){
        try {
            Message template = new Message();
            Message msg = (Message) space.take(template, null, 60 * 1000);
            if (msg == null) {
                System.out.println("Tempo de espera esgotado. Encerrando...");
                System.exit(0);
            }
            System.out.println("Mensagem recebida: " + msg.content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
