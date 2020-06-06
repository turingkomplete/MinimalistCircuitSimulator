package simulator.components.gates;

import simulator.components.Component;
import simulator.functions.Function;
import simulator.Wire;

public class And extends Component {
    public And(String label, Wire... inputs) {
        super(label, inputs);
        initialOutput(1);
    }

    @Override
    public void runComponent() {
        Wire result = new Wire(true);
        for (Wire w: getInputs()) {
            result.setSignal(result.getSignal() && w.getSignal());
        }

        getOutput(0).setSignal(result.getSignal());
    }
}
