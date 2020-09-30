package com.company.core;

import com.company.commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static com.company.messages.ExceptionMessages.*;

public class Run implements RunInter {
    private DogShelter dogShelter;
    private BufferedReader reader;

    public Run() {
        this.dogShelter = new DogShelter();
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
        String[] data = Arrays.stream(tokens).skip(2).toArray(String[]::new);

        if(!Commands.checkIsValidCommand(tokens[0]))
            throw new  IllegalArgumentException(String.format(INVALID_COMMAND, tokens[0]));

        return executeCommand(tokens[0], tokens[1],data);
    }

    public String executeCommand(String command, String commandType, String[] data) {
        String result = null;

        switch(Commands.valueOf(command.toUpperCase())) {
            case ADD:
                AddCommand addCommand = new AddCommand(data);
                result = addCommand.execute(command, commandType, dogShelter);
                break;

            case INSERT:
                InsertCommand insertCommand = new InsertCommand(data);
                result = insertCommand.execute(command, commandType, dogShelter);
                break;

            case FEED:
                FeedCommand feedCommand = new FeedCommand(data);
                result = feedCommand.execute(command, commandType, dogShelter);
                break;

            case CALCULATE:
            case TREATMENT:
            case CHECKTREATMENT:
            case ADOPT:
            case REPORT:
                ReportCommand reportCommand = new ReportCommand();
                result = reportCommand.execute(command, commandType, dogShelter);
                break;

            case EXIT:
                result = Commands.EXIT.name();
                break;
        }

        return result;
    }

    public String calculateValue(String[] data) {
        String cageName = data[0];

        return this.dogShelter.calculateValue(cageName);
    }

    public String setTreatmentType(String[] data) {
        String animalName = data [0];
        String treatmentType = data [1];
        return this.dogShelter.setTreatmentType(animalName, treatmentType);
    }

    public String checkTreatmentPhase(String[] data) {
        String animalName = data[0];
        return this.dogShelter.checkTreatmentPhase(animalName);
    }

    public String adoptAnimal(String[] data) {
        String animalName = data[0];
        String personName = data[1];
        return this.dogShelter.adoptAnimal(animalName, personName);
    }
}
