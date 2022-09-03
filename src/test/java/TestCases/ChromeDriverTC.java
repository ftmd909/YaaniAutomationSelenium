package TestCases;

import Drivers.ChromeDrivers;
import Pages.HomePage;
import Pages.MenuPage;
import Pages.SearchPage;
import org.testng.annotations.Test;

public class ChromeDriverTC extends ChromeDrivers {
    String userName = "piaerzincan@gmail.com";
    String pass = "24Erzincanpia24";


    @Test
    public void YaaniTest() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchpagee= new SearchPage(driver);
        MenuPage menupagee= new MenuPage(driver);


        homePage.favorite();
        homePage.setCreateNewFavoriteControl();
        homePage.setDeleteFavoriteControl();
        menupagee.SettingsFunction();
        menupagee.PoliciesFunction();
        menupagee.HelpFunction();
        menupagee.AboutUsFunction();
        searchpagee.searchPagee();

        searchpagee.fizySearchPage();
        searchpagee.facebookSearchPage(userName,pass);

    }

}
