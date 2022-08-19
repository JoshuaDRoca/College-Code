/** Simple Calculator Project
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   To Do: Write a program that simulates a calculator.
   
   Steps: 
   1) Introduce the user with an understanding of the program.
   2) Ask the user if they would like to calculate something.
   3) Begin a while loop so you can keep using the calculator
      without ending and restarting the program.
   4) In the loop, prompt user for 1st number, 2nd number
      and operation respectively.
   5) Present the answer as it would on a calculator.
      
   What to turn in:
   1) The Java source code - using submission checklist.
   2) A screen capture of the code executing correctly. 
   3) A printout of the formatted code in-person.
   
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   Examples:
   
   1) Input:
      12
      /
      4
      
      Output:
      12 / 4 = 3
      
   2) Input:
      3
      *
      5
      
      Output:
      3 * 5 = 15  
      
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

*/

import java.util.Scanner;

/**
@author Joshua Roca
@version 1.0
Dr. Ken Nguyen
CSCI 2302
P1: Fundemental Programming Language Review
*/
public class JoshRoca_SimpleCalculator {
   public static void main(String[] args){
   
      //Initializing the scanner.
      Scanner in = new Scanner(System.in); 
      
      //Necessary variables for later.
      double first = 0;
      double second = 0;
      String op = "";
      double ans = 0;
      boolean cont;
      
      //User stuff to feel fancy.
      System.out.println("Welcome to the Java Calculator!");
      
      //begin the looping
      do {
         //giving instructions to user
         System.out.println("Enter the 1st number, operator, then 2nd number"
                             + "\nin that order.");
                             
         //capturing the stuff.
         first = in.nextDouble();
         op = in.next();
         second = in.nextDouble();
         
         //Figuring out the operation to use.
         if(op.equals("+")) 
         {
            ans = first + second;
            
         } else if(op.equals("-")) {
         
            ans = first - second;
            
         } else if(op.equals("*")) {
            
            ans = first * second;
            
         } else if(op.equals("/")) {
            ans = first / second;
         }
         
         //output the final result
         System.out.println(first + " " + op + " " + second + " = " + ans + "\n");
         
         //ask if user would like to continue.
         System.out.println("Would you like to perform another operation? " +
                         "true or false" );
         cont = in.nextBoolean(); //Determines if the loop loops or not.
      }while(cont);
      
      System.out.println("Have a Good Day!");
   }
}