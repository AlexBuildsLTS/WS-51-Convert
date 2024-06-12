package fullstackOS.org;

public class CurrencyConverter {
    public static double convert(String fromCurrency, String toCurrency, double amount) {
        double rate = ExchangeRateProvider.getRate(fromCurrency, toCurrency);
        return amount * rate;
    }
}
