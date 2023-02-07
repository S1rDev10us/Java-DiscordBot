package io.github.s1rdev10us.discord_bot;

import io.github.s1rdev10us.discord_bot.utils.EventListenerFactory;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Dictionary;
import java.util.Hashtable;

public class EventContainer {
	private final Dictionary<Class<Event>, Dictionary<String, EventListenerFactory<? extends Event>>> EventListeners = new Hashtable<>();
	
	public void registerEventListener(Class<?> event) {
		Object eventObj;
		try {
			eventObj = event.getDeclaredConstructor().newInstance();
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
				 InvocationTargetException ignored) {
			return;
		}
		
		
		if (!EventListenerFactory.class.isAssignableFrom(event)) return;
		
		Class<EventListenerFactory<?>> eventListenerFactory = ((Class<EventListenerFactory<?>>) event);
		
		
		Class<Event> actualTypeArgument = (Class<Event>) ((ParameterizedType) eventListenerFactory.getDeclaringClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
		Dictionary<String, EventListenerFactory<? extends Event>> EventListenerFactoryList = EventListeners.get(actualTypeArgument);
		
		if (EventListenerFactoryList == null) {
			EventListeners.put(actualTypeArgument, new Hashtable<>());
			EventListenerFactoryList = EventListeners.get(actualTypeArgument);
		}
		
		EventListenerFactory<? extends Event> eventClassedObj = (EventListenerFactory<? extends Event>) eventObj;
		
		EventListenerFactoryList.put(eventClassedObj.eventName, eventClassedObj);
		
		
	}
	
	public Dictionary<String, EventListenerFactory<? extends Event>> getEventListeners(Class<? extends Event> EventType) {
		return EventListeners.get(EventType);
	}
	public <E extends Event> EventListenerFactory<E> getEvent(Class<E> EventType, String EventName){
		return (EventListenerFactory<E>) this.getEventListeners((Class<? extends Event>) MessageReceivedEvent.class).get(EventName);
	}
}
