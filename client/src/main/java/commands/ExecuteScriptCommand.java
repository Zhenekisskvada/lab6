package commands;

import exceptions.WrongAmountOfElementsException;
import utils.Console;
import network.TCPClient;

import java.io.Console;

public class ExecuteScriptCommand extends AbstractCommand {

    private TCPClient client;
    public ExecuteScriptCommand(TCPClient client) {
        super("execute_script <file_name>", "execute script from specified file");
        this.client = client;
    }

    @Override
    public boolean execute(String arg) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            client.sendRequest(arg);
            Console.println("Executing a script '" + argument + "'...");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("usage: '" + getName() + "'");
        }
        return false;
    }
}