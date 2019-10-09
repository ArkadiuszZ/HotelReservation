import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;

public class MainWindow{
    Scene scene = null;
    TabPane tabPane = null;

    private MainWindow()
    {
        VBox root = new VBox();
        scene = new Scene(root, 800, 600);
        tabPane = new TabPane();
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(tabPane);
        mainPane.prefHeightProperty().bind(scene.heightProperty());
        mainPane.prefWidthProperty().bind(scene.widthProperty());
        root.getChildren().add(WindowMenu.getInstance().getMenuBar());
        root.getChildren().add(mainPane);
        scene.getStylesheets().add(getClass().getResource("resources/style.css").toExternalForm());
    }

    private static class Singleton
    {
        private static final MainWindow INSTANCE = new MainWindow();
    }
    public static MainWindow getInstance()
    {
        return Singleton.INSTANCE;
    }
    public Scene getScene()
    {
        return Singleton.INSTANCE.scene;
    }

    public void putTab(Tab tab)
    {
        if(!tabPane.getTabs().contains(tab))
        {
            tabPane.getTabs().add(tab);
        }
        tabPane.getSelectionModel().select(tab);
    }
}

