package com.fortegrp.at.ui.content

/**
 * Created by Admin on 9/18/2017.
 */
class LoginPage extends BaseControlCenterPage{

    static at = {
        waitFor {
            emailInput.displayed
            passwordInput.displayed
            js.('document.readyState') == 'complete'
        }
    }

    static content = {
        emailInput(wait: true) { $("input[name='email']") }
        passwordInput(wait: true) { $("input[name='password']") }
        loginButton(wait: true) { $("button", text:'Login') }
    }

    def loginAs(String email, String password) {
        emailInput.value(email)
        passwordInput.value(password)
        loginButton.click()
    }
}
