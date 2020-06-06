package simulator;

import java.util.ArrayList;

public interface Connectable {
    String getLabel();
    void initialOutput(int size);
    void addInput(Wire... inputWires);
    void setInput(int inputIndex, Wire inputWire);
    Wire getOutput(int index);
    Wire getInput(int index);
    ArrayList<Wire> getOutputs();
    ArrayList<Wire> getInputs();
}
