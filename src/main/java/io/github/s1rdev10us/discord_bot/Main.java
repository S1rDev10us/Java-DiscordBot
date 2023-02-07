package io.github.s1rdev10us.discord_bot;

import io.github.s1rdev10us.discord_bot.database.Database;
import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;
import java.util.logging.Logger;

public class Main {
	public static final String PROJECT_NAME = "Java Discord Bot";
	public static final Logger LOGGER = Logger.getLogger(PROJECT_NAME);
	public static final String DATABASE_LOCATION = "./Database.xml";
	public static final Database DATABASE = Database.deserialize(DATABASE_LOCATION);
	public static final String DEFAULT_PREFIX = "!";
	public static final EventContainer EVENT_CONTAINER = new EventContainer();
	
	public static void main(String[] arguments) throws Exception {
		ProcessedData processedData;
		
		Reader reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/processedData.json")));
		
		processedData = new Gson().fromJson(reader, ProcessedData.class);
		
		if (Objects.equals(processedData.Events(), "${events}")) throw new Exception("The events were not properly processed, check build config");
		if (Objects.equals(processedData.EventListenerTypes(), "${eventListeners}")) throw new Exception("The event listeners were not properly processed, check build config");
		
		
		System.out.println(processedData.Events());  // Does not print "bat"
		System.out.println(processedData.EventListenerTypes());  // Does not print "bat"
		
		
		for (String e : processedData.Events().split(",")) {
			EVENT_CONTAINER.registerEventListener(Class.forName(e));
		}
		
		for (String e : processedData.EventListenerTypes().split(",")) {
			EVENT_CONTAINER.registerEventListener(Class.forName(e));
		}
		
		Exception e = null;
		try {
			TokenManager tokenManager = new TokenManager();
//			JDA api = JDABuilder.createDefault(tokenManager.getToken()).build();
//			api.addEventListener(new EventListener(DATABASE,EVENT_CONTAINER,LOGGER));
		} catch (Exception eT) {
			e = eT;
		}
		DATABASE.serialize("");
		if (e != null) throw e;
	}
}
