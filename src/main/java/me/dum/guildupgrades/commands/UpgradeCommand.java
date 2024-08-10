package me.dum.guildupgrades.commands;

import me.dum.guildupgrades.GuildUpgrades;
import me.dum.guildupgrades.entities.Guild;
import me.dum.guildupgrades.menus.UpgradeMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UpgradeCommand implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player p)) return true;

        Guild guild = GuildUpgrades.getInstance().getGuildManager().get(p.getUniqueId());

        if(guild == null){
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(!)&C You do not have a guild!"));
            return true;
        }


        new UpgradeMenu(guild, p);


        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }
}
