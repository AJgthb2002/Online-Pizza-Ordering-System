import java.util.*;

class PizzaHut
{
    ArrayList<Pizza> menu;         // Array list which contains all available pizzas

    // hashtable of customer details, where a unique mobile number is mapped to a customer
    HashMap<String, customer> customer_data = new HashMap<>();

    String delivery_locations;   // string for printing all delivery locations

// message to print when order is confirmed
String confirm_order_msg= String.join("\n\t\t\t\t\t",
                               "                                //''---.._         ",
                               "Thank you for your order!       ||  (_)  _ '-._    ",
                               "Your Pizzas are on the way!     ||    _ (_)    '-. ",
                               "                                ||   (_)   __..-'  ",
                               "                                \\\\__..--''        ");

// logo of the pizza shop
String pizza_hut_logo= String.join("\n\t\t\t\t\t",
" ___                             _   _         _     ",
"(  _`\\  _                       ( ) ( )       ( )_  ",
"| |_) )(_) ____  ____    _ _    | |_| | _   _ | ,_)  ",
"| ,__/'| |(_  ,)(_  ,) /'_` )   |  _  |( ) ( )| |    ",
"| |    | | /'/_  /'/_ ( (_| |   | | | || (_) || |_   ",
"(_)    (_)(____)(____)`\\__,_)   (_) (_)`\\___/'`\\__)) ");

public PizzaHut()      // constructor
{
  menu= new ArrayList<Pizza>();
  delivery_locations= "\n\t\t\t\t1.Kothrud\n\t\t\t\t2. Aundh\n\t\t\t\t3.Baner\n\t\t\t\t4.Camp\n\t\t\t\t5.Deccan Gymkhana\n\t\t\t\t6.Kalyani Nagar\n\t\t\t\t7.Koregaon Park\n\t\t\t\t8.Sinhagad Road\n\t\t\t\t9.Swargate\n\t\t\t\t10.Warje";
}

public void accept_customer(String name, String addr, int location, String mobile)
{
    // creates a new customer object with the details passed in as arguments and adds this new customer to the
    // registered customer data.
    customer new_customer= new customer(name, addr,location, mobile);  // create new customer object
    customer_data.put(mobile,new_customer); // add customer to hash map
}

public void accept_menu(String name, int cl, int cm, int cs, int time)
{
    // creates a new pizza object with the details passed in as arguments and adds this new pizza to the menu
    Pizza new_pizza = new Pizza(name, cl,cm,cs,time);  // create a new pizza object
    menu.add(new_pizza);       // add pizza to arraylist
}

public void clearScreen() // improves the appearance of output for a better user experience
{   System.out.print("\033[H\033[2J"); 
    System.out.flush(); 
}

public void display_menu() // display menu card in tabular form
{
        System.out.println("\t\t\t\t\t _____________________________________________________");
	    System.out.println("\t\t\t\t\t|                                                     |");
	    System.out.println("\t\t\t\t\t|\t\t  PIZZA HUT MENU                      |");
	    System.out.println("\t\t\t\t\t|                                                     |");
	    System.out.println("\t\t\t\t\t|_____________________________________________________|");
	    System.out.println("\t\t\t\t\t|                                                     |");
	    System.out.println("\t\t\t\t\t| NO. \tNAMES\t\t\t\tPRICES        |");
	    System.out.println("\t\t\t\t\t|_____________________________________________________|");
	    System.out.println("\t\t\t\t\t|                                                     |");
	    System.out.println("\t\t\t\t\t|      \t\t\t\tSMALL\tMEDIUM\tLARGE |");
	    System.out.println("\t\t\t\t\t|                                                     |");
	    System.out.println("\t\t\t\t\t|  1. Peppy Paneer\t\t 215 \t 395   \t 595  |");
	    System.out.println("\t\t\t\t\t|  2. Indi Tandoori Paneer\t 235 \t 400   \t 695  |");
	    System.out.println("\t\t\t\t\t|  3. Farmhouse     \t\t 315 \t 495   \t 700  |");
	    System.out.println("\t\t\t\t\t|  4. Margherita     \t\t 185 \t 335   \t 535  |");
	    System.out.println("\t\t\t\t\t|  5. Mexican Green wave   \t 200 \t 370   \t 570  |");
	    System.out.println("\t\t\t\t\t|  6. Veggie Paradise    \t 215 \t 395   \t 595  |");
	    System.out.println("\t\t\t\t\t|  7. Chicken Paradise   \t 235 \t 400   \t 695  |");
	    System.out.println("\t\t\t\t\t|  8. Pasta Pizza\t\t 215 \t 395   \t 595  |");
	    System.out.println("\t\t\t\t\t|  9. Chicken Sausage  \t\t 250 \t 415   \t 715  |");
	    System.out.println("\t\t\t\t\t| 10. Chicken Barbeque \t\t 275 \t 435   \t 735  |");
	    System.out.println("\t\t\t\t\t|_____________________________________________________|");

}

private boolean validate_mobile(String mobile_no) // checks whether the entered mobile number is correct
{
    // check if length of input is 10 digits
    if(mobile_no.length()!=10)
        return false;
    else
    {
        // check whether any character other than digits 0-9 is present in input
        for(int i=0; i<mobile_no.length();i++)
        {
            if (mobile_no.charAt(i)<48 || mobile_no.charAt(i)>57)
                return false;
        }
    }
    return true;    
}

public void take_order() 
{
    Scanner sc= new Scanner(System.in);
    
    int customer_loc=0;           // initialize customer location to 0
    String name, addr,mobile;     

    do{
    System.out.print("\n\t\t\t\tEnter mobile number : ");      // input mobile number
    mobile = sc.next();
    if(!validate_mobile(mobile))           // ask for mobile number again if the input is not correct
        System.out.println("\n\t\t\t\tPlease enter a valid mobile number! ");
    }while(validate_mobile(mobile)==false);  // repeat the loop until a valid mobile number is entered
    

    if(customer_data.containsKey(mobile))                       // customer details are already registered
    {
        customer cust = customer_data.get(mobile);  // get the customer object from mobile number

        // set the name and address variables according to the saved details of customer
        name= cust.name;                        
        addr= cust.address;

        // print the registered details
        System.out.println("\n\t\t\t\tMobile no. "+mobile+" is registered with us!");
        System.out.println("\n\t\t\t\tName: "+name+"\n\t\t\t\tAddress: "+addr);

        // ask the user whether he wants to use the same registered address for delivery
        int addr_choice=0;
        int choice_mismatch=0;
        do
        {
            choice_mismatch=0;
            try
            {
                System.out.print("\n\n\t\t\t1. Deliver to the registered address?   OR    2. Enter a new address? ");
                addr_choice= sc.nextInt();
            }
            catch(InputMismatchException e)
            {
                sc.next(); // to clear buffer
                System.out.print("\n\t\t\t\tInvalid choice! Please enter again!");
                choice_mismatch=1;
            }
            if(choice_mismatch==0)
            {   if(addr_choice<1 || addr_choice>2)
                System.out.println("\n\t\t\t\tInvalid choice! Please enter again.");
            }
        }while(choice_mismatch==1 || addr_choice<1 || addr_choice>2);
        

        if(addr_choice==1)         // user wants to keep the same registered address
            customer_loc=cust.location;
        else if(addr_choice==2)   // user wants to enter a new address
        {   clearScreen();
            // show the available delivery locations
            System.out.println("\n\t\t\t\tWe currently deliver to the following locations: ");
            System.out.println(delivery_locations);
            int location_mismatch=0;
            do{
                location_mismatch=0;
                try
                {
                    System.out.print("\n\t\t\t\tChoose your location: ");
                    customer_loc= sc.nextInt();
                }
                catch(InputMismatchException e)
                {
                    sc.next(); // clear buffer
                    System.out.println("Invalid location! Please choose a location again.");
                    location_mismatch=1;
                }
                if(location_mismatch==0)
                {
                    // check if the entered location code is within range 1 to 10
                    if(customer_loc >10 || customer_loc<1)  
                        System.out.println("\n\t\t\t\tSorry! Enter your location again");
                }
                
            }while(location_mismatch==1 || customer_loc >10 || customer_loc<1); // repeat loop until a valid location is entered

            System.out.print("\n\t\t\t\tEnter your address: ");  // input the address (house no, building name)
            sc.nextLine(); // to clear input buffer
            addr= sc.nextLine();
        } 
        cust.location= customer_loc;
        cust.address= addr;
    }
    else  // new i.e. non registered customer
    {   clearScreen();
        // show the available delivery locations
        System.out.println("\n\t\t\t\tWe currently deliver to the following locations: ");
        System.out.println(delivery_locations);
        int location_mismatch=0;
            do{
                location_mismatch=0;
                try
                {
                    System.out.print("\n\t\t\t\tChoose your location: ");
                    customer_loc= sc.nextInt();
                }
                catch(InputMismatchException e)
                {
                    sc.next(); // clear buffer
                    System.out.print("\n\n\t\t\t\tInvalid location! Please choose a location again.");
                    location_mismatch=1;
                }
                if(location_mismatch==0)
                {
                    // check if the entered location code is within range 1 to 10
                    if(customer_loc >10 || customer_loc<1)  
                        System.out.println("\n\t\t\t\tSorry! Enter your location again");
                }
                
            }while(location_mismatch==1 || customer_loc >10 || customer_loc<1); // repeat loop until a valid location is entered

        sc.nextLine(); // to clear input buffer
        clearScreen();
        do{
            System.out.print("\n\t\t\t\tEnter your name: ");
            name= sc.nextLine();
            if(name.length()==0)  // check whether the input length is 0
                System.out.print("\n\t\t\t\tPlease enter your name again!");
        }while(name.length()<1);  // repeat loop until a valid name is entered
        
        do{
            System.out.print("\n\t\t\t\tEnter your address: ");
            addr= sc.nextLine();
            if(name.length()==0)  // check whether the input length is 0
                System.out.print("\n\t\t\t\tPlease enter your address again!");
        }while(name.length()<1);  // repeat loop until a valid address is entered
      
        accept_customer(name, addr, customer_loc, mobile); // add new customer details in the hashmap
    }
    
    
    int more=0;
    // arraylist to store the choice codes of ordered pizzas
    ArrayList<Integer> pizza_choice= new ArrayList<Integer>();  
    // arraylist to store the sizes of ordered pizzas 
    ArrayList<Character> size_choice= new ArrayList<Character>();
    // arraylist to store the quantities of ordered pizzas 
    ArrayList<Integer> quantities= new ArrayList<Integer>();

    do{
        clearScreen();
        display_menu();  // show menu card

        int pizza_choice_temp=1;
        int pizza_choice_mismatch=0;
        do{
            pizza_choice_mismatch=0;
            try
            {
                System.out.print("\n\t\t\t\tChoose your pizza: ");
	            pizza_choice_temp= sc.nextInt();
            }
	        catch(InputMismatchException e)
            {
                sc.next(); // to clear buffer
                System.out.print("\n\t\t\t\tInvalid choice! Please enter again!");
                pizza_choice_mismatch=1;
            }
            if(pizza_choice_mismatch==0)
            {
                // check whether pizza choice code is within range 1 to 10
	            if(pizza_choice_temp < 1 || pizza_choice_temp > 10) 
                    System.out.println("\n\t\t\t\tPlease enter a valid choice!");
            }
            
        }while(pizza_choice_mismatch==1 || pizza_choice_temp < 1 || pizza_choice_temp > 10);  // repeat loop until valid pizza choice code is entered
        
        pizza_choice.add(pizza_choice_temp); // add selected pizza code to arraylist
        
        char size_choice_temp;
        do{
        	 System.out.print("\n\t\t\t\tPick a size: (S/M/L) ");
             size_choice_temp= sc.next().charAt(0);
             
	        // check whether pizza is entered correctly
	        if(size_choice_temp != 'S' && size_choice_temp != 's' && size_choice_temp != 'M'&& size_choice_temp != 'm' && size_choice_temp != 'L'&& size_choice_temp != 'l')
	        	System.out.println("\n\t\t\t\tInvalid pizza size! Please Enter size again. (S/M/L)");
	     // repeat loop until a valid size is entered   
        }while(size_choice_temp != 'S' && size_choice_temp != 's' && size_choice_temp != 'M'&& size_choice_temp != 'm' && size_choice_temp != 'L'&& size_choice_temp != 'l');

        size_choice.add(size_choice_temp); // add selected pizza size to arraylist

        int qty_temp=1;
        int mismatch_flag=0;
        do{
            mismatch_flag=0;
            try
            {
                System.out.print("\n\t\t\t\tEnter quantity: ");
                qty_temp= sc.nextInt();
            }
        	catch(InputMismatchException e)
            {
                sc.next(); // to clear buffer
                System.out.print("\n\t\t\t\tInvalid quantity! Please enter again!");
                mismatch_flag=1;
            }
            if(mismatch_flag==0)
            {
                // check whether at least one quantity is entered
	            if(qty_temp < 1)
                    System.out.println("\n\t\t\t\tOrder at least one pizza of selected type!");  
                // check whether entered quantity is less than limit
                if(qty_temp > 10)
                    System.out.println("\n\t\t\t\tYou can order a maximum of 10 pizzas at a time!");  
            }
	           
        }while(mismatch_flag==1 || qty_temp < 1 || qty_temp>10);  // repeat the loop if quantity entered is less than 1

        quantities.add(qty_temp); // add selected quantity to arraylist

        // ask user if he wants to order more pizzas
        System.out.print("\n\t\t\t\tDo you want to order more Pizzas? (1=yes, 0=no) ");
        more= sc.nextInt();
    }while(more!=0);
    
    // send the array lists containing order details to print_bill function
    print_bill(customer_loc, pizza_choice, size_choice, quantities);

}

void print_bill(int customer_loc, ArrayList<Integer> pizza_choice, ArrayList<Character> sizes, ArrayList<Integer> qty)
{
    Scanner sc= new Scanner(System.in);

    int per_km_charge= 10;          // delivery charge per km
    int per_km_time=2;              // delivery time per km

    // calculate the shortest distance to customer's location
    double distance= shortest_dist(customer_loc);

    clearScreen();

    double delivery_charge= distance*per_km_charge;  // calculate delivery charges
    
    double estimated_time=(per_km_time*distance);   // calculate estimated time for delivery

    double total_bill= delivery_charge;             // add delivery charges to bill amount

    String nm=""; // a string to store ordered pizza names
    for(int i=0; i<pizza_choice.size(); i++) // iterate through the ordered pizzas list
    {
        // get the corresponding pizza object from the pizza code
        Pizza selected = menu.get(pizza_choice.get(i)-1);

        // add baking time for the pizza to the estimated time
        estimated_time+= selected.time_reqd*qty.get(i);

        // add pizza cost to the total bill according to size selected
        switch(sizes.get(i))
      {
        case 's':
        case 'S': total_bill+= selected.cost_S * qty.get(i);
                  break;
        case 'm':          
        case 'M': total_bill+= selected.cost_M * qty.get(i);   
                  break; 
        case 'l':          
        case 'L': total_bill+= selected.cost_L* qty.get(i);
                  break;                 
      }
       // add the ordered pizza name to string 
      nm= nm.concat("\n\t\t\t\t\t            "+(i+1)+") "+selected.name+"                ");

    }
    // display the bill

        System.out.println("\t\t\t\t\t____________________________________________________");
	    System.out.println("\t\t\t\t\t                                                    ");
	    System.out.println("\t\t\t\t\t                  PIZZA HUT BILL                    ");
	    System.out.println("\t\t\t\t\t                                                    ");
	    System.out.println("\t\t\t\t\t____________________________________________________");
	    System.out.println("\t\t\t\t\t                                                    ");
	    System.out.println("\t\t\t\t\t           Name the of pizzas ordered: "+nm+          "");
	    System.out.println("\t\t\t\t\t____________________________________________________");
	    System.out.println("\t\t\t\t\t                                                    ");
	    System.out.println("\t\t\t\t\t           Quantity of pizzas ordered= "+qty+         "");
	    System.out.println("\t\t\t\t\t____________________________________________________");
	    System.out.println("\t\t\t\t\t                                                    ");
	    System.out.println("\t\t\t\t\t           Distance calculated= " + distance + " km     ");
	    System.out.println("\t\t\t\t\t____________________________________________________");
	    System.out.println("\t\t\t\t\t                                                    ");
	    System.out.println("\t\t\t\t\t           Delivery Charge= Rs." + delivery_charge + "");
	    System.out.println("\t\t\t\t\t____________________________________________________");
	    System.out.println("\t\t\t\t\t                                                    ");
	    System.out.println("\t\t\t\t\t           Total bill amount= Rs." + total_bill  +   "");
	    System.out.println("\t\t\t\t\t____________________________________________________");
	    System.out.println("\t\t\t\t\t                                                    ");
	    System.out.println("\t\t\t\t\t              THANK YOU FOR ORDERING!               ");
	    System.out.println("\t\t\t\t\t____________________________________________________");
   
    // ask for confirmation of the order
    System.out.print("\n\n\t\t\t\t\tDo you want to 1. Confirm or 2. Cancel your order? ");
    int confirmation = sc.nextInt();

    if (confirmation==1) // user confirms his order
    {
        System.out.print("\n\n\t\t\t\t\t"+confirm_order_msg+"\n\n"); // print confirmation message
        System.out.print("\n\n\t\t\t\t\t(Press 0 to return to main menu)");
        sc.nextInt();
    }
    else // user cancels his order
    {
        System.out.println("\n\n\t\t\t\t\tThank you for visiting! We hope you order next time!\n\n");
        System.out.println("\n\n\t\t\t\t\t(Press 0 to return to main menu) ");
        sc.nextInt();
    }
    
}

double shortest_dist(int customer_loc)
{
    int inf = Integer.MAX_VALUE;  // set the value for infinity
    
    // graph represented using adjacency matrix
    double[][] adjMat = {
        
        { 0   ,inf , 10.5 , inf , 6.3 , inf, inf, inf, inf, 8.1 },    //1 Kothrud : PizzaHut
        { inf , 0  , 5    , inf , inf , 5  , inf, inf, inf, inf},	  //2 Aundh
        { 10.5, 5  , 0    , inf , inf , 4  , inf, inf, inf, inf},	  //3 Baner	
        {inf  , inf, inf  , 0   , 3.2 , inf, 9  , inf, 4.3, inf},     //4 camp
        { 6.3 , inf, inf  , 3.2 , 0   , 6.1, inf, inf, 6.8, 7.4},     //5 deccan gymkhana
        { inf , 5  , 4    , inf , 6.1 , 0  , 4.7, inf, inf, inf},     //6 kalyani nagar
        { inf , inf, inf  , 6   , inf , 4.7, 0  , inf, inf, inf},     //7 koregaon park
        { inf , inf, inf  , inf , inf , inf, inf, 0  , 5.6, 2.8},     //8 sinhagad road
        { inf , inf, inf  , 4.3 , 6.8 , inf, inf, 5.6, 0  , inf},     //9 swargate
        { 8.1 , inf, inf  , inf , 7.4 , inf, inf, 2.8, inf, 0}        //10 warje
        }; 
    
    // create object of class Dijkstras_shortest_path    
    Dijkstras_Shortest_Path dijkstrasAlgorithm = new Dijkstras_Shortest_Path(10);
    // call dijkstra_algorithm function with adj matrix as parameter
    dijkstrasAlgorithm.dijkstra_algorithm(adjMat);  
    
    // traverse over the distances array and find min distance to the customer's location
    for (int i = 0; i < dijkstrasAlgorithm.distances.length - 1; i++)
    {
        if (i == customer_loc-1)
            return dijkstrasAlgorithm.distances[i];
    }
  // if there is no path from source to customer location, return infinity  
 return inf;
}

}
