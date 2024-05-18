package projectx;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Stack;

public class Inputs {
 
 public static final String filePath = "C:\\Users\\unknown\\Documents\\NetBeansProjects\\ProjectX\\src\\projectx\\Data.txt";    
 private final  File file =new File(filePath);
 private HashMap<String,Character> mapOfExpression = new HashMap<>();
 private Scanner input;
 private char val='$';
 private Stack<String> exepression = new Stack<>();
 private Stack[] stack;
 
 public void readerOfFile()
    {     
      try {
        input = new Scanner(file);
        
        int counter=0;
        String str;
        while (input.hasNext()) {
 
             str = input.nextLine();
             
            exepression.clear(); 

            String temp="";
            int pos=0;
            for(int i=0; i < str.length() ; i++)
            {
                if(str.charAt(i)==' ')continue; //skip spaces
            
                if(!(str.charAt(i)=='+'||str.charAt(i)=='^'|| str.charAt(i)=='(' ||str.charAt(i)==')' ||str.charAt(i)==',' ||str.charAt(i)=='~' ))
                    {temp+=str.charAt(i);}
                else if(str.charAt(i)==',') 
                    {if(!temp.equals(""))exepression.push(temp) ; temp="" ;pos =i;break;}
                else {if(!"".equals(temp))exepression.push(temp) ;temp="";temp+=str.charAt(i);exepression.push(temp);temp="";}
               
            }
            
            if(!temp.equals("")) exepression.push(temp);
            stack[counter]=(Stack)exepression.clone( );
            counter++;
            
            for(int i=pos;i<str.length();i++) 
            {
                
                if(str.charAt(i)==' ')
                    continue;
                if(str.charAt(i)==',')
                    continue;
                if(str.charAt(i)!='=')
                    temp+=str.charAt(i);
                else
                {
                        while(val=='$')
                        {  
                            if(!(str.charAt(i)==' '|| str.charAt(i)=='='))
                                {val=str.charAt(i);}
                            else ++i;
                        }
                    mapOfExpression.put(temp,val);
                    temp="";
                    val='$';
                }
                
            }
                
        }
        input.close();
    } 
    catch (FileNotFoundException Ex) {
        
        Ex.printStackTrace();
        
        System.out.println("path is wrong");
    }
   
    }//end of reader method
 
 Inputs()
 {
      
     stack = new Stack[LC()];
      
     readerOfFile();     
 }

 private int LC()
 {
     int count = 0;
    try
    {
        
       input = new Scanner(file);
       while (input.hasNext()) 
       {
           
           input.nextLine();
           count++;
           
       }
    } 
    catch (FileNotFoundException EX) 
    {
       
        EX.printStackTrace();
        
    }
    return count;                               
 }  

public Stack[] getter()
{
    return stack;
}

public HashMap<String,Character>  mapGetter()
{
    return mapOfExpression;
}

    public void fileReaderTest()
    {
      readerOfFile();
      System.out.println("...........");
      System.out.println(stack[0]);
      System.out.println(stack[1]);
      System.out.println(stack[2]);
      System.out.println("...........");
      
    }
    
public String analyzer()
{
    
    if(!exepression.isEmpty())
        return(exepression.pop());
    else return null;
    
}



}
