/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacodetupla;

import java.util.HashMap;
import java.util.Map;
import net.jini.space.JavaSpace;
import espacodetupla.Client;
import espacodetupla.Message;
/**
 *
 * @author Matheus
 */
public class ReadMessageThread2 implements Runnable {
    Map<String, Client> clientsbyname = new HashMap<>();
    @Override
    public void run() {
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

            while (true) {
                Message template = new Message();
                Message msg = (Message) space.take(template, null, 60 * 1000);
                if (msg == null) {
                    System.out.println("Tempo de espera esgotado. Encerrando...");
                    System.exit(0);
                }
                if (msg.type.equals("Mensagem")) {
                    System.out.println("Mensagem recebida de " + msg.name + ": " + msg.content);
                    clientsbyname.get(msg.name).writeSomething((msg.name + ": " + msg.content));
                } else if (msg.type.equals("ChatSelect")) {
                    System.out.println("Usuário " + msg.name + " se conectou ao chat " + msg.chatname);
                } else if (msg.type.equals("Client")){
                    System.out.println("Novo Cliente: " + msg.client);
                    clientsbyname.put(msg.name,msg.client);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
