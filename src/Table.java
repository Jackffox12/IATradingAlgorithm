public class Table {
    private String currentDecsion,percentGain, currentPrice, stockPercentGain;

    public Table(String currentPrice, String currentDecsion, String percentGain, String stockPercentGain){
        this.currentDecsion = currentDecsion;
        this.percentGain = percentGain;
        this.currentPrice = currentPrice;
        this.stockPercentGain = stockPercentGain;
    }
    public String getCurrentDecsion() {
        return currentDecsion;
    }

    public String getStockPercentGain() {
        return stockPercentGain;
    }

    public String getPercentGain() {
        return percentGain;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }
}
