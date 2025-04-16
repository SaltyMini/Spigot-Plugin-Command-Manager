package com.ciderMC.spigotPluginCommandManager;

import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotPluginCommandManager extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("customcommands")).setExecutor(new CommandManager());
        Objects.requireNonNull(getCommand("examplecommand")).setExecutor(new CommandManager());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
