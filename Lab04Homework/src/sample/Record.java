package sample;

public class Record {

    private String month;
    private Double profit;

    Record(String month, Double profit){
        this.month = month;
        this.profit = profit;
    }

    public String getMonth() {
        return month;
    }
    public Number getProfit(){
        return profit;
    }
}
