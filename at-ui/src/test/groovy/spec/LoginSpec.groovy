package spec

import com.fortegrp.at.common.annotation.TestDoc
import com.fortegrp.at.ui.BaseUISpec
import com.fortegrp.at.ui.content.BaseControlCenterPage
import com.fortegrp.at.ui.content.LoginPage
import geb.Browser
import org.openqa.selenium.By


/**
 * Created by odiachuk on 19.09.17.
 */
class LoginSpec extends BaseUISpec{

    @TestDoc('LoginTest')
    def "Login Valid Credentials"() {

        when: "User at Login Page"
        at LoginPage

        and: "Tries to log into as #testuser.username"
        loginAs(System.getProperty('username'), System.getProperty('password'))

        then: "Verify that user is on Dashboard page"
        waitFor {$(By.xpath("//h1[contains(text(), 'DASHBOARD')]")).displayed}
    }

}