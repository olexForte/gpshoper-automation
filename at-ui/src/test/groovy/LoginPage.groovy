/**
 * Created by Admin on 9/18/2017.
 */
class LoginPage extends BaseControlCenterPage{
    static at = {
        emailInput.displayed
        passwordInput.displayed
        js.('document.readyState') == 'complete'}
    static content = {
        emailInput(wait: true) { $("input[name='email']") }
        passwordInput(wait: true) { $("input[name='password']") }
        loginButton(wait: true) { $("button.btn-lg") }
    }

    def loginAs(String email, String password) {
        emailInput.value(email)
        passwordInput.value(password)
        loginButton.click()
    }
}
