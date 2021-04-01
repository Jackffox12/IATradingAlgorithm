

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        SaveData.set_doneTrade(false);
        new GUI();

        while(SaveData.get_currentStock() == null){}
        while(SaveData.get_threshold() == false){System.out.print("");}

        SaveData.set_Mode("BUY");
        Parser currentStock = new Parser(SaveData.get_currentStock());


        while(currentStock.scanner.hasNext()) {
            String[] currentLine = new String[7];
            currentLine = currentStock.seperateOneMinData();
            tradeBot analyze = new tradeBot(currentLine);
            if (SaveData.get_Mode() == "BUY") {
                analyze.buyDecisionMaking();
            } else if (SaveData.get_Mode() == "SELL"){
                analyze.sellDecisionMaking();
            } else {analyze.holdDecisionMaking();}
        }

        System.out.println(Profit_Returns.get_currentRevenue());
        System.out.println(Profit_Returns.get_Returns());
        SaveData.set_doneTrade(true);
    }
}
