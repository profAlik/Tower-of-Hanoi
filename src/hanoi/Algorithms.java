package hanoi;

import java.util.LinkedList;
import java.util.List;

public class Algorithms {
    public static List<List<Integer>> algorithmFor3Pins (int numberOfDisks, int fromPin, int toPin, List<List<Integer>> instructions) {
        if (numberOfDisks == 1) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(1);
            instruction.add(fromPin);
            instruction.add(toPin);
            instructions.add(instruction);
        } else {
            int temp = 6 - fromPin - toPin;
            algorithmFor3Pins(numberOfDisks - 1, fromPin, temp, instructions);
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks);
            instruction.add(fromPin);
            instruction.add(toPin);
            instructions.add(instruction);
            algorithmFor3Pins(numberOfDisks - 1, temp, toPin, instructions);
        }
        return instructions;
    }

    public static List<List<Integer>> algorithmFor4Pins (int numberOfDisks, int fromPin, int toPin, int tempPin1, int tempPin2, List<List<Integer>> instructions) {
        if (numberOfDisks == 0)
            return instructions;
        if (numberOfDisks == 1) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks);
            instruction.add(fromPin);
            instruction.add(toPin);
            instructions.add(instruction);
            return instructions;
        }
        algorithmFor4Pins(numberOfDisks - 2, fromPin, tempPin1, tempPin2, toPin, instructions);
        List<Integer> instruction = new LinkedList<>();
        instruction.add((numberOfDisks - 1));
        instruction.add(fromPin);
        instruction.add(tempPin2);
        instructions.add(instruction);
        List<Integer> instruction2 = new LinkedList<>();
        instruction2.add(numberOfDisks);
        instruction2.add(fromPin);
        instruction2.add(toPin);
        instructions.add(instruction2);
        List<Integer> instruction3 = new LinkedList<>();
        instruction3.add((numberOfDisks - 1));
        instruction3.add(tempPin2);
        instruction3.add(toPin);
        instructions.add(instruction3);
        algorithmFor4Pins(numberOfDisks - 2, tempPin1, toPin, fromPin, tempPin2, instructions);

        return instructions;
    }

    public static List<List<Integer>> algorithmFor5Pins (int numberOfDisks, int fromPin, int toPin, int tempPin1, int tempPin2, int tempPin3, List<List<Integer>> instructions) {
        if (numberOfDisks == 0)
            return instructions;
        if (numberOfDisks == 1) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks);
            instruction.add(fromPin);
            instruction.add(toPin);
            instructions.add(instruction);
            return instructions;
        }
        if (numberOfDisks == 2) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks - 1);
            instruction.add(fromPin);
            instruction.add(tempPin1);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add(numberOfDisks - 1);
            instruction3.add(tempPin1);
            instruction3.add(toPin);
            instructions.add(instruction3);
            return instructions;
        }
        algorithmFor5Pins(numberOfDisks - 3, fromPin, tempPin1, tempPin2, tempPin3, toPin, instructions);
        List<Integer> instruction0 = new LinkedList<>();
        instruction0.add((numberOfDisks - 2));
        instruction0.add(fromPin);
        instruction0.add(tempPin3);
        instructions.add(instruction0);
        List<Integer> instruction = new LinkedList<>();
        instruction.add((numberOfDisks - 1));
        instruction.add(fromPin);
        instruction.add(tempPin2);
        instructions.add(instruction);
        List<Integer> instruction2 = new LinkedList<>();
        instruction2.add(numberOfDisks);
        instruction2.add(fromPin);
        instruction2.add(toPin);
        instructions.add(instruction2);
        List<Integer> instruction3 = new LinkedList<>();
        instruction3.add((numberOfDisks - 1));
        instruction3.add(tempPin2);
        instruction3.add(toPin);
        instructions.add(instruction3);
        List<Integer> instruction4 = new LinkedList<>();
        instruction4.add((numberOfDisks - 2));
        instruction4.add(tempPin3);
        instruction4.add(toPin);
        instructions.add(instruction4);
        algorithmFor5Pins(numberOfDisks - 3, tempPin1, toPin, fromPin, tempPin2, tempPin3, instructions);

        return instructions;
    }

    public static List<List<Integer>> algorithmFor6Pins (int numberOfDisks, int fromPin, int toPin, int tempPin1, int tempPin2, int tempPin3, int tempPin4, List<List<Integer>> instructions) {
        if (numberOfDisks == 0)
            return instructions;
        if (numberOfDisks == 1) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks);
            instruction.add(fromPin);
            instruction.add(toPin);
            instructions.add(instruction);
            return instructions;
        }
        if (numberOfDisks == 2) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks - 1);
            instruction.add(fromPin);
            instruction.add(tempPin1);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add(numberOfDisks - 1);
            instruction3.add(tempPin1);
            instruction3.add(toPin);
            instructions.add(instruction3);
            return instructions;
        }
        if (numberOfDisks == 3) {
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            return instructions;
        }
        algorithmFor6Pins(numberOfDisks - 4, fromPin, tempPin1, tempPin2, tempPin3, tempPin4, toPin, instructions);
        List<Integer> instruction00 = new LinkedList<>();
        instruction00.add((numberOfDisks - 3));
        instruction00.add(fromPin);
        instruction00.add(tempPin4);
        instructions.add(instruction00);
        List<Integer> instruction0 = new LinkedList<>();
        instruction0.add((numberOfDisks - 2));
        instruction0.add(fromPin);
        instruction0.add(tempPin3);
        instructions.add(instruction0);
        List<Integer> instruction = new LinkedList<>();
        instruction.add((numberOfDisks - 1));
        instruction.add(fromPin);
        instruction.add(tempPin2);
        instructions.add(instruction);
        List<Integer> instruction2 = new LinkedList<>();
        instruction2.add(numberOfDisks);
        instruction2.add(fromPin);
        instruction2.add(toPin);
        instructions.add(instruction2);
        List<Integer> instruction3 = new LinkedList<>();
        instruction3.add((numberOfDisks - 1));
        instruction3.add(tempPin2);
        instruction3.add(toPin);
        instructions.add(instruction3);
        List<Integer> instruction4 = new LinkedList<>();
        instruction4.add((numberOfDisks - 2));
        instruction4.add(tempPin3);
        instruction4.add(toPin);
        instructions.add(instruction4);
        List<Integer> instruction5 = new LinkedList<>();
        instruction5.add((numberOfDisks - 3));
        instruction5.add(tempPin4);
        instruction5.add(toPin);
        instructions.add(instruction5);
        algorithmFor6Pins(numberOfDisks - 4, tempPin1, toPin, fromPin, tempPin2, tempPin3, tempPin4, instructions);

        return instructions;
    }

    public static List<List<Integer>> algorithmFor7Pins (int numberOfDisks, int fromPin, int toPin, int tempPin1, int tempPin2, int tempPin3, int tempPin4, int tempPin5, List<List<Integer>> instructions) {
        if (numberOfDisks == 0)
            return instructions;
        if (numberOfDisks == 1) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks);
            instruction.add(fromPin);
            instruction.add(toPin);
            instructions.add(instruction);
            return instructions;
        }
        if (numberOfDisks == 2) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks - 1);
            instruction.add(fromPin);
            instruction.add(tempPin1);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add(numberOfDisks - 1);
            instruction3.add(tempPin1);
            instruction3.add(toPin);
            instructions.add(instruction3);
            return instructions;
        }
        if (numberOfDisks == 3) {
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            return instructions;
        }
        if (numberOfDisks == 4) {
            List<Integer> instruction00 = new LinkedList<>();
            instruction00.add((numberOfDisks - 3));
            instruction00.add(fromPin);
            instruction00.add(tempPin4);
            instructions.add(instruction00);
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            List<Integer> instruction5 = new LinkedList<>();
            instruction5.add((numberOfDisks - 3));
            instruction5.add(tempPin4);
            instruction5.add(toPin);
            instructions.add(instruction5);
            return instructions;
        }
        algorithmFor7Pins(numberOfDisks - 5, fromPin, tempPin1, tempPin2, tempPin3, tempPin4, tempPin5, toPin, instructions);
        List<Integer> instruction000 = new LinkedList<>();
        instruction000.add((numberOfDisks - 4));
        instruction000.add(fromPin);
        instruction000.add(tempPin5);
        instructions.add(instruction000);
        List<Integer> instruction00 = new LinkedList<>();
        instruction00.add((numberOfDisks - 3));
        instruction00.add(fromPin);
        instruction00.add(tempPin4);
        instructions.add(instruction00);
        List<Integer> instruction0 = new LinkedList<>();
        instruction0.add((numberOfDisks - 2));
        instruction0.add(fromPin);
        instruction0.add(tempPin3);
        instructions.add(instruction0);
        List<Integer> instruction = new LinkedList<>();
        instruction.add((numberOfDisks - 1));
        instruction.add(fromPin);
        instruction.add(tempPin2);
        instructions.add(instruction);
        List<Integer> instruction2 = new LinkedList<>();
        instruction2.add(numberOfDisks);
        instruction2.add(fromPin);
        instruction2.add(toPin);
        instructions.add(instruction2);
        List<Integer> instruction3 = new LinkedList<>();
        instruction3.add((numberOfDisks - 1));
        instruction3.add(tempPin2);
        instruction3.add(toPin);
        instructions.add(instruction3);
        List<Integer> instruction4 = new LinkedList<>();
        instruction4.add((numberOfDisks - 2));
        instruction4.add(tempPin3);
        instruction4.add(toPin);
        instructions.add(instruction4);
        List<Integer> instruction5 = new LinkedList<>();
        instruction5.add((numberOfDisks - 3));
        instruction5.add(tempPin4);
        instruction5.add(toPin);
        instructions.add(instruction5);
        List<Integer> instruction6 = new LinkedList<>();
        instruction6.add((numberOfDisks - 4));
        instruction6.add(tempPin5);
        instruction6.add(toPin);
        instructions.add(instruction6);
        algorithmFor7Pins(numberOfDisks - 5, tempPin1, toPin, fromPin, tempPin2, tempPin3, tempPin4, tempPin5, instructions);

        return instructions;
    }

    public static List<List<Integer>> algorithmFor8Pins (int numberOfDisks, int fromPin, int toPin, int tempPin1, int tempPin2, int tempPin3, int tempPin4, int tempPin5, int tempPin6, List<List<Integer>> instructions) {
        if (numberOfDisks == 0)
            return instructions;
        if (numberOfDisks == 1) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks);
            instruction.add(fromPin);
            instruction.add(toPin);
            instructions.add(instruction);
            return instructions;
        }
        if (numberOfDisks == 2) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks - 1);
            instruction.add(fromPin);
            instruction.add(tempPin1);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add(numberOfDisks - 1);
            instruction3.add(tempPin1);
            instruction3.add(toPin);
            instructions.add(instruction3);
            return instructions;
        }
        if (numberOfDisks == 3) {
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            return instructions;
        }
        if (numberOfDisks == 4) {
            List<Integer> instruction00 = new LinkedList<>();
            instruction00.add((numberOfDisks - 3));
            instruction00.add(fromPin);
            instruction00.add(tempPin4);
            instructions.add(instruction00);
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            List<Integer> instruction5 = new LinkedList<>();
            instruction5.add((numberOfDisks - 3));
            instruction5.add(tempPin4);
            instruction5.add(toPin);
            instructions.add(instruction5);
            return instructions;
        }
        if (numberOfDisks == 5) {
            List<Integer> instruction000 = new LinkedList<>();
            instruction000.add((numberOfDisks - 4));
            instruction000.add(fromPin);
            instruction000.add(tempPin5);
            instructions.add(instruction000);
            List<Integer> instruction00 = new LinkedList<>();
            instruction00.add((numberOfDisks - 3));
            instruction00.add(fromPin);
            instruction00.add(tempPin4);
            instructions.add(instruction00);
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            List<Integer> instruction5 = new LinkedList<>();
            instruction5.add((numberOfDisks - 3));
            instruction5.add(tempPin4);
            instruction5.add(toPin);
            instructions.add(instruction5);
            List<Integer> instruction6 = new LinkedList<>();
            instruction6.add((numberOfDisks - 4));
            instruction6.add(tempPin5);
            instruction6.add(toPin);
            instructions.add(instruction6);
            return instructions;
        }
        algorithmFor8Pins(numberOfDisks - 6, fromPin, tempPin1, tempPin2, tempPin3, tempPin4, tempPin5, tempPin6, toPin, instructions);
        List<Integer> instruction0000 = new LinkedList<>();
        instruction0000.add((numberOfDisks - 5));
        instruction0000.add(fromPin);
        instruction0000.add(tempPin6);
        instructions.add(instruction0000);
        List<Integer> instruction000 = new LinkedList<>();
        instruction000.add((numberOfDisks - 4));
        instruction000.add(fromPin);
        instruction000.add(tempPin5);
        instructions.add(instruction000);
        List<Integer> instruction00 = new LinkedList<>();
        instruction00.add((numberOfDisks - 3));
        instruction00.add(fromPin);
        instruction00.add(tempPin4);
        instructions.add(instruction00);
        List<Integer> instruction0 = new LinkedList<>();
        instruction0.add((numberOfDisks - 2));
        instruction0.add(fromPin);
        instruction0.add(tempPin3);
        instructions.add(instruction0);
        List<Integer> instruction = new LinkedList<>();
        instruction.add((numberOfDisks - 1));
        instruction.add(fromPin);
        instruction.add(tempPin2);
        instructions.add(instruction);
        List<Integer> instruction2 = new LinkedList<>();
        instruction2.add(numberOfDisks);
        instruction2.add(fromPin);
        instruction2.add(toPin);
        instructions.add(instruction2);
        List<Integer> instruction3 = new LinkedList<>();
        instruction3.add((numberOfDisks - 1));
        instruction3.add(tempPin2);
        instruction3.add(toPin);
        instructions.add(instruction3);
        List<Integer> instruction4 = new LinkedList<>();
        instruction4.add((numberOfDisks - 2));
        instruction4.add(tempPin3);
        instruction4.add(toPin);
        instructions.add(instruction4);
        List<Integer> instruction5 = new LinkedList<>();
        instruction5.add((numberOfDisks - 3));
        instruction5.add(tempPin4);
        instruction5.add(toPin);
        instructions.add(instruction5);
        List<Integer> instruction6 = new LinkedList<>();
        instruction6.add((numberOfDisks - 4));
        instruction6.add(tempPin5);
        instruction6.add(toPin);
        instructions.add(instruction6);
        List<Integer> instruction7 = new LinkedList<>();
        instruction7.add((numberOfDisks - 5));
        instruction7.add(tempPin6);
        instruction7.add(toPin);
        instructions.add(instruction7);
        algorithmFor8Pins(numberOfDisks - 6, tempPin1, toPin, fromPin, tempPin2, tempPin3, tempPin4, tempPin5, tempPin6, instructions);

        return instructions;
    }

    public static List<List<Integer>> algorithmFor9Pins (int numberOfDisks, int fromPin, int toPin, int tempPin1, int tempPin2, int tempPin3, int tempPin4, int tempPin5, int tempPin6, int tempPin7, List<List<Integer>> instructions) {
        if (numberOfDisks == 0)
            return instructions;
        if (numberOfDisks == 1) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks);
            instruction.add(fromPin);
            instruction.add(toPin);
            instructions.add(instruction);
            return instructions;
        }
        if (numberOfDisks == 2) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks - 1);
            instruction.add(fromPin);
            instruction.add(tempPin1);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add(numberOfDisks - 1);
            instruction3.add(tempPin1);
            instruction3.add(toPin);
            instructions.add(instruction3);
            return instructions;
        }
        if (numberOfDisks == 3) {
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            return instructions;
        }
        if (numberOfDisks == 4) {
            List<Integer> instruction00 = new LinkedList<>();
            instruction00.add((numberOfDisks - 3));
            instruction00.add(fromPin);
            instruction00.add(tempPin4);
            instructions.add(instruction00);
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            List<Integer> instruction5 = new LinkedList<>();
            instruction5.add((numberOfDisks - 3));
            instruction5.add(tempPin4);
            instruction5.add(toPin);
            instructions.add(instruction5);
            return instructions;
        }
        if (numberOfDisks == 5) {
            List<Integer> instruction000 = new LinkedList<>();
            instruction000.add((numberOfDisks - 4));
            instruction000.add(fromPin);
            instruction000.add(tempPin5);
            instructions.add(instruction000);
            List<Integer> instruction00 = new LinkedList<>();
            instruction00.add((numberOfDisks - 3));
            instruction00.add(fromPin);
            instruction00.add(tempPin4);
            instructions.add(instruction00);
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            List<Integer> instruction5 = new LinkedList<>();
            instruction5.add((numberOfDisks - 3));
            instruction5.add(tempPin4);
            instruction5.add(toPin);
            instructions.add(instruction5);
            List<Integer> instruction6 = new LinkedList<>();
            instruction6.add((numberOfDisks - 4));
            instruction6.add(tempPin5);
            instruction6.add(toPin);
            instructions.add(instruction6);
            return instructions;
        }
        if (numberOfDisks == 6) {
            List<Integer> instruction0000 = new LinkedList<>();
            instruction0000.add((numberOfDisks - 5));
            instruction0000.add(fromPin);
            instruction0000.add(tempPin6);
            instructions.add(instruction0000);
            List<Integer> instruction000 = new LinkedList<>();
            instruction000.add((numberOfDisks - 4));
            instruction000.add(fromPin);
            instruction000.add(tempPin5);
            instructions.add(instruction000);
            List<Integer> instruction00 = new LinkedList<>();
            instruction00.add((numberOfDisks - 3));
            instruction00.add(fromPin);
            instruction00.add(tempPin4);
            instructions.add(instruction00);
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            List<Integer> instruction5 = new LinkedList<>();
            instruction5.add((numberOfDisks - 3));
            instruction5.add(tempPin4);
            instruction5.add(toPin);
            instructions.add(instruction5);
            List<Integer> instruction6 = new LinkedList<>();
            instruction6.add((numberOfDisks - 4));
            instruction6.add(tempPin5);
            instruction6.add(toPin);
            instructions.add(instruction6);
            List<Integer> instruction7 = new LinkedList<>();
            instruction7.add((numberOfDisks - 5));
            instruction7.add(tempPin6);
            instruction7.add(toPin);
            instructions.add(instruction7);
            return instructions;
        }
        algorithmFor9Pins(numberOfDisks - 7, fromPin, tempPin1, tempPin2, tempPin3, tempPin4, tempPin5, tempPin6, tempPin7, toPin, instructions);
        List<Integer> instruction00000 = new LinkedList<>();
        instruction00000.add((numberOfDisks - 6));
        instruction00000.add(fromPin);
        instruction00000.add(tempPin7);
        instructions.add(instruction00000);
        List<Integer> instruction0000 = new LinkedList<>();
        instruction0000.add((numberOfDisks - 5));
        instruction0000.add(fromPin);
        instruction0000.add(tempPin6);
        instructions.add(instruction0000);
        List<Integer> instruction000 = new LinkedList<>();
        instruction000.add((numberOfDisks - 4));
        instruction000.add(fromPin);
        instruction000.add(tempPin5);
        instructions.add(instruction000);
        List<Integer> instruction00 = new LinkedList<>();
        instruction00.add((numberOfDisks - 3));
        instruction00.add(fromPin);
        instruction00.add(tempPin4);
        instructions.add(instruction00);
        List<Integer> instruction0 = new LinkedList<>();
        instruction0.add((numberOfDisks - 2));
        instruction0.add(fromPin);
        instruction0.add(tempPin3);
        instructions.add(instruction0);
        List<Integer> instruction = new LinkedList<>();
        instruction.add((numberOfDisks - 1));
        instruction.add(fromPin);
        instruction.add(tempPin2);
        instructions.add(instruction);
        List<Integer> instruction2 = new LinkedList<>();
        instruction2.add(numberOfDisks);
        instruction2.add(fromPin);
        instruction2.add(toPin);
        instructions.add(instruction2);
        List<Integer> instruction3 = new LinkedList<>();
        instruction3.add((numberOfDisks - 1));
        instruction3.add(tempPin2);
        instruction3.add(toPin);
        instructions.add(instruction3);
        List<Integer> instruction4 = new LinkedList<>();
        instruction4.add((numberOfDisks - 2));
        instruction4.add(tempPin3);
        instruction4.add(toPin);
        instructions.add(instruction4);
        List<Integer> instruction5 = new LinkedList<>();
        instruction5.add((numberOfDisks - 3));
        instruction5.add(tempPin4);
        instruction5.add(toPin);
        instructions.add(instruction5);
        List<Integer> instruction6 = new LinkedList<>();
        instruction6.add((numberOfDisks - 4));
        instruction6.add(tempPin5);
        instruction6.add(toPin);
        instructions.add(instruction6);
        List<Integer> instruction7 = new LinkedList<>();
        instruction7.add((numberOfDisks - 5));
        instruction7.add(tempPin6);
        instruction7.add(toPin);
        instructions.add(instruction7);
        List<Integer> instruction8 = new LinkedList<>();
        instruction8.add((numberOfDisks - 6));
        instruction8.add(tempPin7);
        instruction8.add(toPin);
        instructions.add(instruction8);
        algorithmFor9Pins(numberOfDisks - 7, tempPin1, toPin, fromPin, tempPin2, tempPin3, tempPin4, tempPin5, tempPin6, tempPin7, instructions);

        return instructions;
    }

    public static List<List<Integer>> algorithmFor10Pins (int numberOfDisks, int fromPin, int toPin, int tempPin1, int tempPin2, int tempPin3, int tempPin4, int tempPin5, int tempPin6, int tempPin7, int tempPin8, List<List<Integer>> instructions) {
        if (numberOfDisks == 0)
            return instructions;
        if (numberOfDisks == 1) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks);
            instruction.add(fromPin);
            instruction.add(toPin);
            instructions.add(instruction);
            return instructions;
        }
        if (numberOfDisks == 2) {
            List<Integer> instruction = new LinkedList<>();
            instruction.add(numberOfDisks - 1);
            instruction.add(fromPin);
            instruction.add(tempPin1);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add(numberOfDisks - 1);
            instruction3.add(tempPin1);
            instruction3.add(toPin);
            instructions.add(instruction3);
            return instructions;
        }
        if (numberOfDisks == 3) {
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            return instructions;
        }
        if (numberOfDisks == 4) {
            List<Integer> instruction00 = new LinkedList<>();
            instruction00.add((numberOfDisks - 3));
            instruction00.add(fromPin);
            instruction00.add(tempPin4);
            instructions.add(instruction00);
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            List<Integer> instruction5 = new LinkedList<>();
            instruction5.add((numberOfDisks - 3));
            instruction5.add(tempPin4);
            instruction5.add(toPin);
            instructions.add(instruction5);
            return instructions;
        }
        if (numberOfDisks == 5) {
            List<Integer> instruction000 = new LinkedList<>();
            instruction000.add((numberOfDisks - 4));
            instruction000.add(fromPin);
            instruction000.add(tempPin5);
            instructions.add(instruction000);
            List<Integer> instruction00 = new LinkedList<>();
            instruction00.add((numberOfDisks - 3));
            instruction00.add(fromPin);
            instruction00.add(tempPin4);
            instructions.add(instruction00);
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            List<Integer> instruction5 = new LinkedList<>();
            instruction5.add((numberOfDisks - 3));
            instruction5.add(tempPin4);
            instruction5.add(toPin);
            instructions.add(instruction5);
            List<Integer> instruction6 = new LinkedList<>();
            instruction6.add((numberOfDisks - 4));
            instruction6.add(tempPin5);
            instruction6.add(toPin);
            instructions.add(instruction6);
            return instructions;
        }
        if (numberOfDisks == 6) {
            List<Integer> instruction0000 = new LinkedList<>();
            instruction0000.add((numberOfDisks - 5));
            instruction0000.add(fromPin);
            instruction0000.add(tempPin6);
            instructions.add(instruction0000);
            List<Integer> instruction000 = new LinkedList<>();
            instruction000.add((numberOfDisks - 4));
            instruction000.add(fromPin);
            instruction000.add(tempPin5);
            instructions.add(instruction000);
            List<Integer> instruction00 = new LinkedList<>();
            instruction00.add((numberOfDisks - 3));
            instruction00.add(fromPin);
            instruction00.add(tempPin4);
            instructions.add(instruction00);
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            List<Integer> instruction5 = new LinkedList<>();
            instruction5.add((numberOfDisks - 3));
            instruction5.add(tempPin4);
            instruction5.add(toPin);
            instructions.add(instruction5);
            List<Integer> instruction6 = new LinkedList<>();
            instruction6.add((numberOfDisks - 4));
            instruction6.add(tempPin5);
            instruction6.add(toPin);
            instructions.add(instruction6);
            List<Integer> instruction7 = new LinkedList<>();
            instruction7.add((numberOfDisks - 5));
            instruction7.add(tempPin6);
            instruction7.add(toPin);
            instructions.add(instruction7);
            return instructions;
        }
        if (numberOfDisks == 7) {
            List<Integer> instruction00000 = new LinkedList<>();
            instruction00000.add((numberOfDisks - 6));
            instruction00000.add(fromPin);
            instruction00000.add(tempPin7);
            instructions.add(instruction00000);
            List<Integer> instruction0000 = new LinkedList<>();
            instruction0000.add((numberOfDisks - 5));
            instruction0000.add(fromPin);
            instruction0000.add(tempPin6);
            instructions.add(instruction0000);
            List<Integer> instruction000 = new LinkedList<>();
            instruction000.add((numberOfDisks - 4));
            instruction000.add(fromPin);
            instruction000.add(tempPin5);
            instructions.add(instruction000);
            List<Integer> instruction00 = new LinkedList<>();
            instruction00.add((numberOfDisks - 3));
            instruction00.add(fromPin);
            instruction00.add(tempPin4);
            instructions.add(instruction00);
            List<Integer> instruction0 = new LinkedList<>();
            instruction0.add((numberOfDisks - 2));
            instruction0.add(fromPin);
            instruction0.add(tempPin3);
            instructions.add(instruction0);
            List<Integer> instruction = new LinkedList<>();
            instruction.add((numberOfDisks - 1));
            instruction.add(fromPin);
            instruction.add(tempPin2);
            instructions.add(instruction);
            List<Integer> instruction2 = new LinkedList<>();
            instruction2.add(numberOfDisks);
            instruction2.add(fromPin);
            instruction2.add(toPin);
            instructions.add(instruction2);
            List<Integer> instruction3 = new LinkedList<>();
            instruction3.add((numberOfDisks - 1));
            instruction3.add(tempPin2);
            instruction3.add(toPin);
            instructions.add(instruction3);
            List<Integer> instruction4 = new LinkedList<>();
            instruction4.add((numberOfDisks - 2));
            instruction4.add(tempPin3);
            instruction4.add(toPin);
            instructions.add(instruction4);
            List<Integer> instruction5 = new LinkedList<>();
            instruction5.add((numberOfDisks - 3));
            instruction5.add(tempPin4);
            instruction5.add(toPin);
            instructions.add(instruction5);
            List<Integer> instruction6 = new LinkedList<>();
            instruction6.add((numberOfDisks - 4));
            instruction6.add(tempPin5);
            instruction6.add(toPin);
            instructions.add(instruction6);
            List<Integer> instruction7 = new LinkedList<>();
            instruction7.add((numberOfDisks - 5));
            instruction7.add(tempPin6);
            instruction7.add(toPin);
            instructions.add(instruction7);
            List<Integer> instruction8 = new LinkedList<>();
            instruction8.add((numberOfDisks - 6));
            instruction8.add(tempPin7);
            instruction8.add(toPin);
            instructions.add(instruction8);
            return instructions;
        }
        algorithmFor10Pins(numberOfDisks - 8, fromPin, tempPin1, tempPin2, tempPin3, tempPin4, tempPin5, tempPin6, tempPin7, tempPin8, toPin, instructions);
        List<Integer> instruction000000 = new LinkedList<>();
        instruction000000.add((numberOfDisks - 7));
        instruction000000.add(fromPin);
        instruction000000.add(tempPin8);
        instructions.add(instruction000000);
        List<Integer> instruction00000 = new LinkedList<>();
        instruction00000.add((numberOfDisks - 6));
        instruction00000.add(fromPin);
        instruction00000.add(tempPin7);
        instructions.add(instruction00000);
        List<Integer> instruction0000 = new LinkedList<>();
        instruction0000.add((numberOfDisks - 5));
        instruction0000.add(fromPin);
        instruction0000.add(tempPin6);
        instructions.add(instruction0000);
        List<Integer> instruction000 = new LinkedList<>();
        instruction000.add((numberOfDisks - 4));
        instruction000.add(fromPin);
        instruction000.add(tempPin5);
        instructions.add(instruction000);
        List<Integer> instruction00 = new LinkedList<>();
        instruction00.add((numberOfDisks - 3));
        instruction00.add(fromPin);
        instruction00.add(tempPin4);
        instructions.add(instruction00);
        List<Integer> instruction0 = new LinkedList<>();
        instruction0.add((numberOfDisks - 2));
        instruction0.add(fromPin);
        instruction0.add(tempPin3);
        instructions.add(instruction0);
        List<Integer> instruction = new LinkedList<>();
        instruction.add((numberOfDisks - 1));
        instruction.add(fromPin);
        instruction.add(tempPin2);
        instructions.add(instruction);
        List<Integer> instruction2 = new LinkedList<>();
        instruction2.add(numberOfDisks);
        instruction2.add(fromPin);
        instruction2.add(toPin);
        instructions.add(instruction2);
        List<Integer> instruction3 = new LinkedList<>();
        instruction3.add((numberOfDisks - 1));
        instruction3.add(tempPin2);
        instruction3.add(toPin);
        instructions.add(instruction3);
        List<Integer> instruction4 = new LinkedList<>();
        instruction4.add((numberOfDisks - 2));
        instruction4.add(tempPin3);
        instruction4.add(toPin);
        instructions.add(instruction4);
        List<Integer> instruction5 = new LinkedList<>();
        instruction5.add((numberOfDisks - 3));
        instruction5.add(tempPin4);
        instruction5.add(toPin);
        instructions.add(instruction5);
        List<Integer> instruction6 = new LinkedList<>();
        instruction6.add((numberOfDisks - 4));
        instruction6.add(tempPin5);
        instruction6.add(toPin);
        instructions.add(instruction6);
        List<Integer> instruction7 = new LinkedList<>();
        instruction7.add((numberOfDisks - 5));
        instruction7.add(tempPin6);
        instruction7.add(toPin);
        instructions.add(instruction7);
        List<Integer> instruction8 = new LinkedList<>();
        instruction8.add((numberOfDisks - 6));
        instruction8.add(tempPin7);
        instruction8.add(toPin);
        instructions.add(instruction8);
        List<Integer> instruction9 = new LinkedList<>();
        instruction9.add((numberOfDisks - 7));
        instruction9.add(tempPin8);
        instruction9.add(toPin);
        instructions.add(instruction9);
        algorithmFor10Pins(numberOfDisks - 8, tempPin1, toPin, fromPin, tempPin2, tempPin3, tempPin4, tempPin5, tempPin6, tempPin7, tempPin8, instructions);

        return instructions;
    }

    /**
     * Алгоритм "Башни Ханоя" для n-количества дисков и 3-10 количества штырей.
     *
     * @param numberOfPins кол-во штырей
     * @param numberOfDisks кол-во дисков
     * @param i fromPin "со штыря"
     * @param k toPin "на штырь"
     * @param instructions порядок перекладывания дисков
     * @param COST стоимость перекладывания на штырь (массив)
     * @param EnableOptimization включить оптимизацию (true - да, false - нет)
     * @return итоговый порядок перекладывания дисков
     */
    public static List<List<Integer>> algorithmForNPins (int numberOfPins, int numberOfDisks, int i, int k, List<List<Integer>> instructions, List<Integer> COST, boolean EnableOptimization) {
        List<Integer> tempPins = defTempValueForAlgorithmForNPins(numberOfPins, i, k);
        if (numberOfPins == 3) {
            return algorithmFor3Pins(numberOfDisks, i, k, instructions);
        } else if (numberOfPins == 4) {
            if (EnableOptimization) tempPins = optimize(numberOfPins, numberOfDisks, i, k, tempPins, COST);
            return algorithmFor4Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), instructions);
        } else if (numberOfPins == 5) {
            if (EnableOptimization) tempPins = optimize(numberOfPins, numberOfDisks, i, k, tempPins, COST);
            return algorithmFor5Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), instructions);
        } else if (numberOfPins == 6) {
            if (EnableOptimization) tempPins = optimize(numberOfPins, numberOfDisks, i, k, tempPins, COST);
            return algorithmFor6Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), tempPins.get(3), instructions);
        } else if (numberOfPins == 7) {
            if (EnableOptimization) tempPins = optimize(numberOfPins, numberOfDisks, i, k, tempPins, COST);
            return algorithmFor7Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), tempPins.get(3), tempPins.get(4), instructions);
        } else if (numberOfPins == 8) {
            if (EnableOptimization) tempPins = optimize(numberOfPins, numberOfDisks, i, k, tempPins, COST);
            return algorithmFor8Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), tempPins.get(3), tempPins.get(4), tempPins.get(5), instructions);
        } else if (numberOfPins == 9) {
            if (EnableOptimization) tempPins = optimize(numberOfPins, numberOfDisks, i, k, tempPins, COST);
            return algorithmFor9Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), tempPins.get(3), tempPins.get(4), tempPins.get(5), tempPins.get(6), instructions);
        } else if (numberOfPins == 10) {
            if (EnableOptimization) tempPins = optimize(numberOfPins, numberOfDisks, i, k, tempPins, COST);
            return algorithmFor10Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), tempPins.get(3), tempPins.get(4), tempPins.get(5), tempPins.get(6), tempPins.get(7), instructions);
        } else {
            System.out.println("Не реализовано!");
            return new LinkedList<>();
        }
    }

    private static List<Integer> defTempValueForAlgorithmForNPins(int numberOfPins, int fromPin, int toPin) {
        List<Integer> tempPins = new LinkedList<>();
        //int[] costTempItems = new int[numberOfPins - 2];
        for (int i = 1, j = 0; i <= numberOfPins; i++) {
            if (i != fromPin && i != toPin) {
                tempPins.add(i);
                //costTempItems[j] = COST.get(i - 1);
                //j++;
            }
        }

        //if (EnableOptimization) if (!sortItemsByCost(tempPins, costTempItems, fromPin, toPin)) return new LinkedList<>();
        //if (EnableOptimization) sortItemsByCost(tempPins, costTempItems);

        return tempPins;
    }

    private static List<Integer> optimize (int numberOfPins, int numberOfDisks, int i, int k, List<Integer> tempPins, List<Integer> COST) {
        List<List<Integer>> instructions = new LinkedList<>();
        List<List<Integer>> order = new LinkedList<>();
        if (numberOfPins == 4) order = algorithmFor4Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), instructions);
        else if (numberOfPins == 5) order = algorithmFor5Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), instructions);
        else if (numberOfPins == 6) order = algorithmFor6Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), tempPins.get(3), instructions);
        else if (numberOfPins == 7) order = algorithmFor7Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), tempPins.get(3), tempPins.get(4), instructions);
        else if (numberOfPins == 8) order = algorithmFor8Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), tempPins.get(3), tempPins.get(4), tempPins.get(5), instructions);
        else if (numberOfPins == 9) order = algorithmFor9Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), tempPins.get(3), tempPins.get(4), tempPins.get(5), tempPins.get(6), instructions);
        else if (numberOfPins == 10) order = algorithmFor10Pins(numberOfDisks, i, k, tempPins.get(0), tempPins.get(1), tempPins.get(2), tempPins.get(3), tempPins.get(4), tempPins.get(5), tempPins.get(6), tempPins.get(7), instructions);
        ValidationService validationService = new ValidationService();
        validationService.setNumberOfStepsOnEachPinAndCOSTOnEachPin(numberOfPins);
        Hanoi hanoi = new Hanoi(numberOfPins, numberOfDisks);
        hanoi.createCostCells();
        order.forEach(instruction -> {
            validationService.checkOrderNew(instruction.get(0) - 1, instruction.get(1) - 1,
                    instruction.get(2) - 1, hanoi.getHanoi(), hanoi.getCOST());
        });
        List<Integer> numberOfStepsOnEachPin = validationService.getNumberOfStepsOnEachPin();
        //System.out.println(numberOfStepsOnEachPin);
        //System.out.println(COST);
        int[] tempNewTempPins = new int[numberOfPins - 2];
        int[] tempNumberOfStepsOnEachPin = new int[numberOfPins - 2];
        int[] costTempItems = new int[numberOfPins - 2];
        for (int j1 = 1, j = 0; j1 <= numberOfPins; j1++) {
            if (j1 != i && j1 != k) {
                tempNewTempPins[j] = j1;
                tempNumberOfStepsOnEachPin[j] = numberOfStepsOnEachPin.get(j1 - 1);
                costTempItems[j] = COST.get(j1 - 1);
                j++;
            }
        }
        //System.out.println("\n" + Arrays.toString(tempNumberOfStepsOnEachPin));
        //System.out.println(Arrays.toString(tempNewTempPins));
        //System.out.println(Arrays.toString(costTempItems));
        for (int j2 = tempNumberOfStepsOnEachPin.length - 1; j2 > 0; j2--) {
            for (int j = 0; j < j2; j++) {
                if (costTempItems[j] > costTempItems[j + 1]) {
                    int tmp = costTempItems[j];
                    costTempItems[j] = costTempItems[j + 1];
                    costTempItems[j + 1] = tmp;
                    //--
                    int tmp2 = tempNewTempPins[j];
                    tempNewTempPins[j] = tempNewTempPins[j + 1];
                    tempNewTempPins[j + 1] = tmp2;
                }
            }
        }
        //System.out.println("\n" + Arrays.toString(tempNumberOfStepsOnEachPin));
        //System.out.println(Arrays.toString(tempNewTempPins));
        //System.out.println(Arrays.toString(costTempItems));
        int[] tempArr = new int[tempNumberOfStepsOnEachPin.length];
        System.arraycopy(tempNumberOfStepsOnEachPin, 0, tempArr, 0, tempNumberOfStepsOnEachPin.length);

        for (int j2 = tempNumberOfStepsOnEachPin.length - 1; j2 > 0; j2--) {
            for (int j = 0; j < j2; j++) {
                if (tempNumberOfStepsOnEachPin[j] < tempNumberOfStepsOnEachPin[j + 1]) {
                    int tmp = tempNumberOfStepsOnEachPin[j];
                    tempNumberOfStepsOnEachPin[j] = tempNumberOfStepsOnEachPin[j + 1];
                    tempNumberOfStepsOnEachPin[j + 1] = tmp;
                }
            }
        }
        //System.out.println("\n" + Arrays.toString(tempNumberOfStepsOnEachPin));
        for (int c = 0; c < tempNumberOfStepsOnEachPin.length; c++) {
            for (int j = 0; j < tempNumberOfStepsOnEachPin.length - 1; j++) {
                if (tempNumberOfStepsOnEachPin[c] == tempArr[j]) {
                    int tmp = tempNumberOfStepsOnEachPin[j];
                    tempNumberOfStepsOnEachPin[j] = tempNumberOfStepsOnEachPin[c];
                    tempNumberOfStepsOnEachPin[c] = tmp;
                    //---
                    int tmp2 = tempNewTempPins[j];
                    tempNewTempPins[j] = tempNewTempPins[c];
                    tempNewTempPins[c] = tmp2;
                }
            }
        }
        //System.out.println("\n" + Arrays.toString(tempNumberOfStepsOnEachPin));
        //System.out.println(Arrays.toString(tempNewTempPins));
        //System.out.println(Arrays.toString(tempArr));
        List<Integer> newTempPins = new LinkedList<>();
        for (int tempNewTempPin : tempNewTempPins) newTempPins.add(tempNewTempPin);
        return newTempPins;
    }

    public static List<List<Integer>> fixOrder (List<List<Integer>> order) {
        List<List<Integer>> newOrder = new LinkedList<>();
        order.forEach(instruction -> {
            List<Integer> newInstruction = new LinkedList<>();
            newInstruction.add(instruction.get(0) - 1);
            newInstruction.add(instruction.get(1) - 1);
            newInstruction.add(instruction.get(2) - 1);
            newOrder.add(newInstruction);
        });
        return newOrder;
    }

    @Deprecated
    private static void sortItemsByCost (List<Integer> tempPins, int[] costTempItems) {
        for (int i = costTempItems.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (costTempItems[j] > costTempItems[j + 1]) {
                    int tmp = costTempItems[j];
                    costTempItems[j] = costTempItems[j + 1];
                    costTempItems[j + 1] = tmp;
                    //---
                    int tmp2 = tempPins.remove(j);
                    tempPins.add(j, tempPins.remove(j));
                    tempPins.add(j + 1, tmp2);
                }
            }
        }
    }

    @Deprecated
    private static boolean sortItemsByCost (List<Integer> tempPins, int[] costTempItems, int fromPin, int toPin) {
        int tempPinsInitialSize = tempPins.size();
        for (int i = costTempItems.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (costTempItems[j] > costTempItems[j + 1]) {
                    int tmp = costTempItems[j];
                    costTempItems[j] = costTempItems[j + 1];
                    costTempItems[j + 1] = tmp;
                    //---
                    int tmp2 = tempPins.remove(j);
                    tempPins.add(j, tempPins.remove(j));
                    tempPins.add(j + 1, tmp2);
                }
            }
            /*
                Проверка на корректность после оптимизации.
            */
            if (tempPins.size() == tempPinsInitialSize) {
                for (Integer tempPin : tempPins) {
                    if (tempPin == fromPin || tempPin == toPin) {
                        System.out.println("Ошибка валидации tempPins после оптимизации!");
                        return false;
                    }
                }
            } else {
                System.out.println("Ощибка валидации tempPins после оптимизации!");
                return false;
            }
        }
        return true;
    }

    @Deprecated
    private static int defTempValue (int numberOfPins, int i, int k) {
        int temp = 0;
        if (numberOfPins < 3) {
            System.out.println("Ошибка. Количество пинов меньше 3-х!");
        } else if (numberOfPins == 3) {
            temp = 6 - i - k;
        } else {
            int value = 0;
            for (int j = 1; value < 1; j++) {
                if (j != i && j != k) {
                    value += j;
                }
            }
            temp = value;
        }
        return temp;
    }
}
