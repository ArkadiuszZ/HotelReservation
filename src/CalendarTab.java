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

public class CalendarTab {
    private Tab calendarTab = null;

    private CalendarTab()
    {
        calendarTab = new Tab();
        calendarTab.setText(Translation.tr("calendar"));
        propagateMenu();


    }
    private static class Singleton
    {
        private static final CalendarTab INSTANCE =new CalendarTab();
    }
    private void propagateMenu()
    {
        WindowMenu windowMenu = WindowMenu.getInstance();
        MainWindow window = MainWindow.getInstance();
        MenuItem settings = new MenuItem(Translation.tr("calendar"));
        settings.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override public void handle(ActionEvent e)
                    {
                        window.putTab(calendarTab);
                    }
                });
        windowMenu.addMenuItem(Translation.tr("file"), settings);

    }
    public static CalendarTab getInstance()
    {
        return Singleton.INSTANCE;
    }
}
