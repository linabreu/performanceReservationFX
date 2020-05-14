# performanceReservationFX
Final Project FX application that allows user to reserve seats to a peformance. Utilizes a GUI, inheritence, an advanced data structure and file I/O

About the Application:
ticket reservation system for a small theatre that offers general admission seating. The GUI allows the theatre patron to input their first and last name and reserve the appropriate type of ticket.

Once the patron has reserved their ticket, the application assigns them an auditorium entrance number based on how far in advance they made their reservation, which determines the order they would be let into the auditorium on the night of the performance to pick their seat.

How to Use:

First select the appropriate type of ticket, once this is done, input the patron’s first and last name in the text fields. After that click on the “reserve” button which will create the appropriate type of ticket object based on your selection using the input from the text fields and add it to the queue. 

After you have clicked reserve, click either “receipt” to send the information to an external file (receipt.txt) and start over or click the clear button. Once all the tickets have been reserved, click the “Entry List” button. This will give you the order in which the patrons reserved their tickets and tell you the order that they can enter the theatre on the night of the show

Object- Oriented Design:

he fictitious theatre that this application is built for sells four types of tickets, Adult, Senior, Student and Child. Each ticket costs a different amount and has a different description of who is applicable to purchase it. Otherwise, all the other information that pertains to the tickets is the same. 

Because of this I chose to create an abstract super class called “tickets” because I wanted the fields and methods to be inherited by all the subclasses but the theatre does not sell just a “ticket”, it has to be one of the four types mentioned above, so I thought it made more sense to use an abstract class rather than an interface.

The subclasses do not override any methods, but each has its own constructor which populates with several default values. I chose to have the constructors supply the default values because those things would always be the same (i.e. an Adult ticket is always $12.00). 

Advanced Data Structure:

The application uses a queue to keep track of the patrons who are reserving tickets. The patrons are incentivized to reserve their tickets far in advance because the theatre does not assign seats. 

Patrons are assigned an auditorium entrance number which is the order on show night they are let into the auditorium to pick their seat, so the earlier they reserve a ticket, the better chance they have of getting a good seat. A queue made sense for this because it is a first in first out data structure and I was picturing patrons on the night of the show waiting in line to go into the auditorium.

File Output:

The application writes to two different files. After a patron has reserved their ticket, there is a receipt button that takes all the information in the ticket object’s overridden toString() method and writes it to an external file called “receipt” (line 193).

Once all the tickets have been placed into the queue (or if you want to check part way through, you can do that too) there is a button on the GUI called “Entry List” that converts the queue to an array and then prints the patron’s name with their corresponding entry number to  an external file called “patronEntry.txt” (line 238). 




