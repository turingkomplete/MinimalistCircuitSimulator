//Dedicated to Goli

package simulator;

import simulator.components.*;
import simulator.control.*;

public class Main {

    public static void main(String[] args) {
//        And a1 = new And("And1", new Wire(true), new Wire(true));
//        And a2 = new And("And2", new Wire(false));
//
//
//        Clock clock = new Clock("Clock", 1000);
//        JKFlipFlop jk = new JKFlipFlop("JK", clock.getOutput(0), new Wire(true), new Wire(true));
//        DFlipFlop d1 = new DFlipFlop("D1", clock.getOutput(0));
//        DFlipFlop d2 = new DFlipFlop("D2", clock.getOutput(0));
//        DFlipFlop d3 = new DFlipFlop("D3", clock.getOutput(0));
//
//        a2.addInput(a1.getOutput(0));
//        d1.addInput(jk.getOutput(0));
//        d2.addInput(d1.getOutput(0));
//        d3.addInput(d2.getOutput(0));
//
//
//        Debugger debugger = new Debugger(500);
//        debugger.addTrackItem(a1, a2, clock,d1, d2, d3, jk);
//
        Adder adder1 = new Adder("ADDER1", new Wire(true), new Wire(true), new Wire(true), new Wire(true));
        Adder adder2 = new Adder("ADDER1", new Wire(true), new Wire(true), new Wire(true));
        adder2.addInput(adder1.getOutput(0));
        Debugger debugger = new Debugger(500);
        debugger.addTrackItem(adder1, adder2);
        Circuit.startAll();
    }
}
