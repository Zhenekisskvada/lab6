package run;

import java.util.Scanner;
import commands.*;
import org.gradle.api.tasks.Console;
import utils.*;
import network.TCPClient;

public class App {


        //public static final String PS1 = "$ ";
        //public static final String PS2 = "> ";
        public static void main(String[] args) {
                Scanner userScanner = new Scanner(System.in);
                final String nameFile = args[0];
                TCPClient = new TCPClient();
                //MarineAsker marineAsker = new MarineAsker(userScanner);
                //FileManager fileManager = new FileManager(nameFile);
                //CollectionHandler collectionHandler = new CollectionHandler(fileManager);
                //CommandManager commandManager = new CommandManager(
               //         new HelpCommand(),
                //        new InfoCommand(collectionHandler),
                //        new ShowCommand(collectionHandler),
                //        new AddCommand(collectionHandler, marineAsker),
                //        new UpdateCommand(collectionHandler, marineAsker),
                //        new RemoveByIdCommand(collectionHandler),
                //        new ClearCommand(collectionHandler),
                //        new ExitCommand(),
                //        new ExecuteScriptCommand(),
                 //       new AddIfMinCommand(collectionHandler, marineAsker),
                 //       new AddIfMaxCommand(collectionHandler, marineAsker),
                 //       new RemoveLowerCommand(collectionHandler, marineAsker),
                 //       new AverageOfHealthCommand(collectionHandler),
                 //       new FilterStartsWithNameCommand(collectionHandler),
                 //       new CountGreaterThanMeleeWeaponCommand(collectionHandler)
                //);
               // Console console = new Console(commandManager, userScanner, marineAsker);
                Console console = new Console(userScanner)
                while (true){
                    //console.interactiveMode();
                    Console.print("> ")
                    String input = userScanner.nextLine();
                    client.sendRequest(input);

            }
        }
    }