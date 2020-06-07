//Dedicated to Goli

package simulator;

import simulator.control.*;
import simulator.functions.FullAdder;

public class Main {
    //sample code
    //this is a test
    public static void main(String[] args) {
        FullAdder fa1 = new FullAdder("FA1", new Wire(true), new Wire(false), new Wire(false));

        Debugger debugger = new Debugger(200);
        debugger.addTrackItem(fa1);

        Circuit.startAll();
    }
}
