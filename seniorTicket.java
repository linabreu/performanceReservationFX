/*
 * Lina Breunlin
 * CIS 263AA
 * Final Project
 *This is the subclass class file for senior tickets, it extends the tickets abstract class
*/
package finalproject;


public class seniorTicket extends tickets
{
     
    public seniorTicket() //populate w default value because this information will always be the same as for as this application is concerned
    {
        super();
        ticketType = "Senior";
        price = 10.00;
        description = "Patrons aged 65+. Valid ID required.";
    }
    
}
