import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
	private Connection currentConnection;
    private boolean connected = false;

	private DBConnection()
	{
        setConnection();
	}

	private static class Singleton
	{
		private static final DBConnection INSTANCE = new DBConnection();
	}

	public static DBConnection getInstance()
	{
		return Singleton.INSTANCE;
	}
    public void setConnection()
    {
		Settings settings =Settings.getInstance();
		String url = "jdbc:postgresql://" +
			settings.getDBHost() + "/"+
			settings.getDBName();
		String user = settings.getDBUser();
		String password = settings.getDBPassword();
		try{
			currentConnection = DriverManager.getConnection(url, user, password);
            connected = true;
		} catch(SQLException e) {
            connected = false;
			e.printStackTrace();
		} catch(Exception e){
            connected = false;
            e.printStackTrace();
        }
    }
    public boolean isConnected()
    {
        return connected;
    }
}

