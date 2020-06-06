package simulator.components.gates;

import simulator.components.Component;
import simulator.functions.Function;
import simulator.Wire;

public class Not extends Component {
    public Not(String label, Wire... inputs) {
        super(label, inputs);
        initialOutput(inputs.length);
    }

    @Override
    public void runComponent() {
        for(int i = 0; i < getInputs().size(); ++i) {
            outputs.get(i).setSignal(!getInput(i).getSignal());
        }
    }

    @Override
    public void addInput(Wire... inputWires) {
        for (Wire w: inputWires) {
            addInput(w);
            initialOutput(1);
        }
    }
}
