public class Main
{
	public static void main(String[] args)
	{
		Settings settings = Settings.getInstance();
		DBConnection connection = DBConnection.getInstance();
		settings.setDBHost("localhost");
		settings.save();

	}
}
