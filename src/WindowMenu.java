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
	public void addMenuItem(String menu, MenuItem menuItem)
	{
		if(menuNames.stream().anyMatch(string -> string.equals(menu)))
		{
			Menu editMenu = mainMenu.getMenus().get(menuNames.indexOf(menu));
            editMenu.getItems().add(menuItem);
		}
		else
		{
            Menu newMenu = new Menu(menu);
            newMenu.getItems().add(menuItem);
			mainMenu.getMenus().add(newMenu);
			menuNames.add(menu);
		}
	}
}
