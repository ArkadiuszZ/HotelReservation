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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.HPos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import java.util.Locale;

public class OptionsTab {
    private Tab optionTab = null;
    private MenuItem settingsMenuItem = null;
    private TextField dbHostT = new TextField();
    private TextField dbNameT = new TextField();
    private TextField dbUserT = new TextField();
    private TextField dbPassT = new TextField();
    private ComboBox<String> langC = new ComboBox<String>();

    private OptionsTab()
    {
        constructTab();
        propagateMenu();


    }
    private static class Singleton
    {
        private static final OptionsTab INSTANCE =new OptionsTab();
    }
    private void propagateMenu()
    {
        WindowMenu windowMenu = WindowMenu.getInstance();
        settingsMenuItem = new MenuItem(Translation.tr("settings"));
        settingsMenuItem.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override public void handle(ActionEvent e)
                    {
                        MainWindow window = MainWindow.getInstance();
                        window.putTab(optionTab);
                    }
                });
        windowMenu.addMenuItem(Translation.tr("options"),settingsMenuItem);

    }
    private void setDefaultTextFieldValues()
    {
        Settings settings = Settings.getInstance();
        dbHostT.setText(settings.getDBHost());
        dbNameT.setText(settings.getDBName());
        dbUserT.setText(settings.getDBUser());
        dbPassT.setText(settings.getDBPassword());
        langC.getItems().clear();
        for(Locale locale: Translation.LOCALES)
        {
        langC.getItems().add(locale.getDisplayLanguage());
        if(locale.getDisplayLanguage().equals(Translation.currentLocaleDisplayLanguage()))
                {
                    langC.getSelectionModel().select(locale.getDisplayLanguage());
                }
        }

    }
    
    private void saveOptions()
    {
        Settings settings = Settings.getInstance();
        settings.setDBHost(dbHostT.getText());
        settings.setDBName(dbNameT.getText());
        settings.setDBUser(dbUserT.getText());
        settings.setDBPassword(dbPassT.getText());
        DBConnection connection = DBConnection.getInstance();
        connection.setConnection();
        if(connection.isConnected() == false)
        {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle(Translation.tr("dbconnection-error"));
            a.setHeaderText(Translation.tr("dbconnection-error"));
            a.setContentText(Translation.tr("dbconnection-error-text"));
            DialogPane dialogPane = a.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("resources/dialogs_error.css").toExternalForm());
            a.show();
            return;
        }
        for(Locale locale: Translation.LOCALES)
        {
            if(langC.getValue().equals(locale.getDisplayLanguage()))
                    {
                        settings.setLocaleCountry(locale.getCountry());
                        settings.setLocaleLang(locale.getLanguage());
                    }
        }
        settings.save();
        Alert i = new Alert(AlertType.INFORMATION);
        i.setTitle(Translation.tr("saved-correctly"));
        i.setHeaderText(Translation.tr("saved-correctly"));
        i.setContentText(Translation.tr("few-changes-require-restart"));
        DialogPane dialogPane = i.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("resources/dialogs.css").toExternalForm());
        i.show();
        optionTab.getTabPane().getTabs().remove(optionTab);
    }

    private void constructTab()
    {
        optionTab = new Tab();
        optionTab.setText(Translation.tr("settings"));
        Label dbL =  new Label(Translation.tr("database-settings"));
        GridPane.setHalignment(dbL, HPos.CENTER);
        dbL.setStyle("-fx-font: 16px bold");
        Label dbHostL = new Label(Translation.tr("database-host"));
        GridPane.setHalignment(dbHostL, HPos.RIGHT);
        Label dbNameL = new Label(Translation.tr("database-name"));
        GridPane.setHalignment(dbNameL, HPos.RIGHT);
        Label dbUserL = new Label(Translation.tr("database-user"));
        GridPane.setHalignment(dbUserL, HPos.RIGHT);
        Label dbPassL = new Label(Translation.tr("database-password"));
        GridPane.setHalignment(dbPassL, HPos.RIGHT);
        Label localeL = new Label(Translation.tr("locale-settings"));
        localeL.setStyle("-fx-font: 16px bold");
        GridPane.setHalignment(localeL, HPos.CENTER);
        Label localeLangL = new Label(Translation.tr("language"));
        GridPane.setHalignment(localeLangL, HPos.RIGHT);
        dbHostT.setPrefWidth(200);
        dbNameT.setPrefWidth(200);
        dbUserT.setPrefWidth(200);
        dbPassT.setPrefWidth(200);
        langC.setPrefWidth(200);
        setDefaultTextFieldValues();
        Button saveButton = new Button(Translation.tr("save"));
        GridPane.setHalignment(saveButton, HPos.RIGHT);
        saveButton.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override public void handle(ActionEvent ae)
                    {
                        saveOptions();
                    }
                });
        Button cancelButton = new Button(Translation.tr("cancel"));
        cancelButton.setOnAction(new EventHandler<ActionEvent>() 
                {
                    @Override public void handle(ActionEvent ae) 
                    {
                        setDefaultTextFieldValues();
                        optionTab.getTabPane().getTabs().remove(optionTab);
                    }
                });
        GridPane view = new GridPane();
        view.setHgap(10);
        view.setVgap(10);
        view.add(dbL, 0, 0, 2, 1);
        view.add(dbHostL, 0, 1, 1, 1);
        view.add(dbHostT, 1, 1, 1, 1); 
        view.add(dbNameL, 0, 2, 1, 1);
        view.add(dbNameT, 1, 2, 1, 1);
        view.add(dbUserL, 0, 3, 1, 1);
        view.add(dbUserT, 1, 3, 1, 1);
        view.add(dbPassL, 0, 4, 1, 1);
        view.add(dbPassT, 1, 4, 1, 1);
        view.add(localeL, 0, 5, 2, 1);
        view.add(localeLangL, 0, 6, 1, 1);
        view.add(langC, 1, 6, 1, 1);
        view.add(saveButton, 0, 8, 1, 1);
        view.add(cancelButton, 1, 8, 1, 1);
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(view);
        scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        optionTab.setContent(scroll);

    }
    public static OptionsTab getInstance()
    {
        return Singleton.INSTANCE;
    }
}
