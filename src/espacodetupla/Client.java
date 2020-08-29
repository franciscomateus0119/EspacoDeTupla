package espacodetupla;
import java.util.Scanner;
import net.jini.space.JavaSpace;
import espacodetupla.WriteMessage;
import espacodetupla.SpaceHandler;
import espacodetupla.ReadMessageThread;
import java.io.*;
public class Client implements java.io.Serializable{
    String nome;
    String chat;
    public Client(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }
    
    public void writeSomething(String texto){
        System.out.println("Funcionou: " + texto);
    }
    
    
}
