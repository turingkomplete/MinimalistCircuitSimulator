package simulator.functions;

import simulator.Wire;
import simulator.components.gates.Or;

public class FullAdder extends Function {
    public FullAdder(String label, Wire... inputs) {
        super(label, inputs);
        initialOutput(2);
    }

    @Override
    protected void initialFunction() {
        HalfAdder ha1 = new HalfAdder("HA1", getInput(0), getInput(1));
        HalfAdder ha2 = new HalfAdder("HA2", ha1.getOutput(1), getInput(2));
        Or or1 = new Or("OR1", ha1.getOutput(0), ha2.getOutput(0));

        addInternalOutput(or1.getOutput(0), ha2.getOutput(1));
    }
}
