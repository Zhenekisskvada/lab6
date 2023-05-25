package commands;

import exceptions.WrongAmountOfElementsException;
import utils.Console;

public class ExitCommand extends AbstractCommand {

    public ExitCommand() {
        super("exit", "terminate program");
    }

    @Override
    public boolean execute(String arg) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("usage: '" + getName() + "'");
        }
        return false;
    }
}