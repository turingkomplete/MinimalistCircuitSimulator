package simulator.components;

import simulator.control.Debugger;

public class Adder extends Function {
    public Adder(String label, Wire... inputs) {
        super(label, inputs);
        initialOutput(4);
    }

    @Override
    public void initialFunction() {
        Wire a1 = this.inputs.get(0);
        Wire a2 = this.inputs.get(1);
        Wire b1 = this.inputs.get(2);
        Wire b2 = this.inputs.get(3);

        And carryHalf = new And(this, "carry_half",a1,b1);
        Xor sumHalf = new Xor(this, "sum_half",a1,b1);
        Xor helpXor = new Xor(this, "help_xor",a2,b2);
        Xor sumFull = new Xor(this, "sum_Full",helpXor.getOutput(0),carryHalf.getOutput(0));
        And helpAnd1 = new And(this, "help_And1",helpXor.getOutput(0),carryHalf.getOutput(0));
        And helpAnd2 = new And(this, "help_And2",a2,b2);
        Or carryFull = new Or(this, "carry_full",helpAnd1.getOutput(0),helpAnd2.getOutput(0));


        addInternalOutput(sumHalf.getOutput(0));
        addInternalOutput(carryHalf.getOutput(0));
        addInternalOutput(sumFull.getOutput(0));
        addInternalOutput(carryFull.getOutput(0));
    }
}
