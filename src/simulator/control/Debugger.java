package simulator.control;

import simulator.components.*;
import simulator.components.Wire;

import java.util.ArrayList;

public class Debugger implements Runnable{
    public ArrayList<Component> trackList;
    long delay;
    Thread thread;

    public Debugger(long delay) {
        this.delay = delay;
        trackList = new ArrayList<>();
        thread = new Thread(this);
        thread.start();
    }

    public void addTrackItem(Component ... trackList) {
        for (Component c : trackList) {
            if (!this.trackList.contains(c)) {
                this.trackList.add(c);
            }
        }
    }

    public void printState() {
        if (!trackList.isEmpty()) {
            for (Component c : trackList) {
                System.out.print(c.getLabel() + ": ");
                for (Wire w : c.getOutputs()) {
                    System.out.print(w.getSignal() + " ");
                }
                System.out.println();
            }
            System.out.println("--------------------------------");
        }
    }

    @Override
    public void run() {
        while (true) {
            if (!trackList.isEmpty()) {
                printState();

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
