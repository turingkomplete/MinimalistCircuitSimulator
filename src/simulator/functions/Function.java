package simulator.functions;

import simulator.Connectable;
import simulator.Wire;
import simulator.control.Circuit;
import simulator.control.Debugger;

import java.util.ArrayList;
import java.util.List;

public abstract class Function implements Connectable, Runnable {
    private static int nextID = 0;

    private final String type = "function";

    protected String label;
    protected int id;
    protected Debugger debugger;
    protected List<Wire> inputs;
    protected List<Wire> outputs;
    protected List<Wire> internalOutputs;
    protected Thread thread;

    public Function(String label, Wire... inputs) {
        this.label = label;
        id = nextID;
        nextID++;
        outputs = new ArrayList<>();
        internalOutputs = new ArrayList<>();
        this.inputs = new ArrayList<>();
        addInput(inputs);
        thread = new Thread(this);
        Circuit.addFunction(this);
        initialFunction();
    }

    public Function(String label, Debugger debugger, Wire... inputs) {
        this.label = label;
        id = nextID;
        nextID++;
        outputs = new ArrayList<>();
        internalOutputs = new ArrayList<>();
        this.inputs = new ArrayList<>();
        addInput(inputs);
        thread = new Thread(this);
        Circuit.addFunction(this);
        initialFunction();
        this.debugger = debugger;
    }

    protected abstract void initialFunction();

    private void updateOutputs() {
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
    public void setInput(int inputIndex, Wire inputWire) {
        if(getInputs().size() <= inputIndex) {
            while (getInputs().size() < inputIndex) {
                addInput(new Wire());
            }
            addInput(inputWire);
        } else {
            setInput(inputIndex, inputWire);
        }
    }

    @Override
    public Wire getOutput(int index) {
        return outputs.get(index);
    }

    @Override
    public List<Wire> getOutputs() {
        return outputs;
    }

    @Override
    public List<Wire> getInputs() {
        return inputs;
    }

    @Override
    public Wire getInput(int index) {
        return getInputs().get(index);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Function function = (Function) o;

        if (id != function.id) return false;
        if (!type.equals(function.type)) return false;
        return label.equals(function.label);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + label.hashCode();
        result = 31 * result + id;
        return result;
    }
}
