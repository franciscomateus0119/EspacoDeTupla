package espacodetupla;

import java.util.Scanner;
import net.jini.space.JavaSpace;
import espacodetupla.WriteMessage;
import espacodetupla.SpaceHandler;
import espacodetupla.ReadMessageThread;
import espacodetupla.ReadMessageThread2;
import espacodetupla.Client;

public class Cliente2 {
    public static void main(String[] args) {
        Client client = new Client();
        SpaceHandler spaceHandler = SpaceHandler.getInstance();
        Runnable runnable = new ReadMessageThread();
        Thread thread = new Thread(runnable);
        thread.start();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com o seu nome de usuário: ");
        String nome = scanner.nextLine();
        
        scanner = new Scanner(System.in);
        System.out.print("Entre com o chat que deseja entrar (ENTER para sair): ");
        String chatname = scanner.nextLine();
        System.out.println("Done");
        spaceHandler.writeClient(client, nome);
        
        spaceHandler.writeChatSelect(chatname, nome);
            while (true) {
                scanner = new Scanner(System.in);
                System.out.print("Entre com o texto da mensagem (ENTER para sair): ");
                
                String message = scanner.nextLine();
                if (message == null || message.equals("")) {
                    System.exit(0);
                }
                else{
                    //spaceHandler.writeMessage(nome, message);
                }
                
            }
    }
}
