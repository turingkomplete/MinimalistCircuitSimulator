package simulator.control;

import simulator.components.Component;
import simulator.functions.Function;

import java.util.ArrayList;

public class Circuit {
    private static ArrayList<Component> components = new ArrayList<>();
    private static ArrayList<Function> functions = new ArrayList<>();

    public static void addComponent(Component component) {
        components.add(component);
    }

    public static void addFunction(Function function) {
        functions.add(function);
    }

    public static void startAll() {
        for (Component c : components)
            c.startComponent();

        for (Function f: functions)
            f.startFunction();
    }
}
