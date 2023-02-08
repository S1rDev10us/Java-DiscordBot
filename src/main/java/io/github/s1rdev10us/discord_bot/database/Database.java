package io.github.s1rdev10us.discord_bot.database;

import io.github.s1rdev10us.discord_bot.database.records.Channel;
import io.github.s1rdev10us.discord_bot.database.records.Server;
import io.github.s1rdev10us.discord_bot.database.records.User;

import java.io.*;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static io.github.s1rdev10us.discord_bot.Main.DEFAULT_PREFIX;
import static io.github.s1rdev10us.discord_bot.Main.LOGGER;

public record Database(Table<User> users, Table<Channel> channels, Table<Server> servers, List<String> oldPrefixes,
					   String prefix) implements Serializable {
	public boolean serialize(String location) {
		return this.serialize(Path.of(location));
	}
	
	public boolean serialize(Path location) {
		return this.serialize(location.toUri());
	}
	
	public boolean serialize(URI location) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(location));
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(this);
			
			objectOutputStream.close();
			fileOutputStream.close();
			
			LOGGER.info("");
			
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	
	public static Database deserialize(String location) {
		return Database.deserialize(Path.of(location));
	}
	
	public static Database deserialize(Path location) {
		return Database.deserialize(location.toUri());
	}
	
	public static Database deserialize(URI location) {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(location));
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Object objDatabase = objectInputStream.readObject();
			if (Database.class.equals(objDatabase.getClass())) {
				objectInputStream.close();
				fileInputStream.close();
				LOGGER.info("Deserialized database");
				return (Database) objDatabase;
			}
			
		} catch (IOException | ClassNotFoundException ignored) {
		
		}
		LOGGER.info("Database not found, creating new one");
		return new Database(new Table<>(), new Table<>(), new Table<>(), new ArrayList<>(), DEFAULT_PREFIX);
	}
	
}
