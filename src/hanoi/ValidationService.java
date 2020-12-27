package hanoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;


public class ValidationService extends Information {

    private boolean isCheckOrder;

    public ValidationService() {
        this.isCheckOrder = true;
    }

    public Boolean isCheckOrder() {
        return isCheckOrder;
    }

    public boolean isInputPinsValid (int numberOfPins) {
        if (numberOfPins > 2 && numberOfPins < 11) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isInputDisksValid (int numberOfDisks) {
        if (numberOfDisks > 0 && numberOfDisks < 21) {
            return true;
        } else {
            return false;
        }
    }

    private String checkInputPins (int numberOfPins) {
        if (isInputPinsValid(numberOfPins)) {
            return "";
        } else {
            return "Количество штырей должно находится в диапазоне: [3, 10]";
        }
    }

    private String checkInputDisks (int numberOfDisks) {
        if (isInputDisksValid(numberOfDisks)) {
            return "";
        } else {
            return "Количество дисков должно находится в диапазоне: [1, 20]";
        }
    }

    private String checkInputFromToPin (int fromPin, int toPin) {
        if (fromPin != toPin) {
            return "";
        } else {
            return String.format("Если диски должны быть перемещены со штыря %s на штырь %s, " +
                    "то задача не нуждается в решении.", fromPin, toPin);
        }
    }

    private String checkInputFromPin (int fromPin, int numberOfPins) {
        if (fromPin <= numberOfPins) {
            return "";
        } else {
            return "Штырь, с которого нужно перекладывать, должен существовать.";
        }
    }

    private String checkInputToPin (int toPin, int numberOfPins) {
        if (toPin <= numberOfPins) {
            return "";
        } else {
            return "Штырь, на который нужно перекладывать, должен существовать.";
        }
    }

    private String checkInputCostCells (int numberOfPins, List<Integer> COST) {
        if (numberOfPins == COST.size()) {
            return "";
        } else {
            return "Количество штырей должно совпадать с количеством ячеек в COST'е.";
        }
    }

    public void valid (Hanoi hanoi, int fromPin, int toPin, List<Integer> COST) {
        List<String> errors = checkValidity(hanoi, fromPin, toPin, COST);
        if (errors.isEmpty()) {
            System.out.println("Валидация прошла успешно.");
        } else {
            System.out.println("Валидация не прошла успешно.");
            System.out.println(errors);
        }
    }

    /**
     * Проверка на валидность данных ханоя.
     * @param hanoi
     * @return список ошибок.
     */
    public List<String> checkValidity (Hanoi hanoi, int fromPin, int toPin, List<Integer> COST) {
        List<String> errors = new ArrayList<>();
        String error = checkInputPins(hanoi.getNumberOfPins());
        if (!error.isEmpty()) errors.add(error);
        error = checkInputDisks(hanoi.getNumberOfDisks());
        if (!error.isEmpty()) errors.add(error);
        error = checkInputFromToPin(fromPin, toPin);
        if (!error.isEmpty()) errors.add(error);
        error = checkInputFromPin(fromPin, hanoi.getNumberOfPins());
        if (!error.isEmpty()) errors.add(error);
        error = checkInputToPin(toPin, hanoi.getNumberOfPins());
        if (!error.isEmpty()) errors.add(error);
        error = checkInputCostCells(hanoi.getNumberOfPins(), COST);
        if (!error.isEmpty()) errors.add(error);
        return errors;
    }

    /**
     * Операция перекладывания дисков.
     * @param disk номер диска
     * @param pinFrom штырь, с которого нужно перекладывать
     * @param pinTo штырь, на который нужно перекладывать
     * @param hanoi
     */
    public void checkOrder (int disk, int pinFrom, int pinTo, Vector<Stack<Integer>> hanoi, List<Integer> COST) {
        if (!hanoi.get(pinFrom).empty()) {
            Integer temp = hanoi.get(pinFrom).pop();
            if (temp == disk) {
                if (hanoi.get(pinTo).empty()) {
                    hanoi.get(pinTo).push(temp);
                    costValue += COST.get(pinTo);
                    numberOfStepsOnEachPin.add(pinTo, numberOfStepsOnEachPin.remove(pinTo) + 1);
                    COSTOnEachPin.add(pinTo, COSTOnEachPin.remove(pinTo) + COST.get(pinTo));
                } else {
                    Integer temp2 = hanoi.get(pinTo).pop();
                    if (disk < temp2) {
                        hanoi.get(pinTo).push(temp2);
                        hanoi.get(pinTo).push(temp);
                        costValue += COST.get(pinTo);
                        numberOfStepsOnEachPin.add(pinTo, numberOfStepsOnEachPin.remove(pinTo) + 1);
                        COSTOnEachPin.add(pinTo, COSTOnEachPin.remove(pinTo) + COST.get(pinTo));
                    } else {
                        System.out.println("Ошибка операции! Больший диск не может быть размещен на меньшем.");
                        isCheckOrder = false;
                    }
                }
            } else {
                System.out.println("Ошибка операции! Диск с номером: " + disk + " не существует на штыре: " + pinFrom);
                isCheckOrder = false;
            }
        } else {
            System.out.println("Ошибка операции! На штыре с номером: " + pinFrom + " нет дисков");
            isCheckOrder = false;
        }
    }

    /**
     * Новая (улучшенная) версия валидации без временных переменных. (надо тестить)
     */
    public void checkOrderNew (int disk, int pinFrom, int pinTo, Vector<Stack<Integer>> hanoi, List<Integer> COST) {
        if (!hanoi.get(pinFrom).empty()) {
            if (hanoi.get(pinFrom).peek() == disk) {
                if (hanoi.get(pinTo).empty()) {
                    hanoi.get(pinTo).push(hanoi.get(pinFrom).pop());
                    costValue += COST.get(pinTo);
                    numberOfStepsOnEachPin.add(pinTo, numberOfStepsOnEachPin.remove(pinTo) + 1);
                    COSTOnEachPin.add(pinTo, COSTOnEachPin.remove(pinTo) + COST.get(pinTo));
                } else {
                    if (disk < hanoi.get(pinTo).peek()) {
                        hanoi.get(pinTo).push(hanoi.get(pinFrom).pop());
                        costValue += COST.get(pinTo);
                        numberOfStepsOnEachPin.add(pinTo, numberOfStepsOnEachPin.remove(pinTo) + 1);
                        COSTOnEachPin.add(pinTo, COSTOnEachPin.remove(pinTo) + COST.get(pinTo));
                    } else {
                        System.out.println("Ошибка операции! Больший диск не может быть размещен на меньшем " +
                                "ИЛИ номера дисков не могут быть равны.");
                        isCheckOrder = false;
                    }
                }
            } else {
                System.out.println("Ошибка операции! Диск с номером: " + disk + " не существует на штыре: " + pinFrom);
                isCheckOrder = false;
            }
        } else {
            System.out.println("Ошибка операции! На штыре с номером: " + pinFrom + " нет дисков");
            isCheckOrder = false;
        }
    }
}
