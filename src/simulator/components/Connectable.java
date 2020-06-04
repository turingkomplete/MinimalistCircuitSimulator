package simulator.components;

import java.util.ArrayList;

public interface Connectable {
    void setInput(Wire inputWire, int inputIndex);
    Wire getOutput(int index);
    ArrayList<Wire> getOutputs();
    ArrayList<Wire> getInputs();
    String getLabel();
}
