package Pages;

import Utils.reports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MenuPage extends BasePage{
    By YaaniImageMenu=new By.ByXPath("//img[@title='Yaani']");
    By MenuIcon= new By.ByXPath("//img[@class='home-header-dropdown-icon']");
    By Settings=new By.ByXPath("(//div[@class='home-menu-icons'])[1]");
    By SettingsControl=new By.ByXPath("//div[@class='docs-tab-icon-img-container']");
    By Policies =new By.ByXPath("(//div[@class='home-menu-icons'])[2]");
    By PoliciesControl=new By.ByXPath("//span[@class='docs-tab-icon-text']");
    By Help=new By.ByXPath("(//div[@class='home-menu-icons'])[3]");
    By HelpControl=new By.ByXPath("//span[@class='docs-tab-icon-text']");
    By AboutUs=new By.ByXPath("(//div[@class='home-menu-icons'])[4]");
    By AboutUsControl=new By.ByXPath("//div[@class='about-mobile-store']");



    public MenuPage(WebDriver driver) {
        super(driver);
    }
    public void SettingsFunction() {
        /////////////MENU-AYARLAR////////////////////
        waitForSecond(2);
        click(MenuIcon);

        waitForSecond(2);
        click(Settings);
        waitForSecond(2);
        Boolean SettingsPageControll = isDisplay(SettingsControl);
        Assert.assertTrue(SettingsPageControll);
        if (SettingsPageControll==true) {
            ExtentTestManager.getTest().log(Status.PASS,"Ayarlar sayfası acildi");
        }
        waitForSecond(3);
        click(YaaniImageMenu);

    }

    public void PoliciesFunction() {
        /////////////MENU-YASAL SÖZLEŞMELER////////////////////
        waitForSecond(2);
        click(MenuIcon);

        waitForSecond(2);
        click(Policies);
        waitForSecond(2);
        Boolean PoliciesPageControll = isDisplay(PoliciesControl);
        Assert.assertTrue(PoliciesPageControll);
        if (PoliciesPageControll==true) {
            ExtentTestManager.getTest().log(Status.PASS,"Yasal Sözleşmeler sayfası acildi");
        }
        waitForSecond(3);
        click(YaaniImageMenu);

    }

    public void HelpFunction() {
        /////////////MENU-YARDIM////////////////////
        waitForSecond(2);
        click(MenuIcon);

        waitForSecond(2);
        click(Help);
        waitForSecond(2);
        Boolean HelpPageControll = isDisplay(HelpControl);
        Assert.assertTrue(HelpPageControll);
        if (HelpPageControll==true) {
            ExtentTestManager.getTest().log(Status.PASS,"Yardım sayfası acildi");
        }
        waitForSecond(3);
        click(YaaniImageMenu);

    }

    public void AboutUsFunction() {
        /////////////MENU-HAKKIMIZDA////////////////////
        waitForSecond(2);
        click(MenuIcon);

        waitForSecond(2);
        click(AboutUs);
        waitForSecond(2);
        Boolean AboutUsPageControll = isDisplay(AboutUsControl);
        Assert.assertTrue(AboutUsPageControll);
        if (AboutUsPageControll==true) {
            ExtentTestManager.getTest().log(Status.PASS,"Hakkımızda sayfası acildi");
        }
        waitForSecond(3);
        click(YaaniImageMenu);
    }

}
