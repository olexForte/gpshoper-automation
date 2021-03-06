import com.fortegrp.at.ui.env.Driver
import geb.Browser
import geb.navigator.EmptyNavigator
import org.openqa.selenium.WebElement

envs {
    qa_env {
        baseUrl = "https://controlcenter.gpshopper.com"
    }
}

waiting {
    timeout = 30
    retryInterval = 1
    slow { timeout = 50 }
}

// Settings
cacheDriver = true
cacheDriverPerThread = true
quitCachedDriverOnShutdown = true
autoClearCookies = true
atCheckWaiting = true
//unexpectedPages = [ServerUnavailablePage]

// get/set baseUrl from environments closure. Here testEnv is externally-passed parameter (for environment type)
baseUrl = this."envs"."${System.properties['testEnv']}".baseUrl

driver = { Driver.getInstance() }


if (!System.properties['geb.build.reportsDir'])
    reportsDir = "reports"
