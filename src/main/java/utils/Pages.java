package utils;

import pages.*;

public class Pages {

	private HomePage homePage;

	private TargetMarketLoginPage targetMarketLoginPage;

	private TargetMarketHomePage targetMarketHomePage;
	private WomenDressesPage womenDressesPage;
	private CheckoutPage checkoutPage;

	public Pages() {
		homePage = new HomePage();
		targetMarketLoginPage = new TargetMarketLoginPage();
		targetMarketHomePage = new TargetMarketHomePage();
		womenDressesPage = new WomenDressesPage();
		checkoutPage = new CheckoutPage();
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
}
