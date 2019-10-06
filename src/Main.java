import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		MainWindow window = new MainWindow();
		primaryStage.setTitle("Hotel Reservation");
		primaryStage.setScene(window.getScene());
		primaryStage.show();
	}

	public static void main(String[] args)
	{
		Settings settings = Settings.getInstance();
		DBConnection connection = DBConnection.getInstance();
		launch(args);
	}
}
