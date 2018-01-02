package BoatSimulator.contracts;

import BoatSimulator.exceptions.*;

import java.util.List;

public interface CommandHandler {
    String executeCommand(String[] parameters)
            throws DuplicateModelException,
            NonExistingModelException,
            RaceAlreadyExistsException,
            NoSetRaceException,
            InsufficientContestantsException;
}
