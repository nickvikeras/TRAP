package edu.umn.se.trap.db;

public enum DatabaseSingleton
{
    INSTANCE;
    private final static FormDB formDB = new FormDB();

    public static FormDB getFormDBInstance()
    {
	return formDB;
    }
}