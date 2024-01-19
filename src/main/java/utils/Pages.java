package utils;

import pages.*;

public class Pages {

	private HomePage homePage;

	private SmartphonesPage smartphonesPage;

	private TargetMarketLoginPage targetMarketLoginPage;

	private TargetMarketHomePage targetMarketHomePage;
	private WomenDressesPage womenDressesPage;
	private CheckoutPage checkoutPage;
	private TopsPage topsPage;

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
		skincarePage = new SkincarePage();
		groceriesPage = new GroceriesPage();

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
	public CheckoutPage getCheckoutPage(){
		return checkoutPage;
	}
	public TopsPage getTopsPage(){
		return topsPage;
	}
	public SmartphonesPage getSmartphonesPage(){
		return smartphonesPage;
	}

	public SkincarePage getSkincarePage() {
		return skincarePage;
	}

	public GroceriesPage getGroceriesPage() {
		return groceriesPage;
	}
}