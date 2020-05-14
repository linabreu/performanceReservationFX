/*
*Lina Breunlin
 * Lina Breunlin
 * CIS 263AA
 * Final Project
 *This is the subclass class file for adult tickets, it extends the tickets abstract class
*/
package finalproject;


public class adultTicket extends tickets 
{
    
    public adultTicket() //populate w default value because this information will always be the same as for as this application is concerned
    {
        super();
        ticketType = "Adult";
        price = 12.00;
        description = "Patrons aged 13+";
    }

    
}