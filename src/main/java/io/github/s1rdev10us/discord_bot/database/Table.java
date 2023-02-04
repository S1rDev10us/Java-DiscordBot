package io.github.s1rdev10us.discord_bot.database;

public abstract class Table {
	public String getName(){
		String[] packageName=this.getClass().getName().split("\\.");
		return packageName[packageName.length-1];
	}
	
	public abstract static class Record{
	
	}
}
