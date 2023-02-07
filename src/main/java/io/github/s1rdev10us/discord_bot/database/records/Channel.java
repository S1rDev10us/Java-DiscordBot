package io.github.s1rdev10us.discord_bot.database.records;

import io.github.s1rdev10us.discord_bot.database.PrimaryKey;
import java.io.Serializable;

public record Channel(String name, boolean gamesInChannel) implements Serializable {
}
