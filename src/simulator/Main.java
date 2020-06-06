//Dedicated to Goli

package simulator;

import simulator.components.gates.And;
import simulator.control.*;
import simulator.functions.FullAdder;
import simulator.functions.HalfAdder;

public class Main {
    //sample code
    public static void main(String[] args) {
        FullAdder fa1 = new FullAdder("FA1", new Wire(true), new Wire(false), new Wire(false));

        Debugger debugger = new Debugger(200);
        debugger.addTrackItem(fa1);

        Circuit.startAll();
    }
}
