/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacodetupla;

import java.util.Scanner;
import net.jini.space.JavaSpace;
import espacodetupla.WriteMessage;

/**
 *
 * @author Matheus
 */
public class Cliente1 {
    public static void main(String[] args) {
        WriteMessage writeMessage = new WriteMessage();
        try {
            System.out.println("Procurando pelo servico JavaSpace...");
            Lookup finder = new Lookup(JavaSpace.class);
            JavaSpace space = (JavaSpace) finder.getService();
            if (space == null) {
                    System.out.println("O servico JavaSpace nao foi encontrado. Encerrando...");
                    System.exit(-1);
            } 
            System.out.println("O servico JavaSpace foi encontrado.");
            System.out.println(space);
            
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Entre com o texto da mensagem (ENTER para sair): ");
                String message = scanner.nextLine();
                if (message == null || message.equals("")) {
                    System.exit(0);
                }
                else{
                    writeMessage.SendMessage(space, message);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
