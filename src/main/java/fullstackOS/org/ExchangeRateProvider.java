package fullstackOS.org

public class ExchangeRateProvider {
    public static final double SEK_TO_USD = 0.11;
    public static final double SEK_TO_EUR = 0.093;
    public static final double USD_TO_SEK = 9.07;
    public static final double EUR_TO_SEK = 10.70;


    public static double getRate(String fromCurrency, String toCurrency) {
        switch (fromCurrency + " to " + toCurrency) {
            case "SEK to USD":
                return SEK_TO_USD;
            case "USD to SEK":
                return USD_TO_SEK   ;
            case "SEK to EUR":
                return SEK_TO_EUR;
            case "EUR to SEK":
                return EUR_TO_SEK;
            default:
                throw new IllegalArgumentException("Invalid currency conversion requested.");
        }
    }
}