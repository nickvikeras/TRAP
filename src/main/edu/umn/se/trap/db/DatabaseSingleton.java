package edu.umn.se.trap.db;

public enum DatabaseSingleton
{
    INSTANCE;
    private final CurrencyDB currencyDB = new CurrencyDB();
    private final FormDB formDB = new FormDB();
    private final GrantDB grantDB = new GrantDB();
    private final PerDiemDB perDiemDB = new PerDiemDB();
    private final UserDB userDB = new UserDB();
    private final UserGrantDB UserGrantDB = new UserGrantDB();

    public CurrencyDB getCurrencyDBInstance()
    {
	return currencyDB;
    }

    public FormDB getFormDBInstance()
    {
	return formDB;
    }

    public GrantDB getGrantDBInstance()
    {
	return grantDB;
    }

    public PerDiemDB getPerDiemDBInstance()
    {
	return perDiemDB;
    }

    public UserDB getUserDBInstance()
    {
	return userDB;
    }

    public UserGrantDB getUserGrantDBInstance()
    {
	return UserGrantDB;
    }
}