/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacodetupla;
import net.jini.core.entry.Entry;

public class Message implements Entry {
    public Client client;
    public String type;
    public String chatname;
    public String name;
    public String content;
    public Message() {
    }
}
