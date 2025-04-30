package com.ciderMC.spigotPluginCommandManager;

import com.ciderMC.spigotPluginCommandManager.commands.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SpigotPluginCommandManager extends JavaPlugin {

    @Override
    public void onEnable() {
        // Sets the general command lable
        Objects.requireNonNull(getCommand("customcommands")).setExecutor(new CommandManager());

        // For using commandNames as a command lable
        Objects.requireNonNull(getCommand("examplecommand")).setExecutor(new CommandManager());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
