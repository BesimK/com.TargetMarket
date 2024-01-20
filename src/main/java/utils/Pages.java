package utils;

import pages.*;

public class Pages {

    private HomePage homePage;

    private LaptopsPage laptopsPage;

    private SmartphonesPage smartphonesPage;

    private TargetMarketLoginPage targetMarketLoginPage;

    private TargetMarketHomePage targetMarketHomePage;

    private WomenDressesPage womenDressesPage;

    private CheckoutPage checkoutPage;

    private TopsPage topsPage;

    private FurniturePage furniturePage;

    private WomenShoesPage womenShoesPage;

    private TopsCheckOutPage topsCheckOutPage;

    private GroceriesPage groceriesPage;

    private SkincarePage skincarePage;


    public Pages() {
        homePage = new HomePage();
        targetMarketLoginPage = new TargetMarketLoginPage();
        targetMarketHomePage = new TargetMarketHomePage();
        womenDressesPage = new WomenDressesPage();
        checkoutPage = new CheckoutPage();
        topsPage = new TopsPage();
        smartphonesPage = new SmartphonesPage();
        furniturePage = new FurniturePage();
        womenShoesPage = new WomenShoesPage();
        topsCheckOutPage = new TopsCheckOutPage();
        groceriesPage = new GroceriesPage();
        skincarePage = new SkincarePage();
        laptopsPage = new LaptopsPage();

    }

    public WomenShoesPage getWomenShoesPage() {
        return womenShoesPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public TargetMarketLoginPage getTargetMarketLoginPage() {
        return targetMarketLoginPage;
    }

    public TargetMarketHomePage getTargetMarketHomePage() {
        return targetMarketHomePage;
    }

    public WomenDressesPage getWomenDressesPage() {
        return womenDressesPage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }

    public TopsPage getTopsPage() {
        return topsPage;
    }

    public SmartphonesPage getSmartphonesPage() {
        return smartphonesPage;
    }

    public FurniturePage getFurniturePage() {
        return furniturePage;
    }

    public TopsCheckOutPage getTopsCheckOutPage() {
        return topsCheckOutPage;
    }

    public GroceriesPage getGroceriesPage() {
        return groceriesPage;
    }

    public SkincarePage getSkincarePage() {
        return skincarePage;
    }

    public LaptopsPage getLaptopsPage() {
        return laptopsPage;
    }

}