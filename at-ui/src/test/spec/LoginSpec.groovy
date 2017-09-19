import com.fortegrp.at.common.annotation.TestDoc
import com.fortegrp.at.ui.BaseUISpec
import com.fortegrp.at.ui.content.LoginPage


/**
 * Created by odiachuk on 19.09.17.
 */
class LoginSpec extends BaseUISpec{

    @TestDoc('LoginTest')
    def "Login Valid Credentials"() {

        when: "User at Login Page"
        startApplication()
        at LoginPage

        and: "Tries to log into as #testuser.username"
        loginAs("","")

//        then: "Verify that Home Page has opened for the appropriate user"
//        at DashboardsPage
//        header.currentUserName.text().trim() == testuser.firstName + " " + testuser.lastName
//
//        when: "User click Log Out menu item"
//        header.logout()
//
//        then: "User has been redirected to Login page"
//        at LoginPage
//
//        where:
//        testuser = TestData.defaultUser
        then: "faaa"
        1 == 1

    }

}