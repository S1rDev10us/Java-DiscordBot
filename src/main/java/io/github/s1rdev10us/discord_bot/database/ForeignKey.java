package io.github.s1rdev10us.discord_bot.database;

import java.io.Serializable;

public record ForeignKey<E>(PrimaryKey key, Table<E> table) implements Serializable {

}
