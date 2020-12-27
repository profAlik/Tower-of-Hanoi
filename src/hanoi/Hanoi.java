package hanoi;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;


public class Hanoi {
    private int numberOfPins;
    private int numberOfDisks;
    private Vector<Stack<Integer>> hanoi;
    private List<Integer> COST;

    public Hanoi(int numberOfPins, int numberOfDisks) {
        this.numberOfPins = numberOfPins;
        this.numberOfDisks = numberOfDisks;
        this.hanoi = new Vector<>();
        //this.COST = new LinkedList<>(); // Перенес в createCostCells для экономии места
        createHanoi(numberOfPins, numberOfDisks);
    }

    public int getNumberOfPins() {
        return numberOfPins;
    }

    public int getNumberOfDisks() {
        return numberOfDisks;
    }

    public List<Integer> getCOST() {
        if (COST != null) {
            return COST;
        } else {
            return new LinkedList<>();
        }
    }

    public Vector<Stack<Integer>> getHanoi() {
        return hanoi;
    }

    private void createHanoi (int numberOfPins, int numberOfDisks) {
        for (int i = 0; i < numberOfPins; i++) {
            Stack<Integer> pin = new Stack<>();
            if (i == 0) {
                for (int j = numberOfDisks - 1; j >= 0; j--) {
                    pin.push(j);
                }
            }
            hanoi.add(pin);
        }
    }

    public void createCostCells (int... costValues) {
        COST = new LinkedList<>();
        for (int costValue : costValues) {
            COST.add(costValue);
        }
    }

    public void createCostCells () {
        COST = new LinkedList<>();
        for (int i = 0; i < numberOfPins; i++) {
            COST.add(1);
        }
    }

    public void createCostCells (List<Integer> costValues) {
        COST = new LinkedList<>();
        COST.addAll(costValues);
    }
}
