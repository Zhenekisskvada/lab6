package requests;
import java.io.Serializable;
import data.SpaceMarine;

public class Request implements Serializable {
    private String commandname;
    private String argument;
    private MarineAsker marineAsker;
    public Request(String commandname, String argument, MarineAsker marineAsker){
        this.commandname = commandname;
        this.argument = argument;
        this.marineAsker = marineAsker;
    }

    public String getCommandName(){
        return commandname;
    }
    public String getArgument(){
        return argument;
    }

    public SpaceMarine getMarineAsker() {
        return marineAsker;
    }
}