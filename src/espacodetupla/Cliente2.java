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
        spaceHandler.writeMessage("Testando Handler");
        spaceHandler.readMessage();
    }
}
