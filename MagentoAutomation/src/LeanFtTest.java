

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.*;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.verifications.*;

import unittesting.*;

public class LeanFtTest extends UnitTestClassBase {

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException {
    
    Browser browser=BrowserFactory.launch(BrowserType.CHROME);
    browser.navigate("https://www.magento.com");
    
    Link myacct = browser.describe(Link.class, new LinkDescription.Builder()
			.role("").accessibilityName("").tagName("A").innerText("My Account").index(1).build());
    myacct.click();
    
    
    EditField name = browser.describe(EditField.class, new EditFieldDescription.Builder()
			.type("text").tagName("INPUT").name("login[username]").build());
    name.setValue("nikhildandge.abc@gmail.com");
    
    EditField pw = browser.describe(EditField.class, new EditFieldDescription.Builder()
			.type("password").tagName("INPUT").name("login[password]").build());
    pw.setSecure("5c46ef47f44d2a14123aa08c73963ebe36f4913cdcab4ecaa28f");
    
    Button login = browser.describe(Button.class, new ButtonDescription.Builder()
			.buttonType("submit").tagName("BUTTON").name("Login").build());
   
    login.click();
    
    /*WebElement logout = browser.describe(WebElement.class, new WebElementDescription.Builder()
			.tagName("SPAN").innerText("Billing History").build());*/
   
    
   /* WebElement logout=browser.describe(Link.class, new LinkDescription.Builder()
			.tagName("A").innerText("Billing History").build());*/
    browser.close();
    
    }
}