public class Converter {
    public double getConversionRate(String from, String to) {
        if (from.equals(to)) return 1.0;

        // Define rates relative to IDR
        double idrToUsd = 1 / 15946.95;
        double idrToEur = 1 / (15946.95 / 0.95);
        double idrToJpy = 1 / (15946.95 / 152.53);
        double idrToGbp = 1 / (15946.95 / 0.78);

        // Convert to IDR
        double usdToIdr = 15946.95;
        double eurToIdr = 15946.95 / 0.95;
        double jpyToIdr = 15946.95 / 152.53;
        double gbpToIdr = 15946.95 / 0.78;

        if (from.equals("IDR")) {
            switch (to) {
                case "USD": return idrToUsd;
                case "EUR": return idrToEur;
                case "JPY": return idrToJpy;
                case "GBP": return idrToGbp;
            }
        } else if (to.equals("IDR")) {
            switch (from) {
                case "USD": return usdToIdr;
                case "EUR": return eurToIdr;
                case "JPY": return jpyToIdr;
                case "GBP": return gbpToIdr;
            }
        } else {
            double rateFromToIdr = getConversionRate(from, "IDR");
            double rateIdrToTo = getConversionRate("IDR", to);
            return rateFromToIdr * rateIdrToTo;
        }

        return 1.0;
    }

    public double convert(double amount, String from, String to) {
        return amount * getConversionRate(from, to);
    }
}
