package simulator.control;

import simulator.components.Component;

import java.util.ArrayList;

public class Circuit {
    public static ArrayList<Component> components = new ArrayList<>();

    public static void addComponent(Component component) {
        components.add(component);
    }

    public static void startAll() {
        for (Component c : components)
            c.startComponent();
    }
}
