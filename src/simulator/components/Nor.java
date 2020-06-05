package simulator.components;

public class Nor extends Component {
    public Nor(String label, Wire ... inputs) {
        super(label, inputs);
        initialOutput(1);
    }

    public Nor(Function function, String label, Wire ... inputs) {
        super(function, label, inputs);
        outputs.add(new Wire(false));
    }

    @Override
    public void runComponent() {
        Wire result = new Wire(false);
        for(Wire w: inputs) {
            result.setSignal(result.getSignal() || w.getSignal());
        }

        outputs.get(0).setSignal(!result.getSignal());
    }
}
