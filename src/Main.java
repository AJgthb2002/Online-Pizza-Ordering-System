import java.util.*;

public class Main{
    public static void main(String[] args)
    {
        PizzaHut ph= new PizzaHut();                       // create object of PizzaHut class
        Scanner sc= new Scanner(System.in);
        int choice=0;

        // add all the available pizzas to menu
        ph.accept_menu("Peppy Paneer",595, 395, 215, 15);
        ph.accept_menu("Indi Tandoori Paneer",695,400,235,14);
        ph.accept_menu("Farmhouse",700,495,315, 14);
        ph.accept_menu("Margherita",535,335,185, 10);
        ph.accept_menu("Mexican Green Wave",570,370,200, 20);
        ph.accept_menu("Veggie Paradise ",595,395,215, 13);
        ph.accept_menu("Chicken Paradise",695,400,235, 15);
        ph.accept_menu("Pasta Pizza",595,395,215,20);
        ph.accept_menu("Chicken Sausage",715,415,250, 12);
        ph.accept_menu("Chicken Barbeque",735,435,275, 20);

        // add registered customers
        ph.accept_customer("Ananya", "B3- Silver Township, Aundh",2, "8983282880");
        ph.accept_customer("Esha", "401, KB Society, Baner",3, "7517362175");
        ph.accept_customer("Prerana", "22, Greenland County, Deccan Gymkhana",5, "8345267906");
        
        int main_choice_mismatch=0;
        do
        {
            ph.clearScreen();
            System.out.println("\n\t\t\t\t\t"+ph.pizza_hut_logo+"\n");  // print shop logo
            
            // Display options to customer
            main_choice_mismatch=0;
            try
            {
                System.out.print("\n\t\t\t\t\tWhat would you like to do? \n\t\t\t\t\t1. Place an order\n\t\t\t\t\t2. View menu card\n\t\t\t\t\t3. Exit\n\t\t\t\t");
                choice= sc.nextInt();
            }
            catch(InputMismatchException e)  // catch invalid input
            {
                sc.next();
                System.out.print("\n\t\t\t\tIncorrect choice! Please enter again!");
                main_choice_mismatch=1;
            }

            switch(choice)
            {
                case 1: ph.clearScreen();
                        ph.take_order();
                        break;
                case 2: ph.clearScreen();
                        ph.display_menu();
                        System.out.print("\n\n\t\t\t\t\t(Enter 0 to return to main menu) ");
                        sc.nextInt();
                        break;
                case 3: break;
                default: System.out.println("\n\t\t\t\t\tInvalid choice! Please enter again.");
            }
        }while(main_choice_mismatch==1 || choice!=3);

    }
}