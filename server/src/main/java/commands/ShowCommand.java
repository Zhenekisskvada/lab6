package commands;

import exceptions.WrongAmountOfElementsException;
import utils.CollectionHandler;

public class ShowCommand extends AbstractCommand {
    private CollectionHandler collectionHandler;

    public ShowCommand(CollectionHandler collectionHandler) {
        super("show", "display all elements of the collection");
        this.collectionHandler = collectionHandler;
    }

    @Override
    public boolean execute(String arg) {
        try {
            if (!arg.isEmpty()) throw new WrongAmountOfElementsException();
            System.out.println(collectionHandler);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            System.out.println("usage: '" + getName() + "'");
        }
        return false;
    }
}
