# Online Pizza Ordering System
```
 ___                             _   _         _     
(  _`\  _                       ( ) ( )       ( )_  
| |_) )(_) ____  ____    _ _    | |_| | _   _ | ,_)  
| ,__/'| |(_  ,)(_  ,) /'_` )   |  _  |( ) ( )| |    
| |    | | /'/_  /'/_ ( (_| |   | | | || (_) || |_   
(_)    (_)(____)(____)`\__,_)   (_) (_)`\___/'`\__)) 
```
This is a group project for the course Data Structures and Algorithms 2 Laboratory (CE 2201). </br>
Aim of the project is to develop an online facility for customers to order pizzas from a pizza shop. </br>
Programming language used: **Java** </br>
Data Structures used: **Graph, Hashmap, Set, ArrayList** </br>
Algorithms used: **Dijkstra's Shortest path algorithm**  </br>
***
### Overview of Project
- A customer can **view the menu** card, select the pizzas of his choice and **place an order** for home delivery.
- While placing the order, a customer needs to enter **personal details** and the **delivery location**.
- If the mobile number of a customer is **already registered** with the shop, all the details are **automatically fetched**. Customer has an option of using the same registered address or entering a new one.
- Our system finds the **shortest path** to the customer’s location and saves this shortest distance.
- The **estimated delivery time** and **delivery charges** are calculated on the basis of the shortest distance and displayed to the customer.
- Delivery charges are added to the cost of ordered pizzas and the **total bill amount** is displayed.
- Customer can **confirm** his order and pay the bill amount or can **cancel** the current order.
***
#### Delivery Locations Graph:
![Alt text](/Delivery_loc_graph.png)

***
#### Future improvements in the project:
1. File handling: Storing and fetching customer data from a file.
2. Adding more pizza shops and expanding delivery locations.
3. Offering discount coupons to the returning customers.
4. Taking customer feedback and ratings for each pizza.
5. Displaying statistics such as:
    - Most ordered veg pizza
    - Most ordered non-veg pizza
    - Location-wise top favorite pizzas
6. Displaying the previous order of customer and option to repeat the same order.
7. Option of deleting a pizza from order.

