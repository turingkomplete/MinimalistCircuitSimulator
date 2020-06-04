package simulator.components;

public class Adder extends Function {
    public Adder(String label, Wire... inputs) {
        super(label, inputs);
    }

    @Override
    protected void initialFunction() {
        Wire a1 = this.inputs.get(0);
        Wire a2 = this.inputs.get(1);
        Wire b1 = this.inputs.get(2);
        Wire b2 = this.inputs.get(3);

        And carryHalf = new And(getLabel()+ ":" + "carry_half",a1,b1);
        Xor sumHalf = new Xor(getLabel()+ ":" + "sum_half",a1,b1);
        Xor helpXor = new Xor(getLabel()+ ":" + "help_xor",a2,b2);
        Xor sumFull = new Xor(getLabel()+ ":" + "sum_Full",helpXor.getOutput(0),carryHalf.getOutput(0));
        And helpAnd1 = new And(getLabel()+ ":" + "help_And1",helpXor.getOutput(0),carryHalf.getOutput(0));
        And helpAnd2 = new And(getLabel()+ ":" + "help_And2",a2,b2);
        Or carryFull = new Or(getLabel()+ ":" + "carry_full",helpAnd1.getOutput(0),helpAnd2.getOutput(0));

        outputs.add(sumHalf.getOutput(0));
        outputs.add(carryHalf.getOutput(0));
        outputs.add(sumFull.getOutput(0));
        outputs.add(carryFull.getOutput(0));
    }
}
