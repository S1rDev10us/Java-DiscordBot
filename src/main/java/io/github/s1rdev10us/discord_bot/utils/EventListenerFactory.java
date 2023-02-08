package io.github.s1rdev10us.discord_bot.utils;

import io.github.s1rdev10us.discord_bot.database.Database;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.annotation.Nonnull;
import java.util.logging.Logger;

public class EventListenerFactory<E> {
	public String eventName = "";
	
	public void execute(@Nonnull E event, Database database, Logger logger) {
	}
}
