package com.company.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Run implements RunInter {

    private Controller controller;
    private BufferedReader reader;

    public Run() {
        this.controller = new ContollerClass();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddCage:
                result = addCage(data);
                break;
            case AddDecoration:
                result = addDecoration(data);
                break;
            case InsertDecoration:
                result = insertDecoration(data);
                break;
            case AddDog:
                result = addDog(data);
                break;
            case FeedDog:
                result = feedDog(data);
                break;
            case CalculateValue:
                result = calculateValue(data);
                break;
            case Report:
                result = report();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;

    }

    public String addCage(String[] data) {
        String cageType = data[0];
        String cageName = data[1];

        return this.controller.addCage(cageType, cageName);
    }


    public String addDecoration(String[] data) {
        String type = data[0];

        return this.controller.addDecoration(type);
    }


    public String insertDecoration(String[] data) {
        String cageName = data[0];
        String decorationType = data[1];

        return this.controller.insertDecoration(cageName, decorationType);
    }


    public String addDog(String[] data) {
        String cageName = data[0];
        String dogType = data[1];
        String dogName = data[2];
        String dogSpecies = data[3];
        double price = Double.parseDouble(data[4]);

        return this.controller.addDog(cageName, dogType, dogName, dogSpecies, price);
    }


    public String feedDog(String[] data) {
        String dogName = data[0];

        return this.controller.feedDog(dogName);
    }

    public String calculateValue(String[] data) {
        String cageName = data[0];

        return this.controller.calculateValue(cageName);
    }

    public String report() {
        return this.controller.report();
    }
}
