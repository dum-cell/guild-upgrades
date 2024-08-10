package me.dum.guildupgrades;

import lombok.Getter;
import me.dum.guildupgrades.commands.UpgradeCommand;
import me.dum.guildupgrades.manager.GuildManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GuildUpgrades extends JavaPlugin {

    @Getter private static GuildUpgrades instance;

    @Getter private GuildManager guildManager;

    @Override
    public void onEnable(){
        instance = this;
        guildManager = new GuildManager();

        getCommand("upgrade").setExecutor(new UpgradeCommand());
    }

    @Override
    public void onDisable(){

    }
}
