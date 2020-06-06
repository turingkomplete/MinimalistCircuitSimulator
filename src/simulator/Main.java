//Dedicated to Goli

package simulator;

import simulator.components.gates.And;
import simulator.control.*;

public class Main {

    public static void main(String[] args) {
        //code for circuit

        Debugger debugger = new Debugger(200);
        debugger.addTrackItem();

        Circuit.startAll();
    }
}
