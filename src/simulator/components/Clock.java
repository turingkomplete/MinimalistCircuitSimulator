package simulator.components;

import simulator.Wire;
import simulator.functions.Function;

public class Clock extends Component {
    private boolean state;

    public Clock(String label, long delay, Wire... inputs) {
        super(label, delay, inputs);
        state = false;
        initialOutput(1);
    }

    public Clock(Function function, String label, long delay, Wire... inputs) {
        super(function, label, delay, inputs);
        state = false;
        outputs.add(new Wire(false));
    }

    private void toggle() {
        state = !state;
    }

    @Override
    public void runComponent() {
        toggle();
        getOutput(0).setSignal(state);
    }
}
