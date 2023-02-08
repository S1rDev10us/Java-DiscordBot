package io.github.s1rdev10us.discord_bot;

import io.github.s1rdev10us.discord_bot.database.Database;
import io.github.s1rdev10us.discord_bot.utils.EventContainer;
import io.github.s1rdev10us.discord_bot.utils.EventListenerFactory;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class EventListener extends ListenerAdapter {
	private final Database database;
	private final EventContainer eventContainer;
	private static Logger LOGGER;
	
	public EventListener(Database database, EventContainer eventContainer, Logger logger) {
		this.database = database;
		this.eventContainer = eventContainer;
		EventListener.LOGGER = logger;
	}
	
	@Override
	public void onSlashCommand(@NotNull SlashCommandEvent event) {
	
	}
	
	@Override
	public void onMessageReceived(@NotNull MessageReceivedEvent event) {
		String originalMessageString = event.getMessage().toString();
		if (!originalMessageString.startsWith(Main.DATABASE.prefix())) return;
		if (originalMessageString.length() <= Main.DATABASE.prefix().length()) return;
		if (event.getAuthor().isBot()) return;
		
		LOGGER.info("Command sent \"%s\"".formatted(event.getMessage().toString()));
		
		String eventName = originalMessageString.substring(Main.DATABASE.prefix().length()).split(" ")[0];
		
		EventListenerFactory<MessageReceivedEvent> messageCommandEventListener = eventContainer.getEvent(MessageReceivedEvent.class, eventName);
		if (messageCommandEventListener != null) {
			messageCommandEventListener.execute(event, database, LOGGER);
		}
		
	}
}
