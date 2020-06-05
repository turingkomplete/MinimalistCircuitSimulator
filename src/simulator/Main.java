//Dedicated to Goli

package simulator;

import simulator.components.*;
import simulator.control.*;

public class Main {

    public static void main(String[] args) {
        //code

        Debugger debugger = new Debugger(1000);
        debugger.addTrackItem();

        Circuit.startAll();
    }
}
