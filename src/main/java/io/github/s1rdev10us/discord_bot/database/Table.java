package io.github.s1rdev10us.discord_bot.database;

import java.io.Serializable;
import java.util.Dictionary;

public class Table<E> implements Serializable {
	private Dictionary<PrimaryKey, E> records;
	
	public Dictionary<PrimaryKey, E> getRecords() {
		return records;
	}
	
	public E getRecord(PrimaryKey key) {
		return records.get(key);
	}
	
	public void setRecord(PrimaryKey key, E value) {
		records.put(key, value);
	}
	
	public String getName() {
		String[] packageName = this.getClass().getName().split("\\.");
		return packageName[packageName.length - 1];
	}
}
