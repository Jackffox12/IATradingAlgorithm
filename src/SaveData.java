import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.ArrayList;

public class SaveData {

    static double last_Price; static boolean hasPostion; static boolean currentThreshold; static String setMode; static double set_percent_Change; static double buyPrice; static double currentProfitThreshold; static double currentStopThreshold; static double currentDipThreshold; static double currentUpwardThreshold; static Integer currentMillis; static File stock;
    static ArrayList<Table> tableData = new ArrayList<>(); static boolean isDone; static double initalPrice;

    public static void set_firstPrice(double firstPrice) { initalPrice = firstPrice; }
    public static double get_firstPrice() {
        return initalPrice;
    }

    public static void set_last_Price(double setPrice) { last_Price = setPrice; }
    public static double get_last_Price() {
        return last_Price;
    }

    public static void set_threshold(boolean threshold) { currentThreshold = threshold;}
    public static boolean get_threshold() {
        return currentThreshold;
    }

    public static void set_doneTrade(boolean done) { isDone = done;}
    public static boolean get_doneTrade() { return isDone;}

    public static void set_tableData(Table data){tableData.add(data);}
    public static ArrayList<Table> get_tableData() {return tableData;}

    public static void set_profitThreshold(double profitThreshold) {currentProfitThreshold = profitThreshold;}
    public static double get_profitThreshold(){return currentProfitThreshold;}

    public static void set_stopThreshold(double stopThreshold) {currentStopThreshold = stopThreshold; }
    public static double get_stopThreshold(){return currentStopThreshold;}

    public static void set_DipThreshold(double dipThreshold) {currentDipThreshold = dipThreshold; }
    public static double get_DipThreshold(){return currentDipThreshold;}

    public static void set_UpwardThreshold(double upwardThreshold) {currentUpwardThreshold = upwardThreshold; }
    public static double get_UpwardThreshold(){return currentUpwardThreshold;}

    public static void set_hasPostion(boolean postion) {hasPostion = postion;}
    public static boolean get_hasPostion() {return hasPostion;}

    public static void set_currentStock(File currentStock){stock = currentStock;}
    public static File get_currentStock() {return stock;}

    public static void set_Mode(String setMode_New) {setMode = setMode_New;}
    public static String get_Mode() {return setMode;}
}