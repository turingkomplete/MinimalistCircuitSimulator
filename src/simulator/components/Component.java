package simulator.components;

import simulator.Connectable;
import simulator.Wire;
import simulator.control.Circuit;
import simulator.functions.Function;

import java.util.ArrayList;

public abstract class Component implements Runnable, Connectable {
    private static int nextID = 0;

    private final String type = "component";

    protected String label;
    protected int id;
    protected ArrayList<Wire> inputs;
    protected ArrayList<Wire> outputs;
    protected long delay;
    protected Thread thread;

    protected Component(String label, Wire... inputs) {
        this(label, 0, inputs);
    }

    protected Component(String label, long delay, Wire... inputs) {
        this.label = label;
        id = nextID;
        nextID++;
        this.delay = delay;
        outputs = new ArrayList<>();
        this.inputs = new ArrayList<>();
        addInput(inputs);
        thread = new Thread(this);
        Circuit.addComponent(this);
    }

    protected abstract void runComponent();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runComponent();
        }
    }

    public void startComponent() {
        thread.start();
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
    public Wire getInput(int index) {
        return getInputs().get(index);
    }

    @Override
    public String getLabel() {
        return label;
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
    public void initialOutput(int size) {
        for (int i = 0; i < size; ++i)
            outputs.add(new Wire(false));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Component component = (Component) o;

        if (id != component.id) return false;
        if (!type.equals(component.type)) return false;
        return label.equals(component.label);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + label.hashCode();
        result = 31 * result + id;
        return result;
    }
}
