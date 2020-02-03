// -----------------------------------------------------------------------------

// @version1.1 07-25-2019

// @author  Jiayu Li

//  File name:  MLSListingView.java

//  Program purpose: this file determines the GUI of the program

//  Disclaimer: this class extends JFrame 

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/20/19          Jiayu Li          1111          initial implementation
//     06/25/19          Jiayu Li          2222          debug & documentation

// -----------------------------------------------------------------------------

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MLSListingView extends JFrame{

   private static final int viewWidth = 720;
   private static final int viewHeight = 450;
   private static final int listingRows = 20;
   private static final int listingColumns = 60;

   private PropertyList propertyList;

   private JPanel searchPanel, displayPanel, actionPanel;

   //UI Components for Search Panel
   private JLabel searchLabel;
   private JComboBox<String> dropDownMenu;
   private JButton goButton;

   //UI Components for Display panel
   private JTextArea listings;
   private JScrollPane scrollPane;

   //UI Components for Action Panel
   private JButton showAllButton, showSFHButton, showCondoButton, clearButton;

   public MLSListingView() {
      setTitle("MLSListings");
      setSize(MLSListingView.viewWidth, MLSListingView.viewHeight);
      setLocationRelativeTo(null);

      searchPanel = new JPanel();
      displayPanel = new JPanel();
      actionPanel = new JPanel();

      searchPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
      searchLabel = new JLabel("Search Property: ");
      String[] priceRanges = new String[] {"Under 400K", "400K - <600K", 
            "600K - <800K", "800K - <1M", "Over 1M"};
      dropDownMenu = new JComboBox<String>(priceRanges);
      goButton = new JButton("Go");

      searchPanel.add(searchLabel);
      searchPanel.add(dropDownMenu);
      searchPanel.add(goButton);

      listings = new JTextArea (MLSListingView.listingRows, MLSListingView.listingColumns);
      listings.setBorder(BorderFactory.createEtchedBorder());
      listings.setEditable(false);
      listings.setAutoscrolls(true);
      /*
       * sets font to monospaced in order to correctly format the data
       * (to make it look uniformed and aligned)
       */
      listings.setFont(new Font("monospaced", 40, 12));
      displayPanel.add(listings);

      /*
       * a scroll pane is added to allow vertical and horizontal scrolling
       * when the list exceeds the window display
       */
      scrollPane = new JScrollPane(listings);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

      showAllButton = new JButton("Show All");
      showSFHButton = new JButton("Show SFH");
      showCondoButton = new JButton("Show Condo");
      clearButton = new JButton("Clear");

      actionPanel.add(showAllButton);
      actionPanel.add(showSFHButton);
      actionPanel.add(showCondoButton);
      actionPanel.add(clearButton);

      add(scrollPane, BorderLayout.CENTER);
      add(searchPanel, BorderLayout.NORTH);
      add(actionPanel, BorderLayout.SOUTH);

      goButton.addActionListener ( new ActionListener ()
      {
         public void actionPerformed (ActionEvent e)
         {
            int menuSelect = dropDownMenu.getSelectedIndex();
            switch(menuSelect) {
            case 0:
               setListings(listings, propertyList.searchByPriceRange(0, 400000));
               break;
            case 1:
               setListings(listings, propertyList.searchByPriceRange(400000, 600000));     
               break;
            case 2:
               setListings(listings, propertyList.searchByPriceRange(600000, 800000));
               break;
            case 3:
               setListings(listings, propertyList.searchByPriceRange(800000, 1000000));
               break;
            case 4: 
               setListings(listings, propertyList.searchByPriceRange(1000000, 1000000*100));
               break;
            default:
               listings.setText("");
            }
         }
      } );

      showAllButton.addActionListener ( new ActionListener ()
      {
         public void actionPerformed (ActionEvent e)
         {
            setListings(listings, propertyList.getAllProperties());
         }
      } );

      showSFHButton.addActionListener ( new ActionListener ()
      {
         public void actionPerformed (ActionEvent e)
         {
            setListings(listings, propertyList.getSingleFamilyHouse());
         }
      } );

      showCondoButton.addActionListener ( new ActionListener ()
      {
         public void actionPerformed (ActionEvent e)
         {
            setListings(listings, propertyList.getCondo());
         }
      } );
      clearButton.addActionListener ( new ActionListener ()
      {
         public void actionPerformed (ActionEvent e)
         {
            listings.setText("");
         }
      } );

      addWindowListener(new WindowAdapter () {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }

   public void setProperties(PropertyList propertyList) {
      this.propertyList = propertyList;
   }
   /*
    * private helper method created to make setting text more efficient
    */
   private void setListings(JTextArea textArea, String listings) {
      textArea.setText(String.format("%-50s%-17s%-15s%-6s", "Address", "Price", "Year", "Other Info") + "\n" + listings);
   }

}
