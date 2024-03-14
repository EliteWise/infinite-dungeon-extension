package fr.elite.infinitedungeon;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("idj").setExecutor(new IDJCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
