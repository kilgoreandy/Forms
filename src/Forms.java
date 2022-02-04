import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Forms {
    private JPanel rootPanel;
    private JButton helloButton;
    private JLabel helloLabel;
    private JTextField nametextField;
    private JTextArea DrinkSelection;
    private JButton dollarbutton;
    private JButton halfdollarbutton;
    private JTextArea amountDisplay;
    private JTextArea systemMessages;
    private JButton dispenseDrinkButton;
    private JTextArea restockmessages;
    private JRadioButton waterRadioButton;
    private JRadioButton cocoColaRadioButton;
    private JRadioButton spriteRadioButton;
    private JRadioButton MTNDEWRadioButton;
    private JRadioButton lemonaideRadioButton;
    private JPanel drinkpic;
    double price;
    double amount = 0.00;
    int currentStock = 2;
    int capacity = 30;
    String drinkName;
    boolean isSelected = false;

    public Forms() {

        ButtonGroup drinks = new ButtonGroup();
        drinks.add(waterRadioButton);
        drinks.add(cocoColaRadioButton);
        drinks.add(spriteRadioButton);
        drinks.add(MTNDEWRadioButton);
        drinks.add(lemonaideRadioButton);
        DrinkSelection.setText("Drink Selection:");
        dollarbutton.addActionListener(e -> {
            amount += 1.00;
            amountDisplay.setText("$" + amount);
        });
        rootPanel.setBackground(Color.WHITE);
          halfdollarbutton.addActionListener(e -> {
            amount += .50;
            amountDisplay.setText("$" + amount);
        });
        dispenseDrinkButton.addActionListener(e -> {
            DecimalFormat d = new DecimalFormat("##.##");
            helloLabel.setText("");
            if(!isSelected){
                systemMessages.setText("Drink not selected! Try again!");
            }
            else if(amount < price){
                systemMessages.setText("You did not enter enough money, try again. ");
            }
            else if(amount > price){
                systemMessages.setText("Too much change inserted, change owed: $ " +(d.format((amount-price)))
                + "\n" + drinkName + " Dispensed");
                currentStock = currentStock-1;
                amount = 0.0;
                amountDisplay.setText("$" + amount);
                if(currentStock == 0) {
                    restockmessages.setText("Stock Low, Restocking" + "\n" + "Done Restocking!");
                    currentStock = capacity;
                }
            }
            else{
                systemMessages.setText(drinkName + " Dispensed Enjoy your day!");
                currentStock = currentStock-1;
                amount = 0.0;
                amountDisplay.setText("$" + amount);
                if(currentStock == 0) {
                    restockmessages.setText("Stock Low, Restocking" + "\n" + "Done Restocking!");
                    currentStock = capacity;
                }
            }
        });
        waterRadioButton.addActionListener(e -> {
            drinkName = "Water";
            isSelected = true;
            price = 2.00;
        });
        cocoColaRadioButton.addActionListener(e -> {
            drinkName = "Coco-Cola";
            isSelected = true;
            price = 3.00;
        });
        spriteRadioButton.addActionListener(e -> {
            drinkName = "Sprite";
            isSelected = true;
            price = 3.00;
        });
        MTNDEWRadioButton.addActionListener(e -> {
            drinkName = "MTNDEW";
            isSelected = true;
            price = 3.00;
        });
        lemonaideRadioButton.addActionListener(e -> {
            drinkName = "Lemonaide";
            isSelected = true;
            price = 3.00;

        });
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Forms");
        frame.setContentPane(new Forms().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
