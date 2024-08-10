package me.dum.guildupgrades.menus;

import me.dum.guildupgrades.entities.Guild;
import me.dum.guildupgrades.entities.GuildUpgradeType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class UpgradeMenu {
    private final Guild guild;
    private final Player p;

    public UpgradeMenu(Guild guild, Player p) {
        this.guild = guild;
        this.p = p;
    }

    public void display(){
        // in here, a menu would show with buttons to upgrade, fetched from a config file, and when they click on it, the handeClick() method would be executed
    }

    // you mentioned you didn't want the actual GUI, just the click functionality, when they click on the upgrade button in the menu, this method executes
    // the price and the upgrade type would be from a config file to make sure everything is configurable
    public void handleClick(long price, GuildUpgradeType type, Guild guild){
        if(guild.getCoinsBalance() < price){
            p.sendMessage(c("&C&l(!)&C Your guild does not have enough coins for this!"));
            return;
        }

        guild.setCoinsBalance(guild.getCoinsBalance() - price);

        long currentLevel = guild.getUpgradeLevels().getOrDefault(type, 0L);


        // maybe implement a max level?
        // get the max level from a config file
        long maxLevel = 10;
        if(currentLevel == maxLevel){
            p.sendMessage(c("&C&l(!)&C This upgrade is already the max level!"));
            return;
        }

        guild.getUpgradeLevels().put(type, currentLevel + 1);
        p.sendMessage(c("&a&l(!)&A You have successfully upgraded this upgrade to level " + currentLevel + 1));
    }


    private String c(String input){
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
