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



	public Pages() {
		homePage = new HomePage();
		targetMarketLoginPage = new TargetMarketLoginPage();
		targetMarketHomePage = new TargetMarketHomePage();
		womenDressesPage = new WomenDressesPage();
		checkoutPage = new CheckoutPage();
		topsPage = new TopsPage();
		smartphonesPage = new SmartphonesPage();
		furniturePage = new FurniturePage();
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

	public FurniturePage getFurniturePage(){return  furniturePage;}
}