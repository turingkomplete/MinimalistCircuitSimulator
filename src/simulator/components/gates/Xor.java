package simulator.components.gates;

import simulator.components.Component;
import simulator.functions.Function;
import simulator.Wire;

public class Xor extends Component {
    public Xor(String label, Wire... inputs) {
        super(label, inputs);
        initialOutput(1);
    }

    @Override
    public void runComponent() {
        int onesCounter = 0;
        for(Wire w: getInputs()) {
            if(w.getSignal()) {
                onesCounter++;
            }
        }

        outputs.get(0).setSignal(onesCounter % 2 != 0);
    }
}
