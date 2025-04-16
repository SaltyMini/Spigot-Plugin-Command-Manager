package com.ciderMC.spigotPluginCommandManager.commands.subCommands;

import com.ciderMC.spigotPluginCommandManager.commands.CommandStruct;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExampleCommand extends CommandStruct {
    @Override
    public String getName() {
        return "ExampleCommand";
    }

    @Override
    public String getDescription() {
        return "Simple Example Command";
    }

    @Override
    public String getSyntax() {
        return "/examplecommand";
    }

    @Override
    public String[] getAliases() {
        return new String[] {"example", "excmd" };
    }

    @Override
    public void commandRun(CommandSender commandSender, String[] args) {

        Player player = (Player) commandSender;
        player.sendMessage("You have run the ExampleCommand!");

    }
}
