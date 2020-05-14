/*
Lina Breunlin
CIS 263AA
This is the class file for superclass tickets. It contains a blueprint for all the child objects that will extend this class
 */
package finalproject;

import java.text.DecimalFormat;


abstract class tickets 
{
    //declare instance variables
    
    
    double price;
    String description;
    String ticketType;
    
    //this will get passed in from the GUI
    String firstName;
    String lastName;

    //pertains the the venue will be used when printing information to the receipt file
    String venueName;
    String performanceName;
    String performanceDate;
    String performanceTime;
    String reservationDate;
    
    
    
    /**set the type of ticket
    * @param ticketTypeOf
    */
    public void setTicketType(String ticketTypeOf)
    {
       ticketType = ticketTypeOf;
    }   

    /**set the price of the ticket
    * @param ticketPrice
    */
    public void setPrice (double ticketPrice)
    {
        price = ticketPrice;
    }
    
    /**set the description of the ticket
    * @param ticketDesc
    */
    public void setDescription(String ticketDesc)
    {
        description = ticketDesc;
    }

    /**set the first name of the ticket holder
    * @param ticketFirstName
    */
    public void setFirstName (String ticketFirstName)
    {
        firstName = ticketFirstName;
    }
    
    /**set the last name of the ticket holder
    * @param ticketLastName
    */
    public void setLastName (String ticketLastName)
    {
        lastName = ticketLastName;
    }
    
    /**set the name of venue
    * @param ticketVenue
    */
    public void setVenueName (String ticketVenue)
    {
        venueName = ticketVenue;
    }
    
    /**set the name of the performance
    * @param ticketPerformance
    */
    public void setPerformanceName(String ticketPerformance)
    {
        performanceName = ticketPerformance;
    }
    
    /**set the time of the performance
    * @param ticketTime
    */
    public void setPerformanceTime(String ticketTime)
    {
        performanceTime = ticketTime;
    }
    
    /**set the date of performance
    * @param ticketDate
    */
    public void setPerformanceDate(String ticketDate)
    {
        performanceTime = ticketDate;
    }
    
    
     /**
     * gets current value of firstName
     * @return firstName
    */ 
    public String getFirstName()
    {
        return firstName;
    }
    
     /**
     * gets current value of lastName
     * @return lastName
    */ 
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     * gets current value of price
     * @return price
    */ 
    public String getTicketType()
    {
        return ticketType;
    }
    
    /**
     * gets current value of price
     * @return price
    */ 
    public double getPrice()
    {
        return price;
    }
    
    /**
     * gets current value of description
     * @return description
    */
     public String getDesc()
    {
        return description;
    }
    
    /**
     * gets current value of venueName 
     * @return venueName 
    */
    public String getVenueName()
    {
        return venueName;
    }
    
    /**
     * gets current value of performanceName 
     * @return performaneName 
    */
    public String getPerformanceName()
    {
        return performanceName;
    } 
    
    /**
     * gets current value of performanceTime 
     * @return performanceTime
    */
    public String getPerformanceTime()
    {
        return performanceTime;
    }
    
    /**
     * gets current value of peformanceDate 
     * @return performanceDate 
    */
    public String getPerformanceDate()
    {
        return performanceDate;
    }
    
    //nondefault constructor method w default values bc they will be the same for all the tickets being reserved no matter what kind they are
    public tickets ()
    {
        firstName = " "; //set to empty string. Pass in user input.
        lastName = " ";
        venueName = "Litchfield Recreation Center"; 
        performanceName = "Hamlet";
        performanceDate = "May 8, 2020";
        performanceTime = "6:30PM";
        
    }
    
    
  //override toString method to get a nice little print out of all the details. This method will get printed to the receipt document 
  @Override
  public String toString() 
  { 
      //Referenced: https://javarevisited.blogspot.com/2012/03/how-to-format-decimal-number-in-java.html
      DecimalFormat twoPlace = new DecimalFormat("##.00");
    
      
      //Referenced: https://stackoverflow.com/questions/29038627/how-can-i-print-a-new-line-in-a-tostring-method-in-java
      return "\tFirst Name: " + getFirstName() + "\n" + "\tLast Name: " + getLastName() + "\n" + "\tTicket: " + getTicketType() + "(" +getDesc() + ")" 
            + "\n" + "\tPrice: $" + twoPlace.format(getPrice()) + "\n" + "\tVenue: " + getVenueName() + "\n" + "\tPerformance: " + getPerformanceName() +
          "\n" + "\tDate: " + getPerformanceDate() + "\n" + "\tTime: " + getPerformanceTime();
  }
  
  
  
    
    
}

