import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle;

public class Translation 
{
    Locale currentLocale = null;
    ResourceBundle words = null;
    private Translation()
    {
        Settings settings = Settings.getInstance();
        String country = settings.getLocaleCountry();
        String lang = settings.getLocaleLang();
        if(country == "none" || lang == "none")
        {
//            currentLocale = Locale.ENGLISH;
            currentLocale = Locale.getDefault();
        }
        try
        {
            words = ResourceBundle.getBundle("resources/words", currentLocale);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    } 
    private static class Singleton
    {
        private static final Translation INSTANCE = new Translation();
    }
    public static Translation getInstance()
    {
        return Singleton.INSTANCE;
    }

    public static String tr(String key)
    {
        return Singleton.INSTANCE.words.getString(key);
    }

}
