package hanoi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textAreaInfo;

    @FXML
    private Button buttonOpenFile;

    @FXML
    private Button buttonStart;

    @FXML
    private TextField inputNumberOfDisks;

    @FXML
    private TextField inputNumberOfPins;

    @FXML
    private TextField inputCOST;

    @FXML
    private TextField inputToPin;

    @FXML
    private Button buttonClearField;

    @FXML
    private CheckBox cbEnableOptimization;

    @FXML
    private CheckBox cbShowOrder;

    @FXML
    private CheckBox cbOptimizeByPin;

    @FXML
    private Button buttonCancel;

    @FXML
    private ImageView imgLoading;

    private boolean fileOpened = false;
    private int numberOfDisksInFile;
    private int numberOfPinsInFile;
    List<Integer> COSTInFile;

    HanoiInformation hanoiInformation;

    @FXML
    void initialize() {
        cbOptimizeByPin.setOnMouseClicked(event -> {
            if (cbOptimizeByPin.isSelected()) inputToPin.setDisable(true);
            else inputToPin.setDisable(false);
        });
        textAreaInfo.setWrapText(true);
    }

    @FXML
    void pressButtonOpenFile(ActionEvent event) {
        numberOfDisksInFile = 0;
        numberOfPinsInFile = 0;
        COSTInFile = new LinkedList<>();
        try {
            JFileChooser fileOpen = new JFileChooser();
            int ret = fileOpen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileOpen.getSelectedFile();
                readFile(file.getPath());
                fileOpened = true;
                buttonCancel.setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    void pressButtonCancel(ActionEvent event) {
        fileOpened = false;
        buttonCancel.setVisible(false);
    }

    @FXML
    void pressStartButton(ActionEvent event) {
        try {
            if (fileOpened) {
                startHanoi(numberOfDisksInFile, numberOfPinsInFile, numberOfPinsInFile, COSTInFile,
                        cbEnableOptimization.isSelected(), cbShowOrder.isSelected());
            } else {
                List<Integer> COST = new LinkedList<>();
                String toPin = "";
                if (!inputCOST.getText().equals("")) {
                    String nextStr = inputCOST.getText().trim();
                    String[] numbers = nextStr.split(" ");
                    for (String number : numbers) COST.add(Integer.parseInt(number));
                }
                if (!inputToPin.getText().equals("")) {
                    toPin = inputToPin.getText();
                } else {
                    toPin = inputNumberOfPins.getText();
                }

                if (cbOptimizeByPin.isSelected()) {
                    hanoiInformation = new HanoiInformation();

                    startHanoi2(Integer.parseInt(inputNumberOfDisks.getText()), Integer.parseInt(inputNumberOfPins.getText()),
                            Integer.parseInt(toPin), COST, cbEnableOptimization.isSelected(), cbShowOrder.isSelected(), hanoiInformation);

                    if (hanoiInformation.isValidationSuccessful()) {
                        if (cbShowOrder.isSelected()) textAreaInfo.appendText(hanoiInformation.getOrder() + "\n");
                        textAreaInfo.appendText("NOfS on each pin: " + hanoiInformation.getNumberOfStepsOnEachPin() + "\n");
                        textAreaInfo.appendText("COST on each pin: " + hanoiInformation.getCOSTOnEachPin() + "\n");
                        textAreaInfo.appendText("Overall Steps: " + hanoiInformation.getNumberOfSteps() + "\n");
                        textAreaInfo.appendText("Overall COST: " + hanoiInformation.getCostValue() + "\n\n");
                    } else {
                        textAreaInfo.appendText("Валидация не прошла успешно!\nПричину ошибки можно узнать в консоли :)");
                    }
                } else {
                    startHanoi(Integer.parseInt(inputNumberOfDisks.getText()), Integer.parseInt(inputNumberOfPins.getText()),
                            Integer.parseInt(toPin), COST, cbEnableOptimization.isSelected(), cbShowOrder.isSelected());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
            textAreaInfo.appendText("Ошибка входных данных.\n" + ex);
        }
    }

    @FXML
    void pressButtonClearField(ActionEvent event) {
        textAreaInfo.clear();
    }

    private void startHanoi (int numberOfDisks, int numberOfPins, int toPin, List<Integer> COST, boolean EnableOptimization, boolean ShowOrder) {
        //final int numberOfDisks = 4;
        //final int numberOfPins = 4;
        final int fromPin = 1;
        //final int toPin = 4;

        Hanoi hanoi = new Hanoi(numberOfPins, numberOfDisks);
        if (COST.isEmpty()) hanoi.createCostCells();
        else hanoi.createCostCells(COST);
        ValidationService validationService = new ValidationService();

        List<String> errors = validationService.checkValidity(hanoi, fromPin, toPin, hanoi.getCOST());
        if (errors.isEmpty()) {
            AtomicInteger numberOfSteps = new AtomicInteger();
            List<List<Integer>> instructions = new LinkedList<>();
            validationService.setNumberOfStepsOnEachPinAndCOSTOnEachPin(numberOfPins);

            List<List<Integer>> order = Algorithms.algorithmForNPins(numberOfPins, numberOfDisks, fromPin, toPin,
                    instructions, hanoi.getCOST(), EnableOptimization);
            List<List<Integer>> correctOrder = Algorithms.fixOrder(order); // корректирует полученный ордер (-1 у каждого элемента)
            if (ShowOrder) textAreaInfo.appendText(correctOrder.toString() + "\n");
            //System.out.println(hanoi.getHanoi()); // начальное состояние ханоя
            correctOrder.forEach(instruction -> {
                validationService.checkOrderNew(instruction.get(0), instruction.get(1),
                        instruction.get(2), hanoi.getHanoi(), hanoi.getCOST());
                numberOfSteps.getAndIncrement();
                //System.out.println(hanoi.getHanoi());
            });
            if (!validationService.isCheckOrder()) {
                textAreaInfo.appendText("Произошла ошибка во время исполнения алгоритма!");
            } else {
                textAreaInfo.appendText("NOfS on each pin: " + validationService.getNumberOfStepsOnEachPin() + "\n");
                textAreaInfo.appendText("COST on each pin: " + validationService.getCOSTOnEachPin() + "\n");
                textAreaInfo.appendText("Overall Steps: " + numberOfSteps.get() + "\n");
                textAreaInfo.appendText("Overall COST: " + validationService.getCostValue() + "\n\n");
            }
        } else {
            System.out.println("Валидация не прошла успешно!");
            System.out.println(errors);
            textAreaInfo.appendText("Валидация не прошла успешно!\n" + errors);
        }
    }

    private void startHanoi2 (int numberOfDisks, int numberOfPins, int toPin, List<Integer> COST,
                              boolean EnableOptimization, boolean ShowOrder, HanoiInformation hanoiInformation) {
        //final int numberOfDisks = 4;
        //final int numberOfPins = 4;
        final int fromPin = 1;
        //final int toPin = 4;

        List<Integer> _numberOfStepsOnEachPin = new LinkedList<>();
        List<Integer> _COSTOnEachPin = new LinkedList<>();
        int _numberOfSteps = 0;
        int _costValue = Integer.MAX_VALUE;
        List<List<Integer>> _finalOrder = new LinkedList<>();
        boolean _validationSuccessful = true;

        for (int i = toPin; i > 1; i--) {
            Hanoi hanoi = new Hanoi(numberOfPins, numberOfDisks);
            if (COST.isEmpty()) hanoi.createCostCells();
            else hanoi.createCostCells(COST);
            ValidationService validationService = new ValidationService();

            List<String> errors = validationService.checkValidity(hanoi, fromPin, i, hanoi.getCOST());
            if (errors.isEmpty()) {
                AtomicInteger numberOfSteps = new AtomicInteger();
                List<List<Integer>> instructions = new LinkedList<>();
                validationService.setNumberOfStepsOnEachPinAndCOSTOnEachPin(numberOfPins);

                List<List<Integer>> order = Algorithms.algorithmForNPins(numberOfPins, numberOfDisks, fromPin, i,
                        instructions, hanoi.getCOST(), EnableOptimization);
                List<List<Integer>> correctOrder = Algorithms.fixOrder(order); // корректирует полученный ордер (-1 у каждого элемента)
                //System.out.println(hanoi.getHanoi()); // начальное состояние ханоя
                correctOrder.forEach(instruction -> {
                    validationService.checkOrderNew(instruction.get(0), instruction.get(1),
                            instruction.get(2), hanoi.getHanoi(), hanoi.getCOST());
                    numberOfSteps.getAndIncrement();
                    //System.out.println(hanoi.getHanoi());
                });
                if (validationService.getCostValue() < _costValue) {
                    _numberOfStepsOnEachPin = validationService.getNumberOfStepsOnEachPin();
                    _COSTOnEachPin = validationService.getCOSTOnEachPin();
                    _numberOfSteps = numberOfSteps.get();
                    _costValue = validationService.getCostValue();
                    _finalOrder = correctOrder;
                }
                if (!validationService.isCheckOrder()) {
                    textAreaInfo.appendText("Произошла ошибка во время исполнения алгоритма!");
                }
            } else {
                _validationSuccessful = false;
                System.out.println("Валидация не прошла успешно!");
                System.out.println(errors);
                //textAreaInfo.appendText("Валидация не прошла успешно!\n" + errors);
            }
        }
        hanoiInformation.setOrder(_finalOrder);
        hanoiInformation.setNumberOfSteps(_numberOfSteps);
        hanoiInformation.setNumberOfStepsOnEachPin(_numberOfStepsOnEachPin);
        hanoiInformation.setCOSTOnEachPin(_COSTOnEachPin);
        hanoiInformation.setCostValue(_costValue);
        hanoiInformation.setValidationSuccessful(_validationSuccessful);
    }

    public void readFile (String path) {
        int numberOfDisks = 0;
        int numberOfPins = 0;
        List<Integer> COST = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String currentStr;
            String nextStr;
            while ((currentStr = br.readLine()) != null) {
                if (currentStr.trim().equals("NPARTS")) {
                    numberOfDisks = Integer.parseInt(br.readLine().trim().replace("/", "")
                            .replace(" ", ""));
                } else if (currentStr.trim().equals("COST")) {
                    nextStr = br.readLine().trim().replace("/", "");
                    String[] numbers = nextStr.split(" ");
                    for (String number : numbers) COST.add(Integer.parseInt(number));
                    numberOfPins = COST.size();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        numberOfDisksInFile = numberOfDisks;
        numberOfPinsInFile = numberOfPins;
        COSTInFile.addAll(COST);
    }
}
