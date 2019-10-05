import java.util.prefs.Preferences;

public class Settings
{

	private Preferences preferenceFile = Preferences.userRoot().node("HotelReservation.properties");

	public String getDBHost()
	{
		return preferenceFile.get("DBHost", "localhost");
	}

	public String getDBName()
	{
		return  preferenceFile.get("DBName", "HotelReservation");
	}

	public String getDBUser()
	{
		return  preferenceFile.get("DBUser", "HotelReservation");
	}

	public String getDBPassword()
	{
		return  preferenceFile.get("DBPassword", "HotelReservation");
	}

	public void setDBHost(String host)
	{
		preferenceFile.put("DBHost", host);
	}

	public void setDBName(String name)
	{
		preference.put("DBName", name);
	}

	public void setDBUser(String user)
	{
		preference.put("DBUser", user);
	}

	public void setDBPassword(String password)
	{
		preference.put("DBPassword", password);
	}
}
