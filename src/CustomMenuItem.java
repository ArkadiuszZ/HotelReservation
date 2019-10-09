import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;

public class CustomMenuItem extends MenuItem
{
    public void setParent(Menu menu)
    {
        this.setParentMenu(menu);
    } 
}
