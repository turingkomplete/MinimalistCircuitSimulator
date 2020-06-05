package simulator.components;

public class Nand extends Component {
    public Nand(String label, Wire... inputs) {
        super(label, inputs);
        initialOutput(1);
    }

    public Nand(Function function, String label, Wire... inputs) {
        super(function, label, inputs);
        outputs.add(new Wire(false));
    }

    @Override
    public void runComponent() {
        Wire result = new Wire(true);
        for (Wire w: inputs) {
            result.setSignal(result.getSignal() && w.getSignal());
        }

        getOutput(0).setSignal(!result.getSignal());
    }
}
