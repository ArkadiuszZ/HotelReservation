import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Platform;

public class MainWindow{
	Scene scene = null;
	TabPane tabPane = null;

	public MainWindow()
	{
		Group root = new Group();
		scene = new Scene(root, 400, 300);
		tabPane = new TabPane();
		BorderPane mainPane = new BorderPane();
		mainPane.setCenter(tabPane);
		mainPane.prefHeightProperty().bind(scene.heightProperty());
		mainPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(mainPane);
		root.getChildren().add(WindowMenu.getInstance().getMenuBar());
		propagateMenu();
	}

	public Scene getScene()
	{
		return scene;
	}

	public void putTab(Tab tab)
	{
		tabPane.getTabs().add(tab);
	}
	public void propagateMenu()
	{
		WindowMenu windowMenu = WindowMenu.getInstance();
		Menu myMenu = new Menu("File");
		MenuItem quit = new MenuItem("Quit");
		quit.setOnAction(new EventHandler<ActionEvent>()
				{
			@Override public void handle(ActionEvent e)
			{
				Platform.exit();
				System.exit(0);
			}
		});
		myMenu.getItems().add(quit);
		windowMenu.addMenu(myMenu);
	}
}

