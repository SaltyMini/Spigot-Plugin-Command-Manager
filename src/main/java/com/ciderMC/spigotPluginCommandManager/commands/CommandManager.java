package com.ciderMC.spigotPluginCommandManager.commands;

import com.ciderMC.spigotPluginCommandManager.commands.subCommands.ExampleCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandManager implements CommandExecutor {

    private final ArrayList<CommandStruct> commandStruct = new ArrayList<>(); //list of all commands

    public CommandManager() {
        commandStruct.add(new ExampleCommand()); //adds example command to command structure
        //TODO: add new commands
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        //Here I have done two implementations which can be used separately or together


        //This implementation is for prefixing all commands with a keyword, in this example customcommand.
        //This would result in the commands looking like
        // /customcommands examplecommand
        // /customcommands help
        if(command.getLabel().equalsIgnoreCase("customcommands")) {

            // Check if args is empty
             if (args.length == 0) {
                  commandSender.sendMessage("Use '/customcommands help' to see available commands");
                 return true;
             }

            if(args[0].equalsIgnoreCase("help")) {
                help(commandSender, args);
                return true;
            }

            for (CommandStruct cmd : getCommandStruct()) {
                if (args[0].equalsIgnoreCase(cmd.getName()) //This checks if the args[0] exists as a commandName
                        || Arrays.asList(cmd.getAliases()).contains(args[0])) { //This checks if the args[0] exists as an alias
                    commandSender.sendMessage("Command found: " + cmd.getName());
                    cmd.commandRun(commandSender, args);
                }
            }

        }

        //if you use only the second implementation, you need to use another help method such as:
        //if(command.getLabel().equalsIgnoreCase("PluginName") && args[0].equalsIgnoreCase("help")) {
        //    help(commandSender, args);
        //    return true;
        //}


        //This is the second implementation where the command is run without a prefix
        //This would result in the commands looking like
        // /examplecommand
        // /anothercommand
        for (CommandStruct cmd : getCommandStruct()) {
            if (command.getLabel().equalsIgnoreCase(cmd.getName())
                    || Arrays.asList(cmd.getAliases()).contains(command.getLabel())) {

                //Optional per command info/help command
                if (args[0].equalsIgnoreCase("help")) {
                    commandSender.sendMessage("Command name: " + cmd.getName());
                    commandSender.sendMessage("Command help: " + cmd.getDescription());
                    commandSender.sendMessage("Command syntax: " + cmd.getSyntax());
                    commandSender.sendMessage("Command aliases: " + Arrays.toString(cmd.getAliases()));
                }

                commandSender.sendMessage("Command found: " + cmd.getName());
                cmd.commandRun(commandSender, args);
                return true;
            }
        }


        return true;
    }

    public void help(CommandSender commandSender, String[] args) {
    // Handle help command
        if (args[0].equalsIgnoreCase("help")) {

            int countMax;

            try {
                countMax = Integer.parseInt(args[0]) * 10;
            } catch (NumberFormatException e) {
                countMax = 10;
            }

            int count = countMax - 10;

            for(CommandStruct cmd : getCommandStruct()) {
                while (count < countMax) {
                    commandSender.sendMessage("/" + cmd.getSyntax() + " - " + cmd.getDescription());
                    count++;
                }
            }
        }
    }

    public ArrayList<CommandStruct> getCommandStruct() {
        return commandStruct;
    } // returns the command list
}