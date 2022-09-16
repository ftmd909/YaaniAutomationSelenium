package Pages;

import Utils.reports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HomePage extends BasePage {
    String TranslateTxt="hello";
    String GetTxt="Merhaba";
    String listName = "Youtube";
    String listUrl = "https://www.youtube.com/";
    By weathericon = new By.ById("favorites-sc-id-weather");
    By WeatherPageControl=new By.ByXPath("(//div[@class='col-lg-7 col-sm-12 order-1 order-sm-0'])[1]");
    By YaaniImage=new By.ByXPath("//img[@title='Yaani']");
    By Dovizİcon = new By.ById("favorites-sc-id-currency");
    By DovizPageControl=new By.ByXPath("//h1[contains(text(),'DÖVİZ')]");
    By pharmacyİcon = new By.ById("favorites-sc-id-pharmacy");
    By PharmacyPageControl=new By.ByXPath("(//label[@class='p-3 shadow-md inline rounded-full bg-red-600 text-white pointer-cursor inline'])[1]");
    By translateicon=new By.ById("favorites-sc-id-translate");
    By translatetxt=new By.ByXPath("//div[@class='translate-field']//textarea[@placeholder='Metin Girin']");
    By sporicon=new By.ById("favorites-sc-id-sport");
    By SporPageControl=new By.ByXPath("//img[@class='js-header-logo']");
    By favoriteadd=new By.ById("no-id");
    By favoriteName=new By.ByXPath("//input[@name='favLabel']");
    By favoriteURL =new By.ByXPath("//div[@class='home-favourite-modal-input-container form-floating']//input[@name='favUrl']");
    By favoriteAddButton=new By.ByXPath("//div[@class='col']//button[@class='home-favourite-modal-save-button float-start w-50 btn btn-none btn-lg']");
    By scrll=new By.ByXPath("//div[@class='home-sponsor-box']");
    By favorite3dot=new By.ByXPath("//div[@class='container']//div[@class='row justify-content-center']//div[@class='col-12  px-4']//div[@class='ys-bg mt-3']//div[@class='home-favourite-area d-flex justify-content-start h-auto']//div[@class='home-favourite-container']//span[@id='home-favourite-edit-Youtube']");
    By favoriteDelete= new By.ByXPath("//div[@class='container']//div[@class='row justify-content-center']//div[@class='col-12  px-4']//div[@class='ys-bg mt-3']//div[@class='home-favourite-area d-flex justify-content-start h-auto']//div[@class='home-favourite-container']//span[@data-label='Youtube'][contains(text(),'Kaldır')]");
    By newFavControl = new By.ByXPath("(//span[normalize-space()='Youtube'])[1]");
    By cookieAcceptButton=new By.ByXPath("//button[@id='cookieAcceptButton']");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    Actions a = new Actions(drivers());

    public void favorite() {
        waitForSecond(2);
        click(cookieAcceptButton);   //çerezleri kabul etti

        //////////////////////////////DÖVİZ/////////////////////////////////////////
        waitForSecond(2);
        scrollPageElement(drivers().findElement(Dovizİcon));  //döviz ikonuna tıkladı
        click(Dovizİcon);
        String orginalWindowDoviz = drivers().getWindowHandle();
        drivers().switchTo().window(orginalWindowDoviz);
        for (String windowHandleDoviz : drivers().getWindowHandles()) {
            if (!orginalWindowDoviz.contentEquals(windowHandleDoviz)) {
                drivers().switchTo().window(windowHandleDoviz);

                Boolean DovizPageControll = isDisplay(DovizPageControl);
                Assert.assertTrue(DovizPageControll);
                if(DovizPageControll==true) {
                    ExtentTestManager.getTest().log(Status.PASS,"Doviz sayfasi acildi");
                }
                waitForSecond(3);
                drivers().close();
                break;
            }
        }
        drivers().switchTo().window(orginalWindowDoviz);
        waitForSecond(3);

        /////////////////////////////ECZANE//////////////////////////////////////////
        scrollPageElement(drivers().findElement(pharmacyİcon));//eczane ikonuna tıkladı
        click(pharmacyİcon);
        String orginalWindowPharmacy = drivers().getWindowHandle();
        drivers().switchTo().window(orginalWindowPharmacy);
        for (String windowHandlePharmacy : drivers().getWindowHandles()) {
            if (!orginalWindowPharmacy.contentEquals(windowHandlePharmacy)) {
                drivers().switchTo().window(windowHandlePharmacy);

                Boolean PharmacyPageControll = isDisplay(PharmacyPageControl);
                Assert.assertTrue(PharmacyPageControll);
                if(PharmacyPageControll==true) {
                    ExtentTestManager.getTest().log(Status.PASS,"Eczane sayfasi acildi");
                }
                waitForSecond(3);
                drivers().close();
                break;
            }
        }
        drivers().switchTo().window(orginalWindowPharmacy);
        waitForSecond(3);

        ////////////////////////////////SPOR///////////////////////////////////
        scrollPageElement(drivers().findElement(sporicon));
        click(sporicon);
        String orginalWindowSpor = drivers().getWindowHandle();
        drivers().switchTo().window(orginalWindowSpor);
        for (String windowHandleSpor : drivers().getWindowHandles()) {
            if (!orginalWindowSpor.contentEquals(windowHandleSpor)) {
                drivers().switchTo().window(windowHandleSpor);

                Boolean SporPageControll = isDisplay(SporPageControl);
                Assert.assertTrue(SporPageControll);
                if(SporPageControll==true) {
                    ExtentTestManager.getTest().log(Status.PASS,"Spor sayfasi acildi");
                }
                waitForSecond(3);
                drivers().close();
                break;
            }
        }
        drivers().switchTo().window(orginalWindowSpor);
        waitForSecond(3);

        ///////////////////////////HAVA DURUMU//////////////////////////////////////
        scrollPageElement(drivers().findElement(weathericon));
        click(weathericon);
        String orginalWindowWeather = drivers().getWindowHandle();
        drivers().switchTo().window(orginalWindowWeather);
        for (String windowHandleWeather : drivers().getWindowHandles()) {
            if (!orginalWindowWeather.contentEquals(windowHandleWeather)) {
                drivers().switchTo().window(windowHandleWeather);

                Boolean WeatherPageControll = isDisplay(WeatherPageControl);
                Assert.assertTrue(WeatherPageControll);
                if(WeatherPageControll==true) {
                    ExtentTestManager.getTest().log(Status.PASS,"Hava Durumu sayfasi acildi");
                }
                waitForSecond(3);
                drivers().close();
                break;
            }
        }
        drivers().switchTo().window(orginalWindowSpor);
        waitForSecond(3);

        ////////////////////////////ÇEVİRİ///////////////////////////////////////
        scrollPageElement(drivers().findElement(translateicon));
        click(translateicon);
        String orginalWindowtranslate = drivers().getWindowHandle();
        drivers().switchTo().window(orginalWindowtranslate);

        for (String windowHandleTranslate : drivers().getWindowHandles()) {
            if (!orginalWindowtranslate.contentEquals(windowHandleTranslate)) {
                drivers().switchTo().window(windowHandleTranslate);

                waitForSecond(3);
                scrollPageElement(drivers().findElement(translatetxt));
                send(translatetxt, TranslateTxt);

                Boolean translateControl = isDisplay(translatetxt); //çeviri alanına kelime yazıp yazılmadığını kontrol ettim
                Assert.assertTrue(translateControl);
                waitForSecond(5);

                String TranslateTxtControl = find(By.xpath("//textarea[@class='textarea-translated']"))
                        .getText();
                Assert.assertEquals(TranslateTxtControl,GetTxt); //çevirisi yapılması istenen kelime doğru çevrildi mi? kontrolü
                waitForSecond(2);
                //çeviri doğru yapıldıysa SOUT yazılır
                ExtentTestManager.getTest().log(Status.PASS,"Ceviri sayfasi acildi ve Ceviri yapildi");

                waitForSecond(5);
                drivers().close();
                break;
            }
        }
        drivers().switchTo().window(orginalWindowtranslate);
        waitForSecond(3);



    }
    ///////////////////////////////FAVORİ EKLEME////////////////////////////////
    public void setCreateNewFavoriteControl(){
        waitForSecond(2);
        //  click(cookieAcceptButton);   //çerezleri kabul ettim

        scrollPageElement(drivers().findElement(scrll));
        waitForSecond(2);

        click(favoriteadd);
        waitForSecond(2);

        send(favoriteName,listName);
        waitForSecond(1);

        send(favoriteURL,listUrl );
        waitForSecond(1);

        click(favoriteAddButton);
        waitForSecond(2);
        drivers().navigate().refresh();

        Boolean AddlistControl = isDisplay(newFavControl);
        Assert.assertTrue(AddlistControl);
        if(AddlistControl==true) {
            ExtentTestManager.getTest().log(Status.PASS,"Favori eklendi");
        }

    }

    /////////////////////////////EKLENEN FAVORİYİ SİLME//////////////////////////
    public void setDeleteFavoriteControl(){
        Actions a = new Actions(drivers());
        waitForSecond(3);
        WebElement dotLocator = drivers().findElement(favorite3dot);
        a.moveToElement(dotLocator).click().perform();
        waitForSecond(2);   //3 noktaya tıkladım

        WebElement deleteLocator = drivers().findElement(favoriteDelete);
        a.moveToElement(deleteLocator).click(deleteLocator).perform();
        waitForSecond(2);   // açılan menüde kaldıra tıkladım

        System.out.println("Favori silindi");


        //eklediğim favorinin silinip silinmediğini kontrol ettim. Silinmediyse Favorinin silinmediğine dair mesaj basacak
        Boolean deletedFavControl = getElementLocatedControl(By.xpath("(//span[normalize-space()='Youtube'])[1]"));
        if (deletedFavControl==true){
            ExtentTestManager.getTest().log(Status.PASS,"Favori silinemedi");
        }
    }
}
