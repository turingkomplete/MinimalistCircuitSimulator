package simulator.components.gates;

import simulator.Wire;
import simulator.components.Component;

public class Xnor extends Component {
    public Xnor(String label, Wire... inputs) {
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

        outputs.get(0).setSignal(onesCounter % 2 == 0);
    }
}
