import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import java.util.List;
import java.util.ArrayList;

class WindowMenu
{
	private MenuBar mainMenu = null;
	private List<String> menuNames = null;
	private WindowMenu()
	{
		mainMenu = new MenuBar();
		menuNames = new ArrayList<String>();
	}
	private static class Singleton
	{
		private static final WindowMenu INSTANCE = new WindowMenu();
	}
	public static WindowMenu getInstance()
	{
		return Singleton.INSTANCE;
	}
	public MenuBar getMenuBar()
	{
		return mainMenu;
	}
	public void addMenu(Menu menu)
	{
		if(menuNames.stream().anyMatch(string -> string.equals(menu.getText())))
		{
			Menu editMenu = mainMenu.getMenus().get(menuNames.indexOf(menu.getText()));
			for(MenuItem menuItem: menu.getItems())
			{
				editMenu.getItems().add(menuItem);
			}
		}
		else
		{
			mainMenu.getMenus().add(menu);
			menuNames.add(menu.getText());
		}
	}
}
