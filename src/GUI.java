import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class GUI extends JPanel {

    static JCheckBox teslaBox, appleBox, zoomBox, amazonBox, microsoftBox;
    JOptionPane dialog;
    boolean ledger = true;
    JFrame window, window2, window3, window4, window5;
    JPanel titleNamePanel, startButtonPanel, algoPeramPanel, algoDefinePanel;
    JLabel titleNameLabel, stockTypeLabel, algoPeramLabel, algoPeramCustomLabel, algoPeramDefaultLabel,algoInfoProfitLabel, algoDefineLabel, algoInfoStopLabel, algoInfoUpwardLabel, algoInfoDipLabel;
    JButton startButton, algoDefaultButton, algoCustomButton;
    Font normalFont,stockPickFontType, titleFont, algoPeramFont, algoTitleFont, algoInfoFont, algoDefineFont, finalAlgoFont;
    String currentStock;
    GraphicsDevice gDevice;

    int currentScreenWidth = 800;
    int currentScreenHeight = 600;

    public GUI() {
        GraphicsEnvironment gEnviorment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        gDevice = gEnviorment.getDefaultScreenDevice();
        SaveData.set_threshold(false);

        window = new JFrame();
        window.setSize(currentScreenWidth, currentScreenHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.red);
        window.setLayout(null);
        window.setResizable(false);


        createFont();
        createGUIComponent();

    }

    public void createFont() {
        int titleFontSize = (int) Math.round(currentScreenWidth * 0.07);
        titleFont = new Font("Times New Roman", Font.PLAIN, titleFontSize);

        int algoPeramFontSize = (int) Math.round(currentScreenWidth * 0.03);
        algoPeramFont = new Font("Times New Roman", Font.PLAIN, algoPeramFontSize);

        int stockPickFontSize = (int) Math.round(currentScreenWidth * 0.05);
        stockPickFontType = new Font("Changa One", Font.PLAIN, stockPickFontSize);

        int normalFontSize = (int) Math.round(currentScreenWidth * 0.035);
        normalFont = new Font("Times New Roman", Font.PLAIN, normalFontSize);

        int algoDefineFontSize = (int) Math.round(currentScreenWidth * 0.025);
        algoDefineFont = new Font("Times New Roman", Font.PLAIN, algoDefineFontSize);

        int normalSize = (int) Math.round(currentScreenWidth * 0.03);
        algoTitleFont = new Font("Changa One", Font.PLAIN, normalSize);

        int algoInfoFontSize = (int) Math.round(currentScreenWidth * 0.025);
        algoInfoFont = new Font("Times New Roman", Font.PLAIN, algoInfoFontSize);

        int algoFont = (int) Math.round(currentScreenWidth * 0.022);
        finalAlgoFont = new Font("Times New Roman", Font.PLAIN, algoFont);
    }

    public void createGUIComponent() {
        //Title Name Panel
        titleNamePanel = new JPanel();
        titleNamePanel.setBackground(Color.BLACK);

        int tnp_x = (int) Math.round(currentScreenWidth * 0.125);
        int tnp_y = (int) Math.round(currentScreenHeight * 0.125);
        int tnp_w = (int) Math.round(currentScreenWidth * 0.75);
        int tnp_h = (int) Math.round(currentScreenHeight * 0.15);
        titleNamePanel.setBounds(tnp_x, tnp_y, tnp_w, tnp_h);


        //Title Name Label
        titleNameLabel = new JLabel("Fox Trading Algorithm");
        titleNameLabel.setForeground(new Color(255, 165, 0));
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);


        //Start Button Panel
        startButtonPanel = new JPanel();

        int sbp_x = (int) Math.round(currentScreenWidth * 0.375);
        int sbp_y = (int) Math.round(currentScreenHeight * 0.666);
        int sbp_w = (int) Math.round(currentScreenWidth * 0.25);
        int sbp_h = (int) Math.round(currentScreenHeight * 0.125);

        startButtonPanel.setBounds(sbp_x, sbp_y, sbp_w, sbp_h);
        startButtonPanel.setBackground(Color.red);

        //Start Button
        startButton = new JButton("Begin Trading");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(new Color(255, 165, 0));
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);
        startButton.addActionListener(new Action());


        window.add(titleNamePanel);
        window.add(startButtonPanel);

        window.setVisible(true);
    }

    public ImageIcon resizeImage(String ImagePath) {
        ImageIcon image = new ImageIcon(ImagePath);
        Image img = image.getImage();
        Image newImg = img.getScaledInstance(100, 100, 100);
        ImageIcon finalImg = new ImageIcon(newImg);
        return finalImg;
    }

    class Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window2 = new JFrame("Fox Trading Algorithm");
            window2.setVisible(true);
            window2.setSize(currentScreenWidth, currentScreenHeight);
            window.setVisible(false);


            window2.setLayout(new FlowLayout());

            window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window2.getContentPane().setBackground(Color.red);
            window2.setResizable(false);

            stockTypeLabel = new JLabel("Pick Preferred Stock to Trade");
            stockTypeLabel.setForeground(new Color(255, 165, 0));
            stockTypeLabel.setFont(stockPickFontType);
            window2.add(stockTypeLabel);


            teslaBox = new JCheckBox("Tesla Stock", false);
            appleBox = new JCheckBox("Apple Stock", false);
            amazonBox = new JCheckBox("Amazon Stock", false);
            microsoftBox = new JCheckBox("Microsoft Stock", false);
            zoomBox = new JCheckBox("Zoom Stock", false);


            teslaBox.addActionListener(new actionTesla());
            appleBox.addActionListener(new actionApple());
            amazonBox.addActionListener(new actionAmazon());
            microsoftBox.addActionListener(new actionMicrosoft());
            zoomBox.addActionListener(new actionZoom());


            // create a new panel
            JPanel p = new JPanel();

            // add checkbox to panel
            p.add(teslaBox);
            p.add(appleBox);
            p.add(amazonBox);
            p.add(microsoftBox);
            p.add(zoomBox);

            // add panel to frame
            window2.add(p);

            // set the size of frame
            window2.setSize(600, 300);

            window2.show();
        }
    }

    class actionTesla implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File teslaTradingData = new File("C:\\Users\\jackf\\Desktop\\IATradingAlgorithm\\src\\TSLA_1min_sample.csv");
            SaveData.set_currentStock(teslaTradingData);
            currentStock = "Tesla's";
            setAlgoPeram();
        }
    }
    class actionApple implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File appleTradingData = new File("C:\\Users\\jackf\\Desktop\\IATradingAlgorithm\\src\\AAPL_1min_sample.csv");
            SaveData.set_currentStock(appleTradingData);
            currentStock = "Apple's";
            setAlgoPeram();
        }
    }
    class actionAmazon implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File amazonTradingData = new File("C:\\Users\\jackf\\Desktop\\IATradingAlgorithm\\src\\AMZN_1min_sample.csv");
            SaveData.set_currentStock(amazonTradingData);
            currentStock = "Amazon's";
            setAlgoPeram();
        }
    }
    class actionMicrosoft implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File microsoftTradingData = new File("C:\\Users\\jackf\\Desktop\\IATradingAlgorithm\\src\\MSFT_1min_sample.csv");
            SaveData.set_currentStock(microsoftTradingData);
            currentStock = "Microsoft's";
            setAlgoPeram();
        }
    }
    class actionZoom implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File zoomTradingData = new File("C:\\Users\\jackf\\Desktop\\IATradingAlgorithm\\src\\ZM_1min_sample.csv");
            SaveData.set_currentStock(zoomTradingData);
            currentStock = "Zoom's";
            setAlgoPeram();

        }
    }
    public void setAlgoPeram(){
        window3 = new JFrame("Fox Trading Algorithm");
        window3.setVisible(true);
        window3.setSize(currentScreenWidth, currentScreenHeight-200);
        window2.setVisible(false);


        window3.setLayout(new FlowLayout());

        window3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window3.getContentPane().setBackground(Color.red);
        window3.setResizable(false);

        algoPeramPanel = new JPanel();
        algoPeramLabel = new JLabel("Choose Between Default Trade Settings or Custom Trade Settings");
        algoPeramLabel.setForeground(new Color(255, 165, 0));
        algoPeramLabel.setFont(algoTitleFont);
        algoPeramPanel.setBackground(Color.red);

        algoPeramPanel.add(algoPeramLabel);


        algoPeramCustomLabel = new JLabel("Custom Trade Settings allow you to alter the passiveness or the aggressiveness of the algorithm");
        algoPeramCustomLabel.setForeground(Color.white);
        algoPeramCustomLabel.setFont(algoDefineFont);
        algoPeramCustomLabel.setBorder(new EmptyBorder(7,0,100,0));

        algoPeramDefaultLabel = new JLabel("Default Trade Settings allow you to trade at the determined most effective settings");
        algoPeramDefaultLabel.setForeground(Color.white);
        algoPeramDefaultLabel.setFont(algoDefineFont);
        algoPeramDefaultLabel.setBorder(new EmptyBorder(10,0,0,0));

        window3.add(algoPeramPanel);
        window3.add(algoPeramDefaultLabel);
        window3.add(algoPeramCustomLabel);


        //Default Trading Button
        algoDefaultButton = new JButton("Default Trading Settings");
        algoDefaultButton.setBackground(Color.BLACK);
        algoDefaultButton.setForeground(new Color(255, 165, 0));
        algoDefaultButton.setFont(algoPeramFont);
        algoDefaultButton.setFocusPainted(false);
        algoDefaultButton.addActionListener(new defaultAlgo());


        //Custom Trading Button
        algoCustomButton = new JButton("Custom Trading Settings");
        algoCustomButton.setForeground(new Color(255, 165, 0));
        algoCustomButton.setFont(algoPeramFont);
        algoCustomButton.setBackground(Color.BLACK);
        algoCustomButton.setFocusPainted(false);
        algoCustomButton.addActionListener(new customAlgo());


        window3.add(algoDefaultButton);
        window3.add(algoCustomButton);
        window3.setVisible(true);
    }

    class customAlgo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window4 = new JFrame("Fox Trading Algorithm");
            window4.setVisible(true);
            window4.setSize(currentScreenWidth, currentScreenHeight-100);
            window3.setVisible(false);

            window4.setLayout(new FlowLayout());

            window4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window4.getContentPane().setBackground(Color.red);
            window4.setResizable(false);

            algoDefinePanel = new JPanel();
            algoDefineLabel = new JLabel("Custom Algorithm Trade Setting Definitions");
            algoDefineLabel.setForeground(new Color(255, 165, 0));
            algoDefineLabel.setFont(normalFont);
            algoDefinePanel.setBackground(Color.red);

            algoDefinePanel.add(algoDefineLabel);

            algoInfoProfitLabel = new JLabel("Profit Threshold = Sells the asset if its price has increased above the threshold since we bought it");
            algoInfoProfitLabel.setForeground(Color.white);
            algoInfoProfitLabel.setFont(finalAlgoFont);
            algoInfoProfitLabel.setBorder(new EmptyBorder(30,0,30,0));

            algoInfoStopLabel = new JLabel("Stop Loss Threshold = Sells the asset at a loss, but with the goal of stopping a bigger loss from happening");
            algoInfoStopLabel.setForeground(Color.white);
            algoInfoStopLabel.setFont(finalAlgoFont);
            algoInfoStopLabel.setBorder(new EmptyBorder(0,0,30,0));

            algoInfoDipLabel = new JLabel("Dip Threshold = Buys the asset if its price decreased by more than the threshold value");
            algoInfoDipLabel.setForeground(Color.white);
            algoInfoDipLabel.setFont(finalAlgoFont);
            algoInfoDipLabel.setBorder(new EmptyBorder(0,0,30,0));

            algoInfoUpwardLabel = new JLabel("Upward Trend Threshold = Buys the asset if its price increased by more than the threshold");
            algoInfoUpwardLabel.setForeground(Color.white);
            algoInfoUpwardLabel.setFont(finalAlgoFont);
            algoInfoUpwardLabel.setBorder(new EmptyBorder(0,0,30,0));

            window4.add(algoDefinePanel);
            window4.add(algoInfoProfitLabel);
            window4.add(algoInfoStopLabel);
            window4.add(algoInfoDipLabel);
            window4.add(algoInfoUpwardLabel);
            dialog = new JOptionPane();
            dialog.setLocation(100,10);

            String profitThreshold = dialog.showInputDialog(null,"Set Profit Threshold (represent value as percent)");
           while (profitThreshold == null){
                 profitThreshold = dialog.showInputDialog(null,"Set Profit Threshold (represent value as percent)");
            }

            String stopLossThreshold = dialog.showInputDialog(null,"Set Stop Loss Threshold (represent value as a negative percent)");
            while (stopLossThreshold == null){
                stopLossThreshold = dialog.showInputDialog(null,"Set Stop Loss Threshold (represent value as a negative percent)");
            }

            String dipThreshold = dialog.showInputDialog(null,"Set Dip Threshold (represent value as a negative percent)");
            while(dipThreshold == null){
                dipThreshold = dialog.showInputDialog(null,"Set Dip Threshold (represent value as a negative percent)");
            }

            String upwardTrendThreshold = dialog.showInputDialog(null,"Set Upward Trend Threshold (represent value as percent)");
            while(upwardTrendThreshold == null){
                upwardTrendThreshold = dialog.showInputDialog(null,"Set Upward Trend Threshold (represent value as percent)");
            }

            if((upwardTrendThreshold.length() == 0) || (dipThreshold.length() == 0) || (stopLossThreshold.length() == 0) || (profitThreshold.length() == 0)){
                SaveData.set_threshold(false);
                window4.setVisible(false);
                setAlgoPeram();

            }
            else{
                SaveData.set_threshold(true);
                SaveData.set_profitThreshold(Double.parseDouble(profitThreshold));
                SaveData.set_stopThreshold(Double.parseDouble(stopLossThreshold));
                SaveData.set_DipThreshold(Double.parseDouble(dipThreshold));
                SaveData.set_UpwardThreshold(Double.parseDouble(upwardTrendThreshold));
                tradingPage();
            }
        }
    }

    class defaultAlgo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SaveData.set_profitThreshold(0.5);
            SaveData.set_stopThreshold(-0.50);
            SaveData.set_DipThreshold(-1.0);
            SaveData.set_UpwardThreshold(1.2);
            SaveData.set_threshold(true);
            ledger = false;
            tradingPage();
        }
    }

    public void tradingPage() {
        while(SaveData.get_doneTrade() == false){System.out.print("");}
        window5 = new JFrame("Fox Trading Algorithm");
        window3.setVisible(false);
        if (ledger == true){
            window4.setVisible(false);
        }
        ArrayList<Table> currentTable = SaveData.get_tableData();
        currentTable.toArray();
        String[][] array = new String[currentTable.size()][4];
        for(int i = 0; i < currentTable.size(); i++) {
                array[i][0] = (currentTable.get(i).getCurrentPrice());
                array[i][1] = (currentTable.get(i).getCurrentDecsion());
                array[i][2] = (currentTable.get(i).getPercentGain());
                array[i][3] = (currentTable.get(i).getStockPercentGain());

        }

        String column[] = {currentStock +" Current Price", " Algorithms Current Decision", "Algorithms Percent Gain", currentStock + " Percent Gain"};
        JTable jt =new JTable(array,column);
        jt.setBackground(Color.red);
        jt.setForeground(Color.white);

        JTableHeader tHeader = jt.getTableHeader();
        TableModel tableModel = jt.getModel();

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            jt.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }

        tHeader.setBackground(new Color(255, 165, 0));
        tHeader.setForeground(Color.black);
        tHeader.setFont(new Font("Tahome", Font.BOLD, 15));

        ((DefaultTableCellRenderer)tHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        jt.setFont(new Font("Tahome", Font.BOLD,15));
        //jt.setAutoResizeMode(jt.resiz);


        TableColumn col0 = jt.getColumnModel().getColumn(0);
        TableColumn col1 = jt.getColumnModel().getColumn(1);
        TableColumn col2 = jt.getColumnModel().getColumn(2);
        TableColumn col3 = jt.getColumnModel().getColumn(3);
        col0.setPreferredWidth(200); col1.setPreferredWidth(380); col2.setPreferredWidth(200); col3.setPreferredWidth(200);
        JScrollPane sp=new JScrollPane(jt);
        window5.add(sp);
        window5.setSize(980,600);
        window5.setVisible(true);
        window.setResizable(false);
        JOptionPane.showMessageDialog(null,"Algorithms Generated Return: " + Profit_Returns.get_Returns() + "%");
    }
}

