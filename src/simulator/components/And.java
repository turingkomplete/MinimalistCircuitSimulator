package simulator.components;

public class And extends Component {
    public And(String label, Wire ... inputs) {
        super(label, inputs);
        outputs.add(new Wire(false));
    }

    @Override
    public void runComponent() {
        Wire result = new Wire(true);
        for (Wire w : inputs) {
            result.setSignal(result.getSignal() && w.getSignal());
        }

        getOutput(0).setSignal(result.getSignal());
    }
}
