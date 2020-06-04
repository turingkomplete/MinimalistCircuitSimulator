package simulator.components;

import simulator.control.Debugger;

public class ShiftRegister extends Function{
    public ShiftRegister(String label, Wire... inputs) {
        super(label, inputs);
        initialOutput(1);
    }

    @Override
    public void initialFunction() {
        Clock c = new Clock(this, "cl", 1000);
        DFlipFlop d1 = new DFlipFlop(this, "D1", c.getOutput(0), inputs.get(0));
        DFlipFlop d2 = new DFlipFlop(this, "D2", c.getOutput(0), d1.getOutput(0));
        DFlipFlop d3 = new DFlipFlop(this, "D3", c.getOutput(0), d2.getOutput(0));
        DFlipFlop d4 = new DFlipFlop(this, "D4", c.getOutput(0), d3.getOutput(0));

        addInternalOutput(d4.getOutput(0));
    }
}
