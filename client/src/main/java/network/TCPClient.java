package network;
import requests.Request;
import.utils.CommandHelper;
import utils.MarineAsker;
import commands.Command;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import utils.Console;

public Class TCPClient {
    private String host = "localhost";
    private int port = 4444;
    private SocketChannel = clientSocket;

    public boolean connectToServer() throws IOException {
        try{
            this.clientSocket = SocketChannel.open(new InetSocketAddress(host, port));
            return true;
        } catch (IOException ioe) {
            Console.println("Connection error: " + ioe.getMessage());
            return false;
        }
    }

    public void closeConnection() throws IOException {
        this.clientSocket.close();
        }

    public boolean sendRequests(String input) throws IOException, InterruptedException {
        String [] tokens = input.split("\\s+");
        String command = tokens[0];
        String argument = tokens[1];

        if (!CommandHelper.commandList().containsKey(command)){
            Console.printerror("no such command");
            return false;
        }

        if (command.equals("exit")){
            new ExitCommand.execute(argument);
            return true;
        }

        if (command.equals("help")){
            new HelpCommand.execute(argument);
            return true;
        }

        if (command.equals("execute_script <file_name>")){
            new ExecuteScriptCommand(CommandHelper.commandList(), this).execute(argument);
            return true;
        }

        if (!CommandHelper.argCheckMap().get(command).execute(argument)){
            return false;
        }

        if (connectToServer()){
            ObjectOutput objectOutput = new ObjectOutputStream(this.clientSocket.socket().getOutputStream());
            InputStream in = new BufferedInputStream(clientSocket.socket().getInputStream());
            if (command.equals("add") || command.equals("update")){
                objectOutput.writeObject(new Request(command, argument, new MarineAsker()));
        } else {
                objectOutput.writeObject(new Request(command, argument, null));
        }

        String str_in = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        Console.print(str_in);
        in.close();
        objectOutput.close();
        closeConnection();
        }
        return true;
    }
}
