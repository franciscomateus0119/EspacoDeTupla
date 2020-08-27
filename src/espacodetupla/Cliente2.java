/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacodetupla;

import java.util.Scanner;
import net.jini.space.JavaSpace;
import espacodetupla.WriteMessage;
import espacodetupla.SpaceHandler;

/**
 *
 * @author Matheus
 */
public class Cliente2 {
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
        //spaceHandler.writeChatSelect("Chat_1", "Jorge");
        //spaceHandler.writeMessage("Jorge", "E ai meu chegado!");
        //spaceHandler.readMessage();
    }
}
