package fullstackOS.org;

public class CurrencyConverter {

    public static double convert(String fromCurrency, String toCurrency, double amount) {
        double rate = getRate(fromCurrency, toCurrency);
        return amount * rate;
    }

    private static double getRate(String fromCurrency, String toCurrency) {
        switch (fromCurrency + "-" + toCurrency) {
            case "SEK-USD":
                return ExchangeRatesProvider.SEK_TO_USD_RATE;
            case "USD-SEK":
                return ExchangeRatesProvider.USD_TO_SEK_RATE;
            case "SEK-EUR":
                return ExchangeRatesProvider.SEK_TO_EUR_RATE;
            case "EUR-SEK":
                return ExchangeRatesProvider.EUR_TO_SEK_RATE;
            default:
                throw new IllegalArgumentException("Invalid currency conversion requested.");
        }
    }
}
