package me.dum.guildupgrades.manager;

import me.dum.guildupgrades.entities.Guild;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuildManager {
    private final List<Guild> guilds = new ArrayList<>();

    public GuildManager() {
        // Dummy guild creation to show how it'd work, normally this is through a player creating a guild or whatever system you already have
        guilds.add(new Guild(UUID.randomUUID()));
    }

    public void add(Guild guild){
        guilds.add(guild);
    }

    public void remove(Guild guild){
        guilds.remove(guild);
    }

    public Guild get(UUID owner){
        for(Guild guild : guilds){
            if(guild.getOwner().equals(owner)){
                return guild;
            }
        }
        return null;
    }
}
