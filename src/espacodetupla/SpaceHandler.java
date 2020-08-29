package espacodetupla;
import net.jini.space.JavaSpace;


public class SpaceHandler {
    private static SpaceHandler instance;
    private JavaSpace space;
    private Lookup finder;
    private SpaceHandler(){
        try{
            System.out.println("Procurando pelo servico JavaSpace...");
            finder = new Lookup(JavaSpace.class);
            space = (JavaSpace) finder.getService();
            if (space == null) {
                    System.out.println("O servico JavaSpace nao foi encontrado. Encerrando...");
                    System.exit(-1);
            } 
            System.out.println("O servico JavaSpace foi encontrado.");
            System.out.println(space);
        }catch(Exception e){
            System.out.println("Não foi possível encontrar o espaço!");
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    public static SpaceHandler getInstance(){
        return SpaceHandlerHolder.INSTANCE;
    }
    
    private static class SpaceHandlerHolder{
        private static final SpaceHandler INSTANCE = new SpaceHandler();
    }
    
    public void writeMessage(String name, String message){
        try{
            Message msg = new Message();
            msg.type = "Mensagem";
            msg.name = name;
            msg.content = message;
            space.write(msg, null, 60 * 1000);
        }
        catch(Exception e){e.printStackTrace();}
    }
    
    /*
    public void writeMessage(Client client, String name, String message){
        try{
            Message msg = new Message();
            msg.type = "Mensagem";
            msg.client = client;
            msg.name = name;
            msg.content = message;
            space.write(msg, null, 60 * 1000);
        }
        catch(Exception e){e.printStackTrace();}
    }
    */
    public void writeChatSelect(String chatname, String name){
        try{
            Message msg = new Message();
            msg.type = "ChatSelect";
            msg.chatname = chatname;
            msg.name = name;
            space.write(msg, null, 60 * 1000);
        }
        catch(Exception e){e.printStackTrace();}
    }
    
    public void writeClient(Client client, String name){
        try{
            Message msg = new Message();
            msg.type = "Client";
            msg.client = client;
            msg.name = name;
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
            if (msg.type.equals("Mensagem")) {
                System.out.println("Mensagem recebida de " + msg.name + ": " + msg.content);
            } else if (msg.type.equals("ChatSelect")) {
                System.out.println("Usuário " + msg.name + " se conectou ao chat " + msg.chatname);
            }
            
            System.out.println("Mensagem recebida: " + msg.content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JavaSpace getSpace() {
        return space;
    }

    public void setSpace(JavaSpace space) {
        this.space = space;
    }

    public Lookup getFinder() {
        return finder;
    }

    public void setFinder(Lookup finder) {
        this.finder = finder;
    }
    
    
}
