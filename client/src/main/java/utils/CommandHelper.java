package utils;
import java.io.Serializable;
import java.util.HashMap;
import commands.*;

public class CommandHelper implements Serializable{
    public static HashMap<String, String> commandList(){
        HashMap<String, String > map = new HashMap<String, String>();
        map.put("help", "print help for all available commands");
        map.put("add", "add new element to the collection");
        map.put("add_if_max", "add a new element to the collection, if its value is greater than the value of the largest element of this collection");
        map.put("add_if_min", "add a new element to the collection, if its value is lower than the value of the minimal element of this collection");
        map.put("average_of_health", "display the average value of the health field for all elements of the collection");
        map.put("clear", "clear the collection");
        map.put("count_greater_than_melee_weapon meleeWeapon", "print the number of elements, the value of the meleeWeapon field is greater than the given one");
        map.put("execute_script <file_name>", "execute script from specified file");
        map.put("exit", "terminate program");
        map.put("filter_starts_with_name name", "display elements whose name field value starts with the given substring");
        map.put("info", "display information about the collection");
        map.put("remove_by_id <ID>", "remove item from collection by ID");
        map.put("remove_lower {element}", "remove from the collection all elements smaller than the given one");
        map.put("show", "display all elements of the collection");
        map.put("update <ID> {element}", "update collection element value by ID");
        return map;
    }

    public static HashMap<String , Command> argCheckMap(){

        HashMap<String, Command> map = new HashMap<String, Command>();

        map.put("help", new HelpCommand());
        map.put("add", new AddCommand());
        map.put("add_if_max", new AddIfMaxCommand());
        map.put("add_if_min", new AddIfMinCommand());
        map.put("average_of_health", new AverageOfHealthCommand());
        map.put("clear", new ClearCommand());
        map.put("count_greater_than_melee_weapon meleeWeapon", new CountGreaterThanMeleeWeaponCommand());
        map.put("execute_script <file_name>", new ExecuteScriptCommand());
        map.put("exit", new ExitCommand());
        map.put("filter_starts_with_name name", new FilterStartsWithNameCommand());
        map.put("info", new InfoCommand());
        map.put("remove_by_id <ID>", new RemoveByIdCommand());
        map.put("remove_lower {element}", new RemoveLowerCommand());
        map.put("show", new ShowCommand());
        map.put("update <ID> {element}", new UpdateCommand());
        return map;
    }
}