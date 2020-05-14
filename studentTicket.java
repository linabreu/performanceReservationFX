/*
 * Lina Breunlin
 * CIS 263AA
 * Final Project
 *This is the subclass class file for student tickets it extends the tickets abstract class
*/
package finalproject;


public class studentTicket extends tickets
{
    public studentTicket() //populate w default value because this information will always be the same as for as this application is concerned
    {
        super();
        ticketType = "Student";
        price = 8.00;
        description = "High School and College Students. Valid ID required";

    }
    
}
