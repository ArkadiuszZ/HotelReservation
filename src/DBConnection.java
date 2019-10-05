import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
	private Connection current_connection = null;
	private Settings settings = null;

	private DBConnection()
	{
		settings = new Settings();
		String url = "jdbc:postgresql://" +
			settings.getDBHost() +
			"/"+
			settings.getDBName();
		String user = settings.getDBUser();
		String password = settings.getDBPassword();
		try{
			current_connection = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	private static class LazyHolder
	{
		private static final DBConnection INSTANCE = new DBConnection();
	}

	public static DBConnection getInstance()
	{
		return LazyHolder.INSTANCE;
	}
}

