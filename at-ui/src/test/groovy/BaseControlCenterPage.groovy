import com.fortegrp.at.ui.content.BasePage
import org.openqa.selenium.By

/**
 * Created by Admin on 9/18/2017.
 */
class BaseControlCenterPage extends BasePage{
    static content = {
        userDropDown{$(By.xpath("//div[contains(@class, 'header')]//a[@class='dropdown-toggle']"))}
        logoutOption{$(By.xpath("//div[contains(@class, 'header')]//a[text()='Logout']"))}
        navigationSideBar{$(By.xpath($x("//ul[@class = 'nav nav-sidebar']")))}
        sideBarSection{sectionName -> navigationSideBar.$(By.xpath(".//a[text() = '"+ sectionName +"']"))}
        sideBarItem{itemName -> navigationSideBar.$(By.xpath(".//span[text() = '"+ itemName +"']"))}
    }
}
