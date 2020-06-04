package simulator.components;

public class Xor extends Component {
    public Xor(String label, Wire... inputs) {
        super(label, inputs);
        initialOutput(1);
    }

    public Xor(Function function, String label, Wire... inputs) {
        super(function, label, inputs);
        outputs.add(new Wire(false));
    }

    @Override
    public void runComponent() {
        int onesCounter = 0;
        for(Wire w: inputs) {
            if(w.getSignal()) {
                onesCounter++;
            }
        }

        outputs.get(0).setSignal(onesCounter % 2 != 0);
    }
}
