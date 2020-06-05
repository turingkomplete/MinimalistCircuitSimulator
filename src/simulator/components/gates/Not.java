package simulator.components.gates;

import simulator.components.Component;
import simulator.functions.Function;
import simulator.Wire;

public class Not extends Component {
    public Not(String label, Wire... inputs) {
        super(label, inputs);
        initialOutput(inputs.length);
    }

    public Not(Function function, String label, Wire... inputs) {
        super(function, label, inputs);
        for(int i = 0; i < inputs.length; ++i) {
            outputs.add(new Wire(false));
        }
    }

    @Override
    public void runComponent() {
        for(int i = 0; i < inputs.size(); ++i) {
            outputs.get(i).setSignal(!inputs.get(i).getSignal());
        }
    }

    @Override
    public void addInput(Wire... inputWires) {
        for (Wire w: inputWires) {
            inputs.add(w);
            initialOutput(1);
        }
    }
}
