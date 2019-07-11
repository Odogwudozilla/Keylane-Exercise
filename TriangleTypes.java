import java.util.*;
 
/**
 * This program tells you the type of triangle given the 3 sides.
 * @author = Chidozie Nnachor
 */
public class TriangleTypes {
	
	 static Scanner userin = new Scanner(System.in); //define the method for getting user input
	 
	 
	 //Define the error/exception method
       static void tryError() {
       	 while (!userin.hasNextFloat()) {
             System.out.println("You have entered invalid data. Ensure entered data is a number");
             userin.next();  
            }
       }
      
     
    public static void main(String[] args) {
    	
    	int getUserChoice = 1; //set loop to 1
    	while(getUserChoice != 0)
   	 {
    	double ab, bc, ca; //declare the variables for the triangle sides
    	List<Double> theSides = new ArrayList<>(); //declare an array
    	 
    	
    	System.out.println("This program collects three inputs (representing 'sides') from the user and then determines the type of triangle, given those sides. Remember, for a triangle to be valid, the sum of any 2 sides will always be greater than the third side. Let's begin...");
    //Get user input and check for errors/exception
    	 System.out.println("Enter a Value for Side A of triangle:");
    	 tryError(); //call the error method
         ab = Math.abs(userin.nextDouble()); //set absolute value of user input to variable.
         theSides.add(ab);  //append value to array
         
         System.out.println("Enter a Value for Side B of triangle:");
         tryError();
         bc = Math.abs(userin.nextDouble());
         theSides.add(bc);
          
         System.out.println("Enter a Value for Side C of triangle:");
         tryError();
         ca = Math.abs(userin.nextDouble());
         theSides.add(ca);
       
     //Output array values to console
         System.out.println("The Sides of the triangle are:");
         theSides.forEach(System.out::println);
         
     /**Function that:
      * Checks if the triangle is valid
      * Outputs the type of triangle
      */
         TriangleTypes at   = new TriangleTypes();
         if(at.isTriangleValid(ab, bc, ca)) {
        //check for "Equilateral"
         	if (ab == bc && ab == ca) { 
             	System.out.println("Your Triangle is Equilateral");
        //check for "Isosceles"
             }else if ((ab == bc && ab != ca) || (ab == ca && ab != bc) || (bc == ca && bc != ab)) {
             	System.out.println("Your Triangle is Isosceles");
        //If the two above don't hold, then "Scalene" must be true 
             }else{
             	System.out.println("Your Triangle is Scalene");
         }
         	}
         else {
             System.out.println("Sides entered cannot form a triangle. Try again!");

         }
         System.out.println( "Do you want to try again?(1 = YES, 0 =NO)" );
         tryError();
         getUserChoice = userin.nextInt();
    	 }
           if(getUserChoice == 0) {
        	   System.out.println("Bye...");
           }else {
        	   System.out.println("Restarting...");
        	   
           }
    }
       
    
    /**
     * The private method below checks if the 3 sides can form a valid triangle
     * The condition is that sum of any two sides must be greater than the third side
     */
    private boolean isTriangleValid(double ab, double bc, double ca) {
        if((ab+bc)>ca && (ab+ca)>bc && (bc+ca)>ab) {
            return true;
        }else {
            return false;
        }
    }
}