import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class tradeBot {
    double inital_Price_Change_Sell; double percent_Change_Sell; double inital_Price_Change_Buy; double percent_Change_Buy;
    String date; String time; double current_Price; double volume;


    //Set Profit Threshold
    double profit_Threshold = SaveData.get_profitThreshold();

    //Set Stop Loss Threshold
    double stop_Loss_Threshold = SaveData.get_stopThreshold();

    //Set Dip Threshold
    double Dip_Threshold = SaveData.get_DipThreshold();

    //Set Upward Trend Threshold
    double Upward_Trend_Threshold = SaveData.get_UpwardThreshold();


    public tradeBot(String[] currentLine) {
        date = currentLine[0];
        time = currentLine[1];
        current_Price = Double.parseDouble(currentLine[2]);
        volume = Double.parseDouble(currentLine[6]);
    }

    public void buyDecisionMaking(){
        if(SaveData.get_last_Price() == 0){
            System.out.println("No prior price");
            SaveData.set_last_Price(current_Price);
            SaveData.set_hasPostion(false);
            SaveData.set_firstPrice(current_Price);
            Table u1 = new Table("$" + String.valueOf(current_Price), "No Prior Price Indication", String.valueOf(Profit_Returns.get_Returns())+ "%", String.valueOf(((current_Price - SaveData.get_firstPrice())/SaveData.get_firstPrice())*100) + "%");
            SaveData.set_tableData(u1);
        }
        else {
            inital_Price_Change_Buy = current_Price - (SaveData.get_last_Price());
            percent_Change_Buy += (((inital_Price_Change_Buy / (SaveData.get_last_Price())) * 100));

            //Buy after percent hits Dip Threshold
            if (((percent_Change_Buy) <= Dip_Threshold)) {
                SaveData.set_last_Price(current_Price);

                SaveData.set_Mode("SELL");
                SaveData.set_hasPostion(true);

                String statement = ("Dip Threshold: Buy After " + SaveData.get_DipThreshold() +"% Decrease");
                Table u1 = new Table("$" + String.valueOf(current_Price), statement, String.valueOf(Profit_Returns.get_Returns()) + "%", String.valueOf(((current_Price - SaveData.get_firstPrice())/SaveData.get_firstPrice())*100) + "%");
                SaveData.set_tableData(u1);

                System.out.print("Buy After " + SaveData.get_DipThreshold() +"% Decrease");
            }

            //Buy after percent hits Upward Trend Threshold
            if (((percent_Change_Buy) >= Upward_Trend_Threshold)) {
                SaveData.set_last_Price(current_Price);

                SaveData.set_Mode("SELL");
                SaveData.set_hasPostion(true);


                String statement = ("Upward Trend Threshold: Buy After " + SaveData.get_UpwardThreshold() +"% Increase");
                Table u1 = new Table("$" + String.valueOf(current_Price), statement, String.valueOf(Profit_Returns.get_Returns())+ "%",String.valueOf(((current_Price - SaveData.get_firstPrice())/SaveData.get_firstPrice())*100)+ "%");
                SaveData.set_tableData(u1);

                System.out.print("Buy After " + SaveData.get_UpwardThreshold() +"% Increase");
            }

            System.out.println(" " + percent_Change_Buy);
            if(SaveData.get_Mode()!="SELL"){
                SaveData.set_Mode("HOLD");
                Table u1 = new Table("$" + String.valueOf(current_Price), "Looking to Buy", String.valueOf(Profit_Returns.get_Returns())+ "%", String.valueOf(((current_Price - SaveData.get_firstPrice())/SaveData.get_firstPrice())*100)+ "%");
                SaveData.set_tableData(u1);
            }
        }


    }

    public void sellDecisionMaking(){
        inital_Price_Change_Sell = current_Price - (SaveData.get_last_Price());
        percent_Change_Sell += (((inital_Price_Change_Sell / (SaveData.get_last_Price()) * 100)));

        //Sell after percent hits Profit Threshold
        if (((percent_Change_Sell) >= profit_Threshold) && SaveData.get_hasPostion()==true){
            Profit_Returns.generateReturns(SaveData.get_last_Price(), current_Price);

            SaveData.set_last_Price(current_Price);
            SaveData.set_Mode("BUY");
            SaveData.set_hasPostion(false);

            String statement = "Profit Threshold: Sell After A " +SaveData.get_profitThreshold() +"% Gain";
            Table u1 = new Table("$"+String.valueOf(current_Price), statement, String.valueOf(Profit_Returns.get_Returns()) + "%", String.valueOf(((current_Price - SaveData.get_firstPrice())/SaveData.get_firstPrice())*100)+ "%");
            SaveData.set_tableData(u1);

            System.out.print("Sell After A " +SaveData.get_profitThreshold()+"% Gain");
        }

        //Sell after percent hits Stop Loss Threshold
        if (((percent_Change_Sell) <= stop_Loss_Threshold) && SaveData.get_hasPostion()==true){
            Profit_Returns.generateReturns(SaveData.get_last_Price(), current_Price);

            SaveData.set_last_Price(current_Price);
            SaveData.set_Mode("BUY");
            SaveData.set_hasPostion(false);

            String statement = "Stop Loss Threshold: Sell After " + SaveData.get_stopThreshold() +"% Loss";
            Table u1 = new Table("$"+String.valueOf(current_Price), statement, String.valueOf(Profit_Returns.get_Returns())+"%", String.valueOf(((current_Price - SaveData.get_firstPrice())/SaveData.get_firstPrice())*100)+"%");
            SaveData.set_tableData(u1);

            System.out.print("sell after " + SaveData.get_stopThreshold() +"% loss");
        }

        System.out.println(percent_Change_Sell);
        if(SaveData.get_Mode()!="BUY"){
            SaveData.set_Mode("HOLD");
            Table u1 = new Table("$" + String.valueOf(current_Price), "Looking to Sell Position", String.valueOf(Profit_Returns.get_Returns())+"%", String.valueOf(((current_Price - SaveData.get_firstPrice())/SaveData.get_firstPrice())*100)+"%");
            SaveData.set_tableData(u1);
        }

   }

    public void holdDecisionMaking(){
        if(SaveData.get_hasPostion() == true){
            SaveData.set_Mode("SELL");
        }
        else if(SaveData.get_hasPostion() == false){
            SaveData.set_Mode("BUY");
        }

    }

}
