package Pages;

import Utils.reports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.swing.*;

public class SearchPage extends BasePage {
    String searchYaaniTxt="Erzincan";
    String FacebookYaaniTxt="Facebook";
    String singerName="Demet Akalın";
    String DergilikYaaniTxt="Home Dergi";

    By YaaniImage=new By.ByXPath("//img[@alt='yaani']");
    By YaaniImg=new By.ByXPath("//img[@title='Yaani']");
    By searchYaani=new By.ByXPath("//div[@class='input-group border-0 bg-transparent p-0']//input[@class='form-control s-input px-5 border-0 ys-input-header-section']");
    By searchicon=new By.ByCssSelector(".s-search-icon");
    By AllTabControl=new By.ByXPath("(//div[@class='y-card ys-card'])[1]");
    By newsTab=new By.ByXPath("(//div[@class='y-palette-icon tab-item-passive tab-item-label-passive'])[1]");
    By NewsTabControl=new By.ByXPath("(//div[@class='news-card-container y-card-shadow col-lg-7 col-sm-12 mb-3 mt-3 p-3'])[1]");
    By imagesTab=new By.ByXPath("(//div[@class='y-palette-icon tab-item-passive tab-item-label-passive'])[2]");
    By ImagesTabControl=new By.ByXPath("(//div[@id='image-card-dsm'])[1]");
    By shoppingTab=new By.ByXPath("(//div[@class='y-palette-icon tab-item-passive tab-item-label-passive'])[3]");
    By ShoppingTabControl=new By.ByXPath("//img[@class='cimri-icon']");
    By videosTab=new By.ByXPath("(//div[@class='y-palette-icon tab-item-passive tab-item-label-passive'])[4]");
    By VideosTabControl=new By.ByXPath("(//div[@class='videos-card-container y-card-shadow col-lg-7 col-sm-12'])[1]");
    By mapTab=new By.ByXPath("(//div[@class='y-palette-icon tab-item-passive tab-item-label-passive'])[5]");
    By MapTabControl=new By.ByXPath("//div[@class='map ym-maps']");
    By facebookSearchPage=new By.ByXPath("//span[normalize-space()='https://www.facebook.com']");
    By facebookEmail=new By.ByXPath("//input[@id='email']");
    By facebookPass=new By.ByXPath("//input[@id='pass']");
    By facebookLoginBtn=new By.ByXPath("//div[@class='_6ltg']//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']");
    By facebookIcon=new By.ByXPath("//a[@aria-label='Facebook']//*[name()='svg']");
    By fizyLoginIcon=new By.ByXPath("//section[@class='header']//img[@alt='fizy']");
    By fizySearchPage=new By.ByXPath("//span[@class='fizy-desc-query']");
    By singPlay=new By.ByXPath("(//div[@class='cover'])[3]");
    By DergilikSearchPage=new By.ByXPath("//a[normalize-space()='Dergilik.com.tr']");
    By DergilikPageControl=new By.ByXPath("//div[@class='header']//div[@class='logo']//a");

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public boolean iconIsDisplay(){
        boolean lgnValidation = isDisplay(fizyLoginIcon);
        return lgnValidation;
    }
    public void setLoginValidation(){

        Assert.assertTrue(iconIsDisplay());
        ExtentTestManager.getTest().log(Status.PASS,"Giriş Başarılı");

    }
    public void searchPagee() {

        /////////////////////////SEARCH-TÜMÜ/////////////////////
        waitForSecond(5);
        send(searchYaani,searchYaaniTxt);

        waitForSecond(3);
        click(searchicon);
        waitForSecond(2);
        Boolean AllPageControll = isDisplay(AllTabControl);
        Assert.assertTrue(AllPageControll);
        if (AllPageControll==true) {
            ExtentTestManager.getTest().log(Status.PASS,"Search'te Tümü sayfası acildi");
        }

        /////////////////////////SEARCH-HABERLER/////////////////////
        waitForSecond(3);
        click(newsTab);
        waitForSecond(2);
        Boolean NewsPageControll = isDisplay(NewsTabControl);
        Assert.assertTrue(NewsPageControll);
        if (NewsPageControll==true) {
            ExtentTestManager.getTest().log(Status.PASS,"Search'te Haberler sayfası acildi");
        }

        /////////////////////////SEARCH-GÖRSELLER/////////////////////
        waitForSecond(3);
        click(imagesTab);
        waitForSecond(2);
        Boolean ImagesPageControll = isDisplay(ImagesTabControl);
        Assert.assertTrue(ImagesPageControll);
        if (ImagesPageControll==true) {
            ExtentTestManager.getTest().log(Status.PASS,"Search'te Görseller sayfası acildi");
        }

        /////////////////////////SEARCH-ALIŞVERİŞ/////////////////////
        waitForSecond(3);
        click(shoppingTab);
        waitForSecond(2);
        Boolean ShoppingPageControll = isDisplay(ShoppingTabControl);
        Assert.assertTrue(ShoppingPageControll);
        if (ShoppingPageControll==true) {
            ExtentTestManager.getTest().log(Status.PASS,"Search'te Görseller sayfası acildi");
        }

        /////////////////////////SEARCH-VİDEOLAR/////////////////////
        waitForSecond(3);
        click(videosTab);
        waitForSecond(2);
        Boolean VideosPageControll = isDisplay(VideosTabControl);
        Assert.assertTrue(VideosPageControll);
        if (VideosPageControll==true) {
            ExtentTestManager.getTest().log(Status.PASS,"Search'te Videolar sayfası acildi");
        }

        /////////////////////////SEARCH-HARİTALAR/////////////////////
        waitForSecond(3);
        click(mapTab);
        waitForSecond(2);
        Boolean MapPageControll = isDisplay(MapTabControl);
        Assert.assertTrue(MapPageControll);
        if (MapPageControll==true) {
            ExtentTestManager.getTest().log(Status.PASS,"Search'te Haritalar sayfası acildi");
        }

        waitForSecond(3);
        click(YaaniImage);
    }


    public void fizySearchPage() {
        waitForSecond(5);
        send(searchYaani, singerName);

        waitForSecond(3);
        click(searchicon);

        waitForSecond(5);
        scrollPageElement(drivers().findElement(fizySearchPage));
        click(fizySearchPage);

        String orginalWindow = drivers().getWindowHandle();
        drivers().switchTo().window(orginalWindow);

        for (String windowHandleTranslate : drivers().getWindowHandles()) {
            if (!orginalWindow.contentEquals(windowHandleTranslate)) {
                drivers().switchTo().window(windowHandleTranslate);
                waitForSecond(5);
                String singerNameControl = find(By.xpath("//div[@class='song']"))
                        .getText();
                Assert.assertEquals(singerNameControl,singerName);

                waitForSecond(5);
                click(singPlay);            /////şarkı oynatılır
                waitForSecond(6);
                ExtentTestManager.getTest().log(Status.PASS,"Sarki caldi");
                click(singPlay);           //////şarkı durdurulur
                ExtentTestManager.getTest().log(Status.PASS,"Sarki durdu");
                drivers().close();
                break;
            }
        }
        drivers().switchTo().window(orginalWindow);
        waitForSecond(3);
        drivers().navigate().refresh();
        click(YaaniImg);
    }



    public void facebookSearchPage(String username,String password){
        waitForSecond(5);
        send(searchYaani,FacebookYaaniTxt);

        waitForSecond(3);
        click(searchicon);

        waitForSecond(3);
        click(facebookSearchPage);
        String orginalWindow = drivers().getWindowHandle();
        drivers().switchTo().window(orginalWindow);

        for (String windowHandleTranslate : drivers().getWindowHandles()) {
            if (!orginalWindow.contentEquals(windowHandleTranslate)) {
                drivers().switchTo().window(windowHandleTranslate);
                waitForSecond(3);
                send(facebookEmail, username);
                waitForSecond(3);
                send(facebookPass,password);
                waitForSecond(3);
                click(facebookLoginBtn);
                waitForSecond(5);
                Boolean FacebookLoginControl = isDisplay(facebookIcon);
                Assert.assertTrue(FacebookLoginControl);
                ExtentTestManager.getTest().log(Status.PASS,"Facebook sayfası acildi");
                drivers().close();
                break;
            }
        }
        waitForSecond(3);
        drivers().switchTo().window(orginalWindow);

    }


   /* public void DergilikSearchPage(){
        waitForSecond(5);
        send(searchYaani,DergilikYaaniTxt);

        waitForSecond(3);
        click(searchicon);

        waitForSecond(3);
        scrollPageElement(drivers().findElement(DergilikSearchPage));
        waitForSecond(2);
        click(DergilikSearchPage);
        String orginalWindow = drivers().getWindowHandle();
        drivers().switchTo().window(orginalWindow);

        for (String windowHandleDergilik : drivers().getWindowHandles()) {
            if (!orginalWindow.contentEquals(windowHandleDergilik)) {
                drivers().switchTo().window(windowHandleDergilik);
                waitForSecond(2);
                Boolean DergilikPageControll = isDisplay(DergilikPageControl);
                Assert.assertTrue(DergilikPageControll);
                // ExtentTestManager.getTest().log(Status.PASS,"List Created");
                System.out.println("Dergilik sayfası acildi");
                waitForSecond(3);
                drivers().close();
                break;
            }
        }
        waitForSecond(3);
        drivers().switchTo().window(orginalWindow);

    }*/
}
