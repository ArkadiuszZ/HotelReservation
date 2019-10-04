import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Settings;

public class DBConnection {
	Connection current_connection = null;
	public static Connection connector()
	{
		String url=(new StringBuilder())
			.append("jdbc:postgresql://")
			.append(settings.getDBHost())
			.append("/")
			.append(settings.getDBName());
		String user = settings.getDBUser();
		String.password = settings.getDBPassword();
		try{
			current_connection = DriverManager.getConnection(url, user, password);
	} catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	return current_connection;
	}
}

