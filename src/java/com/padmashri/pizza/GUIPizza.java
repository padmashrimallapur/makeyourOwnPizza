package com.padmashri.pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintStream;

public class GUIPizza {

    public JFrame frame;
    private JPanel contentPane;


    private JRadioButton deepDishCrust;
    private JRadioButton handTossedCrust;
    private JRadioButton thinCrustButton;
    private JRadioButton regularCrustButton;
    private ButtonGroup CrustButtonGroup;

    private JCheckBox pepparoniBox;
    private JCheckBox sausageBox;
    private JCheckBox extraCheesBox;
    private JCheckBox bellPepperBox;
    private JCheckBox onionBox;
    private JCheckBox mushroomsBox;
    private JCheckBox olivesBox;
    private JCheckBox AnchoviesBox;

    private JTextField breadSticksText;
    private JTextField bufelloWingsText;
    private JTextField nameTextArea;
    private JTextField addressTextArea;
    private JTextField cityTextArea;

    public static void main(String[] args) {

        //System.setProperty("apple.laf.useScreenMenuBar", "true");
        GUIPizza Gmenu = new GUIPizza();
        Gmenu.start();
    }

    public void start() {
        frame = new JFrame(" Menu Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Container contentPane = frame.getContentPane();

        makeMenus();
        makeContent();
        frame.pack();
        frame.setVisible(true);
    }

    private void makeContent() {
        contentPane = (JPanel) frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6, 6));
        makeNorthRegion();
        makeWestRegion();
        makeCenterRegion();
        makeEastRegion();
        makeSouthRegion();
    }

    private void makeNorthRegion() {

        JLabel newImageLable = new JLabel(new ImageIcon("out/Pizza_img.jpg"), JLabel.CENTER);
        contentPane.add(newImageLable, BorderLayout.NORTH);
    }

    private void makeWestRegion() {

        //System.out.println("inside make west");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Choose a Crust"));
        CrustButtonGroup = new ButtonGroup();

        regularCrustButton = new JRadioButton("Regular Crust", true);
        CrustButtonGroup.add(regularCrustButton);
        panel.add(regularCrustButton);

        thinCrustButton = new JRadioButton("Thin Crust", true);
        CrustButtonGroup.add(thinCrustButton);
        panel.add(thinCrustButton);

        handTossedCrust = new JRadioButton("Hand Tossed Crust", true);
        CrustButtonGroup.add(handTossedCrust);
        panel.add(handTossedCrust);

        deepDishCrust = new JRadioButton("Deep Dish Crust", true);
        CrustButtonGroup.add(deepDishCrust);
        panel.add(deepDishCrust);

        contentPane.add(panel, BorderLayout.WEST);

    }

    private void makeCenterRegion() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Select Toppings"));

        pepparoniBox = new JCheckBox("Pepparoni", false);
        panel.add(pepparoniBox);

        sausageBox = new JCheckBox("Sausage", false);
        panel.add(sausageBox);

        onionBox = new JCheckBox("Onion", false);
        panel.add(onionBox);

        bellPepperBox = new JCheckBox("BellPepper", false);
        panel.add(bellPepperBox);

        extraCheesBox = new JCheckBox("Extra Cheese", false);
        panel.add(extraCheesBox);

        mushroomsBox = new JCheckBox("Mushrooms", false);
        panel.add(mushroomsBox);

        olivesBox = new JCheckBox("Olives", false);
        panel.add(olivesBox);

        AnchoviesBox = new JCheckBox("AnchoviesBox", false);
        panel.add(AnchoviesBox);


        contentPane.add(panel, BorderLayout.CENTER);
    }

    private void makeEastRegion() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Sides (Enter Quantity)"));
        panel.setPreferredSize(new Dimension(150, 0));

        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));


        breadSticksText = new JTextField("", 2);
        breadSticksText.setMaximumSize(new Dimension(30, 34));
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        smallPanel.add(breadSticksText);
        smallPanel.add(new JLabel("BreadSticks"));
        panel.add(smallPanel);


        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));

        bufelloWingsText = new JTextField("", 2);
        bufelloWingsText.setMaximumSize(new Dimension(30, 34));
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        smallPanel.add(bufelloWingsText);
        smallPanel.add(new JLabel("Bufello Wings"));

        panel.add(smallPanel);


        contentPane.add(panel, BorderLayout.EAST);

    }

    private void makeSouthRegion() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Deliver To:"));

        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
        smallPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        smallPanel.add(new Label("Name:"));
        smallPanel.add(new Label("Address:"));
        smallPanel.add(new Label("City, ST, Zip:"));

        panel.add(smallPanel);

        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
        smallPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        nameTextArea = new JTextField();
        cityTextArea = new JTextField();
        addressTextArea = new JTextField();
        smallPanel.add(nameTextArea);
        smallPanel.add(cityTextArea);
        smallPanel.add(addressTextArea);


        panel.add(smallPanel);
        contentPane.add(panel, BorderLayout.SOUTH);


    }


    private void makeMenus() {
        JMenuBar menuBar;
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // set up menus
        menuBar.add(makeFileMenu());
        menuBar.add(makeHelpMenu());
    }


    private JMenu makeFileMenu() {

        JMenuItem menuItem;
        JMenu menu;

        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);


        menuItem = new JMenuItem("New");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.addActionListener(new newListener());
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        menu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.addActionListener(new saveListener());
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        menu.add(menuItem);

        /*menuItem = new JMenuItem("Save As");
        menuItem.setMnemonic(KeyEvent.VK_A);
        menuItem.addActionListener(new saveAsListener());
        menuItem.setDisplayedMnemonicIndex(5);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));  */

        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
        menuItem.setMnemonic(KeyEvent.VK_E);
        menuItem.addActionListener(new exitListener());
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
        menu.add(menuItem);

        //menu.setMnemonic(.VK_F);
        // menuItem.setMnemonic(KeyEvent.VK_O);
        return menu;
    }

    private JMenu makeHelpMenu() {
        JMenu menu;
        JMenuItem menuItem;        // set up the Help menu
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);

        // add About menu item
        menuItem = new JMenuItem("About GUI Pizza");
        menuItem.setMnemonic(KeyEvent.VK_A);
        menuItem.addActionListener(new AboutListener());
        menu.add(menuItem);

        return menu;
    }


    private class newListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // menu.setMnemonic(KeyEvent.VK_F);

            regularCrustButton.setSelected(true);

            pepparoniBox.setSelected(false);
            sausageBox.setSelected(false);
            onionBox.setSelected(false);
            bellPepperBox.setSelected(false);
            extraCheesBox.setSelected(false);
            mushroomsBox.setSelected(false);
            olivesBox.setSelected(false);
            AnchoviesBox.setSelected(false);

            breadSticksText.setText("");
            bufelloWingsText.setText("");
            nameTextArea.setText("");
            addressTextArea.setText("");
            cityTextArea.setText("");

        }
    }

    private class openListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame,
                    "The  File > open  menu option was clicked",
                    "Menu Item Click",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String order = "Pizza Order \n" +
                    "============================= \n" +
                    "Crust : \n" ;
            if (regularCrustButton.isSelected())
                order += "      Regular \n";
            else if (thinCrustButton.isSelected())
                order += "      Thin \n";
            else if (deepDishCrust.isSelected())
                order += "      Deep Dish \n";
            else if (handTossedCrust.isSelected())
                order += "      Hand Tossed \n";
            else
                JOptionPane.showMessageDialog(frame,
                        "You must select a crust type",
                        "Crust type error",
                        JOptionPane.ERROR_MESSAGE);

            order += "Toppings :\n";
            if(pepparoniBox.isSelected())
                order += "      Pepparoni \n";
            if(bellPepperBox.isSelected())
                order += "      BellPepper \n";
            if(extraCheesBox.isSelected())
                order += "      Extra Chees \n";
            if(sausageBox.isSelected())
                order += "      Sausage \n";
            if(mushroomsBox.isSelected())
                order += "      Mushrooms \n";
            if(onionBox.isSelected())
                order += "      Onions \n";
            if(olivesBox.isSelected())
                order += "      Olives \n";
            if(AnchoviesBox.isSelected())
                order += "      Anchovies \n";
            int bs = 0;
            int bw = 0;
            try {

                if (!breadSticksText.getText().isEmpty()) {
                    bs = Integer.parseInt(breadSticksText.getText());
                }
                if (!bufelloWingsText.getText().isEmpty()) {
                    bw = Integer.parseInt(bufelloWingsText.getText());
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(frame,
                        "Side order entries must be numeric \n" +
                        "Side order must be whole number",
                        "Side order error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (bs > 0 || bs > 0) {
                order += "Side : \n";
                if (bs > 0) {
                    order += "      " + bs + " Bread Sticks \n" ;
                }
                if (bw > 0) {
                    order += "      " + bw + " Bufello Wings \n";
                }
            }
            if (nameTextArea.getText().isEmpty() || addressTextArea.getText().isEmpty() || cityTextArea.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "name, address fields can not be empty \n" ,
                        "Address error ",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                order += "Address To :\n" ;
                order += "      " + nameTextArea.getText() + "\n" ;
                order += "      " + cityTextArea.getText() + "\n";
                order += "      " + addressTextArea.getText() + "\n";
            }
            order += "\n***** End Of the order ******";


            try {
                PrintStream ofile = new PrintStream("PizzaOrder.txt");
                ofile.print(order);
                ofile.close();
            } catch (IOException io) {
                System.out.println(" ****** I/o Error " + io);
            }


        }
    }


    private class AboutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame,
                    "GUI Pizza\n\nVersion 1.0\nBuild B20080226-1746\n\n" +
                            "(c) Copyright Merrill Hall 2008\nAll rights reserved\n\n" +
                            "Visit /\nEducation To Go\n" +
                            "Intermediate Java Course",
                    "About GUI Pizza",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private class exitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);

        }
    }
}
