public class Profit_Returns {
    private static final double totalFunds = 100000;

    public static double currentRevenue;
    public static double currentReturns;

    public static void generateReturns(double priceBought, double pricesold) {
        double numShares = (totalFunds+currentRevenue)/priceBought;
        currentRevenue += (pricesold-priceBought)*numShares;
    }

    public static double get_Returns(){
        currentReturns = (currentRevenue/totalFunds)*100;
        return currentReturns;
    }

    public static double get_currentRevenue(){
        return currentRevenue;
    }


}
