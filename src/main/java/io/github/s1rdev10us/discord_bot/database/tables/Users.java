package io.github.s1rdev10us.discord_bot.database.tables;

import io.github.s1rdev10us.discord_bot.database.Table;

public class Users extends Table {
	
	@Override
	public void setup() {
		super.setup();
	}
	
	public record User() {
	
	}
}
