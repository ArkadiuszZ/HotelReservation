import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Platform;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        CalendarTab ctab = CalendarTab.getInstance();
        OptionsTab otab = OptionsTab.getInstance();
        MainWindow window = MainWindow.getInstance();
        propagateMenu();
        primaryStage.setTitle(Translation.tr("hotel_reservation"));
        primaryStage.setScene(window.getScene());
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    public void propagateMenu()
    {
        WindowMenu windowMenu = WindowMenu.getInstance();
        MenuItem quit = new MenuItem(Translation.tr("quit"));
        quit.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override public void handle(ActionEvent e)
                    {
                        Platform.exit();
                        System.exit(0);
                    }
                });
        windowMenu.addMenuItem(Translation.tr("file"), quit);
    }
}
