package simulator;

import java.util.List;

public interface Connectable {
    String getLabel();
    int getID();
    void initialOutput(int size);
    void addInput(Wire... inputWires);
    void setInput(int inputIndex, Wire inputWire);
    Wire getOutput(int index);
    Wire getInput(int index);
    List<Wire> getOutputs();
    List<Wire> getInputs();
}
