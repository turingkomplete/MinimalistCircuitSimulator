package simulator.functions;

import simulator.Wire;
import simulator.components.gates.And;
import simulator.components.gates.Xor;

public class HalfAdder extends Function {
    public HalfAdder(String label, Wire... inputs) {
        super(label, inputs);
        initialOutput(2);
    }

    @Override
    protected void initialFunction() {
        And a1 = new And("AND1", getInput(0), getInput(1));
        Xor xor = new Xor("XOR1", getInput(0), getInput(1));

        addInternalOutput(a1.getOutput(0), xor.getOutput(0));
    }
}
