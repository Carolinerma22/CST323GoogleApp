package com.gcu.milestone.data;

public interface UsersDataAccessInterface <T> {
	public T findByUsername(String username);
}
