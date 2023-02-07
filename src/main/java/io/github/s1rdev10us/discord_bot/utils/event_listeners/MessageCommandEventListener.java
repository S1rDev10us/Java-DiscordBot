package io.github.s1rdev10us.discord_bot.utils.event_listeners;

import io.github.s1rdev10us.discord_bot.utils.EventListenerFactory;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.annotation.Nonnull;

public class MessageCommandEventListener extends EventListenerFactory<MessageReceivedEvent> {
	@Override
	public void execute(@Nonnull MessageReceivedEvent event){}
}
