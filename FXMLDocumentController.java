/*
 * Lina Breunlin
 * CIS 263AA
 * Final Project
 * This is the document controller for the GUI and contains all of the business logic for the ticket reservation system
 */
package finalproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;


public class FXMLDocumentController implements Initializable 
{
    //declare variables
    
    //variable to hold the user input from the GUI so it can be set for the ticket obj
    String ticketFirstName;
    String ticketLastName;
    
    //concatenate first and last name into patron name that will get stored in queue
    String patronName;
        
    //list to populate the combo box on the reservation form
    //Referenced: https://www.youtube.com/watch?v=YO9PQfTdbFI
    ObservableList<String> ticketList = FXCollections.observableArrayList ("Select Ticket",  "Adult", "Senior", "Student", "Child");
    
    //ticket objects that will recieve information from this godforsaken GUI
    
    //tickets newAdult = new adultTicket();
    tickets newAdult = new adultTicket(); 
    tickets newSenior = new seniorTicket();
    tickets newChild = new childTicket();
    tickets newStudent = new studentTicket();
    
    
    //queue that will keep track of when Patrons are reserving thier ticket so we know who gets into the auditorium first on show night
    Queue <String> entranceNum = new LinkedList <>();
    
    
    //GUI variables
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private ComboBox<String> ticketType;
    @FXML
    private Label price;
    
   
    //buttons
    @FXML
    private Button reserveButton;
    @FXML
    private Button entryListButton;
    @FXML
    private Button receiptButton;
    @FXML
    private Button ClearButton;
    @FXML
    private Label label;
    @FXML
    private Label thankYouLabel;

    
    
    //this methods displays the price for the type of ticket selected from the combobox that what someone knows what it costs before they reserve it
    @FXML
    private void displayPrice(ActionEvent event) 
    {
        switch (ticketType.getValue()) //Referenced: https://www.programcreek.com/java-api-examples/?class=javafx.scene.control.ComboBox&method=getValue
        {
            case "Select Ticket": //can't reserve a ticket w/o selecting specific type
                price.setText(" ");
                reserveButton.setDisable(true);// Referenced: https://stackoverflow.com/questions/17871329/disabling-a-button-in-javafx
                break;
            
            case "Adult":
                price.setText((String.valueOf("$" + newAdult.getPrice() + "0")));
                reserveButton.setDisable(false);
                break;
                
            case "Senior":
                price.setText((String.valueOf("$" + newSenior.getPrice() + "0")));
                reserveButton.setDisable(false);
                break;
                
            case "Student":
                price.setText((String.valueOf("$" + newStudent.getPrice() + "0")));
                reserveButton.setDisable(false);
                break;
                
            case "Child":
                price.setText((String.valueOf("$" + newChild.getPrice() + "0")));
                reserveButton.setDisable(false);
                break;
                
            default:
                break;
        }
        
    }
    
    //clears the contents of the form if you messed up typing or just want to start over
    @FXML
    private void clearForm(ActionEvent event) 
    {
      firstName.clear();
      lastName.clear();
      ticketType.getSelectionModel().select(0); //default back to select ticket
    }

    /*
    action performed when you press the reserve button. 
    passes user input into the right type of ticket object based on what they selected from the combobox
    adds the information to the queue for admission
``  */
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException 
    {
        
        //pull the user input for first name from the GUI and store in ticketFirstName variable
        ticketFirstName = firstName.getText();
        
        //pull the user input from the last name the GUI and store in ticketLastName variable
        ticketLastName = lastName.getText();
        
        //concatenate these two so it will be nicely formatted for the queue
        patronName = ticketFirstName + " " + ticketLastName;

        //create the ticket object based on what type of ticket they selected from the combobox
        switch (ticketType.getValue()) 
        {
            case "Adult":
                newAdult.setFirstName(ticketFirstName); //pass in the first name field from the GUI
                newAdult.setLastName(ticketLastName);  // pass in the last name field from the GUI
                entranceNum.add(patronName);  //add them to the queue
                
                break;
                
            case "Senior":
                newSenior.setFirstName(ticketFirstName);
                newSenior.setLastName(ticketLastName);
                entranceNum.add(patronName);
 
                break;
                
            case "Student":
                newStudent.setFirstName(ticketFirstName);
                newStudent.setLastName(ticketLastName);
                entranceNum.add(patronName);

                break;
                
            case "Child":
                newChild.setFirstName(ticketFirstName);
                newChild.setLastName(ticketLastName);              
                entranceNum.add(patronName);
                break;
                
            default:
                break;
        }
        
       thankYouLabel.setText("Thank you for your patronage!"); 
    }
    
    /*once the ticket obj has been created with all the info passed in, 
      write the informaation to an external file that will be serve as thier
      receipt
    */
    @FXML
    private void createReceipt(ActionEvent event) throws IOException 
    {

        //Referened: https://howtodoinjava.com/java/io/java-write-to-file/
        BufferedWriter rw; //receipt writer
        rw = new BufferedWriter(new FileWriter("receipt.txt"));
        rw.write ("Receipt");
        rw.newLine();

        
        switch (ticketType.getValue()) 
        {
            case "Adult":
               rw.write(newAdult.toString());
               break;
                
            case "Senior":
                rw.write(newSenior.toString());
                break;
                
            case "Student":
                rw.write(newStudent.toString());
                break;
                
            case "Child":
                rw.write(newChild.toString());
                break;
                
            default:
                break;
        }
        rw.close();
      
      /*once the ticket and receipt have been created, reset everything for the next entry
        Referenced: https://stackoverflow.com/questions/28516654/javafx-how-to-clear-textfield-when-mouse-is-clicked-on-it
      */
      firstName.clear();
      lastName.clear();
      //set default value back to 'select ticket type'
      ticketType.getSelectionModel().select(0); //Referenced: https://stackoverflow.com/questions/34949422/how-to-set-default-value-in-combobox-javafx
    }
    
    
    //action performed when you click the entry list button. Writes the queue that has been created to an external file
    @FXML
    private void createEntryList(ActionEvent event) throws IOException 
    {
        
        /*onvert the queue to an array list so that the elements can be printed to the file
          Referenced: https://stackoverflow.com/questions/12779839/convert-a-queue-to-list*/
        List<String> printPatrons = new ArrayList<>(entranceNum);
        
        try (BufferedWriter lw = new BufferedWriter(new FileWriter("patronEntry.txt"))) //list writer
        {
            lw.write("Litchfield Recreation Center Auditorium Entry List");
            lw.newLine();
            lw.newLine();

            /*print the contents of the  queue turned array to a file that will show thier order of entry
             *Referenced: https://www.interviewsansar.com/how-to-print-arraylist-elements-in-java/*/
            for (int i = 0; i < printPatrons.size(); i++)
            {
                lw.write(i + 1 + "." + " " + printPatrons.get(i));
                lw.newLine();
            }
        lw.close();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        /*set the contents of the ticketType combo box to be the items in the ticketList
          Referenced: https://www.youtube.com/watch?v=YO9PQfTdbFI*/
        ticketType.setItems(ticketList); 
    }    

}