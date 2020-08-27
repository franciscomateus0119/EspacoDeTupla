package espacodetupla;

import java.util.Scanner;
import net.jini.space.JavaSpace;
import espacodetupla.WriteMessage;
import espacodetupla.SpaceHandler;

public class Cliente {
    public static void main(String[] args) {
        SpaceHandler spaceHandler = SpaceHandler.getInstance();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com o seu nome de usuário: ");
        String nome = scanner.nextLine();
        
        scanner = new Scanner(System.in);
        System.out.print("Entre com o chat que deseja entrar (ENTER para sair): ");
        String chatname = scanner.nextLine();
        
        spaceHandler.writeChatSelect(chatname, nome);
            while (true) {
                scanner = new Scanner(System.in);
                System.out.print("Entre com o texto da mensagem (ENTER para sair): ");
                
                String message = scanner.nextLine();
                if (message == null || message.equals("")) {
                    System.exit(0);
                }
                else{
                    spaceHandler.writeMessage(nome, message);
                }
                
            }
    }
}
