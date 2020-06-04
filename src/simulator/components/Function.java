package simulator.components;

import simulator.control.Circuit;

import java.util.ArrayList;

public abstract class Function implements Connectable {
    protected String label;
    protected ArrayList<Wire> inputs;
    protected ArrayList<Wire> outputs;

    public Function(String label, Wire... inputs) {
        this.label = label;
        outputs = new ArrayList<>();
        this.inputs = new ArrayList<>();
        for (Wire w: inputs) {
            this.inputs.add(w);
        }
        initialFunction();
    }

    protected abstract void initialFunction();

    @Override
    public void setInput(Wire inputWire, int inputIndex) {
        if(inputs.size() <= inputIndex) {
            while (inputs.size() < inputIndex) {
                inputs.add(new Wire());
            }
            inputs.add(inputWire);
        } else {
            inputs.set(inputIndex, inputWire);
        }
    }

    @Override
    public Wire getOutput(int index) {
        return outputs.get(index);
    }

    @Override
    public ArrayList<Wire> getOutputs() {
        return outputs;
    }

    @Override
    public ArrayList<Wire> getInputs() {
        return inputs;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
