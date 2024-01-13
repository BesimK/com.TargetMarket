package utils;

import pages.HomePage;
import pages.TargetMarketHomePage;
import pages.TargetMarketLoginPage;

public class Pages {


    private HomePage homePage;
    private TargetMarketLoginPage targetMarketLoginPage;
    private TargetMarketHomePage targetMarketHomePage;

    public Pages() {
        homePage = new HomePage();
        targetMarketLoginPage = new TargetMarketLoginPage();
        targetMarketHomePage = new TargetMarketHomePage();
    }

    public HomePage getHomePage() {
        return homePage;
    }
    public TargetMarketLoginPage getTargetMarketLoginPage() {
        return targetMarketLoginPage;
    }
    public TargetMarketHomePage getTargetMarketHomePage(){
        return targetMarketHomePage;
    }


}
