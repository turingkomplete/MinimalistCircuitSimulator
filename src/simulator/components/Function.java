package simulator.components;

import simulator.control.Circuit;

import java.util.ArrayList;

public abstract class Function implements Connectable, Runnable {
    protected String label;
    protected ArrayList<Wire> inputs;
    protected ArrayList<Wire> outputs;
    protected ArrayList<Wire> internalOutputs;
    protected Thread thread;

    public Function(String label, Wire... inputs) {
        this.label = label;
        outputs = new ArrayList<>();
        internalOutputs = new ArrayList<>();
        this.inputs = new ArrayList<>();
        for (Wire w: inputs) {
            this.inputs.add(w);
        }
        thread = new Thread(this);
        Circuit.addFunction(this);
    }

    public Function(Function function, String label, Wire... inputs) {
        this.label = function.getLabel() + ":" + label;
        outputs = new ArrayList<>();
        internalOutputs = new ArrayList<>();
        this.inputs = new ArrayList<>();
        for (Wire w: inputs) {
            this.inputs.add(w);
        }
        thread = new Thread(this);
        Circuit.addFunction(this);
    }

    public abstract void initialFunction();

    public void updateOutputs() {
        for (int i = 0; i < outputs.size(); ++i) {
            outputs.get(i).setSignal(internalOutputs.get(i).getSignal());
        }
    }

    protected void addInternalOutput(Wire... internalOutputs) {
        for (Wire internalOutput: internalOutputs) {
            this.internalOutputs.add(internalOutput);
        }
    }

    @Override
    public void addInput(Wire... inputWires) {
        for (Wire w: inputWires) {
            inputs.add(w);
        }
    }

    @Override
    public void setInput(Wire inputWire, int inputIndex) {
        if(getInputs().size() <= inputIndex) {
            while (getInputs().size() < inputIndex) {
                addInput(new Wire());
            }
            addInput(inputWire);
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

    @Override
    public void initialOutput(int size) {
        for (int i = 0; i < size; ++i)
            outputs.add(new Wire());
    }

    public void startFunction() {
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            updateOutputs();
        }
    }
}
