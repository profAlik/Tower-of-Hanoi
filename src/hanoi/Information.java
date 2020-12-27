package hanoi;

import java.util.LinkedList;
import java.util.List;


public class Information {
    protected int costValue;
    protected List<Integer> numberOfStepsOnEachPin;
    protected List<Integer> COSTOnEachPin;

    public Information() {
        this.numberOfStepsOnEachPin = new LinkedList<>();
        this.COSTOnEachPin = new LinkedList<>();
        this.costValue = 0;
    }

    public void setNumberOfStepsOnEachPin(List<Integer> numberOfStepsOnEachPin) {
        this.numberOfStepsOnEachPin = numberOfStepsOnEachPin;
    }

    public void setCOSTOnEachPin(List<Integer> COSTOnEachPin) {
        this.COSTOnEachPin = COSTOnEachPin;
    }

    public void setCostValue(int costValue) {
        this.costValue = costValue;
    }

    public List<Integer> getCOSTOnEachPin() {
        return COSTOnEachPin;
    }

    public int getCostValue() {
        return costValue;
    }

    public List<Integer> getNumberOfStepsOnEachPin() {
        return numberOfStepsOnEachPin;
    }

    public void setNumberOfStepsOnEachPinAndCOSTOnEachPin (int numberOfPins) {
        for (int i = numberOfPins; i > 0; i--) {
            numberOfStepsOnEachPin.add(0);
            COSTOnEachPin.add(0);
        }
    }
}
