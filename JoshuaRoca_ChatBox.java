/** 
Joshua Roca
CSCI 1302 - Computer Science II
Section 1
Dr. Ken Nguyen
HW Assignment #6 
Algorithm: I will be programming a mock, online 
discussion forum that can read from and write
to a file that serves as the "forum". Each 
message has a unique Message Id, a Parent Id,
and the body of the message. The "Parent Id"
serves as a pointer to the Message Id that 
is being replied to, and the first message
in a discussion will have a Parent Id of "-1".
All messages will be stored in the 'msg.data'
file in the following format:
"messageID|parentID|text". 
I will (copied from the assignment instructions
because I will be doing all of it): 
1) Implement an appropriate class to excapsulate
the messages.
2) Create an application where the messages are
loaded from a file (msg.data) and displayed in
a Nesting Heirarchy Structure that shows the 
relationship of the messages to each other with
respective spaces.
3) I will also provide an option for the user to 
create their own discussion and reply to a message.
The added information will be added back to the file,
I will use a RandomAccessFile for maximum ease of use. 
*/

import java.util.*;
import java.io.*;

public class JoshuaRoca_HW6 {
   public static void main(String[] args) throws Exception{
      Scanner in = new Scanner(System.in, "UTF-8");
      RandomAccessFile myFile = new RandomAccessFile(new File("msg.data"), "rw");
      int acc = 0; //Accumulator needed to find String array length.
      while(myFile.readLine() != null){ //Read through the file, count the lines.
         acc++;
      }
      String[] lines = new String[acc]; //Create String array with returned int.
      myFile.seek(0); //Reset file pointer to beginning for actual reading.
      for(int i = 0; i < acc; i++){
         lines[i] = myFile.readLine(); //"Actual reading" 
         //System.out.println(lines[i]); //Test if it worked.
      }
      displayConvo(lines, "-1", 0);
      
      //Bonus Section
      boolean done = false;
      do{
         System.out.println("Would you like to add to the forum?" + 
                           "(true/false)");
         boolean next = in.nextBoolean();         
         if(next == true){
            myFile.seek(myFile.length());
            System.out.println("Type your message in Correct Format");
            System.out.println("Make sure to only use underscores" +
                              "and no spaces");
            myFile.writeUTF("\n" + in.next());
         }else{
            done = true;
         }
      }while(done != true);
         
      System.out.println("Have a good Day!");  
      
   }//End Main
   
   /** 
   This method is used to properly display the discussion in the 
   Nesting Heirarchy fashion.
   @param lines - the array of Strings that holds each line in the file.
   @param id - this is the parentId of the first message intended on being 
   displayed, this parameter is crucial in the recursion process.
   @param spaces - this parameter is also crucial for the recursion,
   it allows the code to adjust it's indetation for each reply.  
   */  
   private static void displayConvo(String[] lines, String id, int spaces){
      for(int i = 0; i < lines.length; i++){ //Go through every line in array
         //Split each line into more usable Strings
         String mID = lines[i].substring(0,2);
         String pID = lines[i].substring(3,5);
         String text = lines[i].substring(6);
         if(id.equals(pID)){ //If "there are replies to lines[i]"
            for (int j = 0; j < spaces; j++) 
               System.out.print("-"); //Indent or "nest" the replies
            System.out.println(mID + ":" + text); //Fancy look                                                                      
            displayConvo(lines, mID, (spaces + 2)); //Recursion 
            
        }
      }
   }
  
   
}//End Class
