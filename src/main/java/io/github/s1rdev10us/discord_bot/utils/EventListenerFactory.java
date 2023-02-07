package io.github.s1rdev10us.discord_bot.utils;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.annotation.Nonnull;

public class EventListenerFactory<E> {
	public String eventName="";
	public void execute(@Nonnull E event){}
}
