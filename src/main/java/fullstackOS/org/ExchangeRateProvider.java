package fullstackOS.org;

public class ExchangeRateProvider {
    public static double getRate(String fromCurrency, String toCurrency) {
        switch (fromCurrency + "-" + toCurrency) {
            case "SEK-USD":
                return 0.11;
            case "USD-SEK":
                return 9.20;
            case "SEK-EUR":
                return 0.094;
            case "EUR-SEK":
                return 10.63;

            default:
                throw new IllegalArgumentException("Invalid currency conversion requested.");
        }
    }
}
