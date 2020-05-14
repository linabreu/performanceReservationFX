/*
 * Lina Breunlin
 * CIS 263AA
 * Final Project
*This is the subclass class file for child tickets it extends the tickets abstract class
*/
package finalproject;


public class childTicket extends tickets
{
    public childTicket() //populate w default value because this information will always be the same as for as this application is concerned
    {
        super();
        ticketType = "Child";
        price = 5.00;
        description = "Patrons under 13. Adult supervision required";
    }
    
}
