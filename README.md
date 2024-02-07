Below, you can find the description of your sixth assignment, which also
includes its output in the Application Walkthrough section.
In this assignment, you are expected to improve your existing Hotel
Reservation System by incorporating polymorphism and an abstract class.
Fig.1 Services class hierarchy
Even though the menu structure of your next assignment looks very similar to
the previous one, there are major changes in the requirements of the
application and as a result, it will require you to re-write your existing code. In
order to achieve a more realistic scenario and for more flexibility, your new
system should be able to accommodate unlimited number of reservations – to
be clear; there should be no fixed size arrays inside your code. You should be
using the relevant data structure (java.util.Collection) according to your needs. 
Furthermore, this assignment also introduces a new structure where the hotels
do not only provide room rental service but additional services such as laundry
and Spa. All services offered are merged under the umbrella of Services
abstract class (see Fig.1). There are still six types of rooms (Single, Double,
Club, Family, FamilyView and Suite) that are offered by the hotels. However,
now every a customer can make unlimited number of reservations and every
reservation can have unlimited number of additional services – such as Spa and
laundry. All services should be tracked with a reservation ID. So a person who
does not have a room reservation is not a customer and a person who is not a
customer cannot get a Spa or laundry service.
When the application is started, it should prompt the user with the following
menu:
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
When the user selects the 1nd option, the system will expect the user to input
the generic information about the reservation and lastly to provide the room
type. The roomType provided by the user is then should be compared using
equals() method and a relevant type of subclass instance should be created.
Then, the created object, which will be a subclass of Room, should be added to
the Reservation object via its constructor. Then fully constructed Reservation
objects should be added into the Services data structure for later use.
When the user selects the 2rd option, the information about all reservations
should be printed with the help of the existing displayInfo() method.
When the user selects the 3rd option, the system should ask the user to input a
city name and then traverse the Services data structure to find the reservation
hotels for that specific city and list them on the screen.
When the user selects the 4th option, the system should list the possible
services and ask the user to pick one. As a follow up, the system should ask
the user to provide a Reservation ID for billing purposes of that service. Then
depending to the service type; it should ask for the number of clothes to be
washed or the number of days that the customer wants to use the Spa. The 
system should charge customers 100 TL per Spa day and 20 TL per laundry
item. After all the above information is collected then it should be added into
the Services data structure for later use.
When the user selects the 5th option, it should calculate the total service cost
per purchase per reservation and list them on the screen. As an example, a
Reservation ID holder customer could have bought 2 days of Spa service twice.
Each one should be calculated separately and listed separately.
When the user selects the 6th option, the system should calculate the grand
total bill per Reservation ID and list them on the screen. As an example, a
Reservation ID holder customer could have booked a room, received laundry
service twice (first time for 5 items and second time for 3 items) and went to the
Spa once. The system should calculate the total cost and show the overall bill.
When the user selects the 7th option, the application should exit.
Application Walkthrough
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
1
ROOM INFOS:
Room Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: false
Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: false
Room Type: Club, Daily Cost: 250, Room Size: 45, Has Bath: true
Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: false
Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: true
Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: true
Hotel Name: Hilton Istanbul
Room Type: Single
Reservation Month: June
Reservation Start: 1
Reservation End: 11
Reservation ID: 1 is created!
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
1
ROOM INFOS:
Room Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: false
Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: false
Room Type: Club, Daily Cost: 250, Room Size: 45, Has Bath: true
Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: false
Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: true
Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: true
Hotel Name: Sheraton Bomonti Istanbul
Room Type: Club
Reservation Month: July
Reservation Start: 2
Reservation End: 22
Reservation ID: 2 is created!
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
2
Reservation for a Single room in Hilton Istanbul starts on June 1 and ends on
June 11. Reservation has a total cost of $2000.
Reservation for a Club room in Sheraton Bomonti Istanbul starts on July 2 and
ends on July 22. Reservation has a total cost of $10000.
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
3
Type a city name for a reservation search: Istanbul
Hilton Istanbul
Sheraton Bomonti Istanbul
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
5
The cost for the Room booking service of reservation ID 1: 2000.00
The cost for the Room booking service of reservation ID 2: 10000.00
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
4
Please select one of the extra services from below:
1. Laundry Service
2. Spa Service
1
Type the reservation ID to credit this service:
1
How many pieces of clothing?
10
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
5
The cost for the Room booking service of reservation ID 1: 2000.00
The cost for the Room booking service of reservation ID 2: 10000.00
The cost for the Laundry service of reservation ID 1: 200.00
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
4
Please select one of the extra services from below:
1. Laundry Service
2. Spa Service
2
Type the reservation ID to credit this service:
1
How many days?
2
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
4
Please select one of the extra services from below:
1. Laundry Service
2. Spa Service
1
Type the reservation ID to credit this service:
1
How many pieces of clothing?
3
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
5
The cost for the Room booking service of reservation ID 1: 2000.00
The cost for the Room booking service of reservation ID 2: 10000.00
The cost for the Laundry service of reservation ID 1: 200.00
The cost for the Spa service of reservation ID 1: 200.00
The cost for the Laundry service of reservation ID 1: 60.00
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
6
The total cost of all services of the reservation with ID: 1 is 2460.00
The total cost of all services of the reservation with ID: 2 is 10000.00
1. Create new Reservation with Room Type
2. Display all Reservations
3. List the reservations for a specific city
4. Add extra services to a reservation
5. Calculate total cost for each service
6. Display the total cost of every customer
7. Exit
7
Exiting, Goodbye!
