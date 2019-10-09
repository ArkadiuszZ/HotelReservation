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

public class OptionsTab {
    private Tab optionTab = null;

    private OptionsTab()
    {
        optionTab = new Tab();
        optionTab.setText(Translation.tr("settings"));
        propagateMenu();


    }
    private static class Singleton
    {
        private static final OptionsTab INSTANCE =new OptionsTab();
    }
    private void propagateMenu()
    {
        WindowMenu windowMenu = WindowMenu.getInstance();
        MainWindow window = MainWindow.getInstance();
        MenuItem settings = new MenuItem(Translation.tr("settings"));
        settings.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override public void handle(ActionEvent e)
                    {
                        window.putTab(optionTab);
                    }
                });
        windowMenu.addMenuItem(Translation.tr("options"),settings);

    }
    public static OptionsTab getInstance()
    {
        return Singleton.INSTANCE;
    }
}
