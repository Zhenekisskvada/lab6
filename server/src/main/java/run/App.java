package run;

import java.util.Scanner;
import commands.*;
import org.gradle.api.tasks.Console;
import utils.*;
import network.TCPServer;

public class App {


        public static final String PS1 = "$ ";
        public static final String PS2 = "> ";
        public static void main(String[] args) {
                Scanner userScanner = new Scanner(System.in);
                final String nameFile = args[0];
                MarineAsker marineAsker = new MarineAsker(userScanner);
                FileManager fileManager = new FileManager(nameFile);
                CollectionHandler collectionHandler = new CollectionHandler(fileManager);
                TCPServer server = new TCPServer;
                CommandManager commandManager = new CommandManager(
                        new InfoCommand(collectionHandler, server),
                        new ShowCommand(collectionHandler, server),
                        new AddCommand(collectionHandler, marineAsker, server),
                        new UpdateCommand(collectionHandler, marineAsker, server),
                        new RemoveByIdCommand(collectionHandler, server),
                        new ClearCommand(collectionHandler, server),
                        new ExitCommand(),
                        new AddIfMinCommand(collectionHandler, marineAsker, server),
                        new AddIfMaxCommand(collectionHandler, marineAsker, server),
                        new RemoveLowerCommand(collectionHandler, marineAsker, server),
                        new AverageOfHealthCommand(collectionHandler, server),
                        new FilterStartsWithNameCommand(collectionHandler, server),
                        new CountGreaterThanMeleeWeaponCommand(collectionHandler, server)
                        HashMap<String, Command> map= new HashMap<String, Command>();
                map.put(infoCommand.getName(), infoCommand);
                map.put(showCommand.getName(), showCommand);
                map.put(addCommand.getName(), addCommand);
                map.put(removeByIdCommand.getName(), removeByIdCommand);
                map.put(updateCommand.getName(), updateCommand);
                map.put(clearCommand.getName(), clearCommand);
                map.put(filterStartsWithNameCommand.getName(), filterStartsWithNameCommand);
                map.put(addIfMinCommand.getName()), addIfMinCommand);
                map.put(addIfMaxCommand.getName(), addIfMaxCommand);
                map.put(removeLowerCommand.getName(),removeLowerCommand);
                map.put(averageOfHealthCommand.getName(), averageOfHealthCommand);
                map.put(countGreaterThanMeleeWeaponCommand.getName(), countGreaterThanMeleeWeaponCommand);

                Command executeScriptCommand = new ExecuteScriptCommad(map);
                map.put(executeScriptCommand.getName(), executeScriptCommand);
                Console console = new Console();

                new Thread(() ->{
                        while(true){
                                String command = userScanner.nextLine();
                                if(command.trim().equals(exitCommand.getName())){
                                        scanner.close();
                                        saveCommand.execute(new Request("save",null));
                                        exitCommand.execute(new Request("exit",null));
                                }
                                if(command.trim().equals(saveCommand.getName())){
                                        saveCommand.execute(new Request("save",null));
                                } else {
                                        Console.printerror("No Such Command, server can run only save and exit commands");
                                }
                        }
                })console.interactiveMode(userScanner);

                new Thread(() ->{
                        server.start(map,collectionHandler);
                })console.interactiveMode();
        }
}