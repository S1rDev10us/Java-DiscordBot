package io.github.s1rdev10us.discord_bot.database;

import java.util.Objects;

public record PrimaryKey<E>(E key) {
	public E getKey() {
		return key;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PrimaryKey<?> that = (PrimaryKey<?>) o;
		return Objects.equals(key, that.key);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(key);
	}
}
