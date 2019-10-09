import java.util.prefs.Preferences;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Settings
{

	private Preferences preferenceFile = null;
	private Boolean fileExists = false;

	private Settings(){
	preferenceFile = Preferences.userRoot().node("HotelReservation.properties");

	try(InputStream input = new FileInputStream("HotelReservation.properties"))
	{
		preferenceFile.importPreferences(input);
		fileExists = true;
	}
	catch(Exception e)
	{
		fileExists = false;
		e.printStackTrace();
	}
	}
	private static class Singleton
	{
		private static final Settings INSTANCE = new Settings();
	}

	public static Settings getInstance()
	{
		return Singleton.INSTANCE;
	}

	public Boolean fileExists()
	{
		return fileExists;
	}

	public void save()
	{
		try(OutputStream output = new FileOutputStream("HotelReservation.properties"))
		{
			preferenceFile.exportSubtree(output);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

    public String getLocaleCountry()
    {
        return preferenceFile.get("LocaleCountry","none");
    }
    public String getLocaleLang()
    {
        return preferenceFile.get("LocaleLang","none");
    }

	public String getDBHost()
	{

		return preferenceFile.get("DBHost", "localhost");
	}

	public String getDBName()
	{
		return  preferenceFile.get("DBName", "hotelreservation");
	}

	public String getDBUser()
	{
		return  preferenceFile.get("DBUser", "hotelreservation");
	}

	public String getDBPassword()
	{
		return  preferenceFile.get("DBPassword", "HotelReservation");
	}
    
    public void setLocaleCountry(String localeCountry)
    {
        preferenceFile.put("LocaleCountry", localeCountry);
    }

    public void setLocaleLang(String localeLang)
    {
        preferenceFile.put("LocaleLang", localeLang);
    }

	public void setDBHost(String host)
	{
		preferenceFile.put("DBHost", host);
	}

	public void setDBName(String name)
	{
		preferenceFile.put("DBName", name);
	}

	public void setDBUser(String user)
	{
		preferenceFile.put("DBUser", user);
	}

	public void setDBPassword(String password)
	{
		preferenceFile.put("DBPassword", password);
	}
}
