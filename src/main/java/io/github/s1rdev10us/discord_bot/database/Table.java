package io.github.s1rdev10us.discord_bot.database;
import java.lang.Record;
import java.util.List;

public abstract class Table {
	public void setup(){}
	
	
	public List<Record> getRecords(){
		return null;
	}
	
	public String getName(){
		String[] packageName=this.getClass().getName().split("\\.");
		return packageName[packageName.length-1];
	}
}
