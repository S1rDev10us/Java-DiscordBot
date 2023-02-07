package io.github.s1rdev10us.discord_bot.utils.event_listeners;

import io.github.s1rdev10us.discord_bot.utils.EventListenerFactory;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

import javax.annotation.Nonnull;

public class SlashCommandEventListener extends EventListenerFactory<SlashCommandEvent> {
	
	@Override
	public void execute(@Nonnull SlashCommandEvent event){}
}
