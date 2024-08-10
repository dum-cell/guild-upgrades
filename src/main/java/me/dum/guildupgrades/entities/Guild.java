package me.dum.guildupgrades.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@RequiredArgsConstructor
public class Guild {
    private final UUID owner;
    private final List<UUID> members = new ArrayList<>();
    @Setter private long coinsBalance;
    private final Map<GuildUpgradeType, Long> upgradeLevels = new HashMap<>();
}
