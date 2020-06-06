package simulator.components.gates;

import simulator.components.Component;
import simulator.functions.Function;
import simulator.Wire;

public class Or extends Component {
    public Or(String label, Wire... inputs) {
        super(label, inputs);
        initialOutput(1);
    }

    @Override
    public void runComponent() {
        Wire result = new Wire(false);
        for(Wire w: getInputs()) {
            result.setSignal(result.getSignal() || w.getSignal());
        }

        outputs.get(0).setSignal(result.getSignal());
    }
}
