package hanoi;

import java.util.List;

public class HanoiInformation extends Information {
    private int numberOfSteps;
    private List<List<Integer>> order;
    private boolean validationSuccessful;

    public HanoiInformation(int numberOfSteps, int _costValue, List<Integer> _numberOfStepsOnEachPin,
                            List<Integer> _COSTOnEachPin, List<List<Integer>> _order, boolean _validationSuccessful) {
        this.numberOfSteps = numberOfSteps;
        costValue = _costValue;
        numberOfStepsOnEachPin = _numberOfStepsOnEachPin;
        COSTOnEachPin = _COSTOnEachPin;
        this.order = _order;
        this.validationSuccessful = _validationSuccessful;
    }

    public HanoiInformation() {

    }

    public boolean isValidationSuccessful() {
        return validationSuccessful;
    }

    public void setValidationSuccessful(boolean validationSuccessful) {
        this.validationSuccessful = validationSuccessful;
    }

    public void setOrder(List<List<Integer>> order) {
        this.order = order;
    }

    public void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    public List<List<Integer>> getOrder() {
        return order;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }
}
