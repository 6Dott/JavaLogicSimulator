package projectx;

import java.util.HashMap;

public class AnalizingInput 
{
 
    private String  firstOperand="",secondOperand=""; 
    private Op and  =new AND();
    private Op or   = new OR();
    private Not not =new Not();
    private Inputs input = new Inputs();   
    private InputsConvertor PE;
    private final  HashMap<String,Character> map;
   
public AnalizingInput()
{  
  map = input.mapGetter(); 
}
   private Boolean CTB(char character)
   {
        return ('1'==(character));
   }
   
    private String BTS(boolean bool)
   {
       if (bool==true)return "1";
        else return "0";
   }
 
    public void con() 
{

    for(int i=0;i<3;i++)
    {
       
        PE = new InputsConvertor(input.getter()[i]);
        Calculate(PE.converter());
      
    }
}      

    private void Calculate(String[] arrayOfPost)
   {

    String[] arrayOfString = arrayOfPost;

     int resultIndex=0;

        for (int i=0; i<arrayOfString.length ; i++)
        {
            if(arrayOfString[i] == null)break;
                 resultIndex = i;
               
            if(arrayOfString[i].equals("~"))
            {
                arrayOfString[i] = BTS(not.operation(CTB(map.get(arrayOfString[i-1]))));
                arrayOfString[i-1]="";
            }
                
            if (arrayOfString[i].equals("+")||arrayOfString[i].equals("^")||arrayOfString[i].equals("~"))
            {
                int counter = 1;
                
                int indexOne= 0;
                int indexTwo= 0;
                
                while("".equals(firstOperand))
                {
                    firstOperand=arrayOfString[i-counter];indexOne=i-counter;counter++;
                }
                while("".equals(secondOperand))
                {
                    secondOperand=arrayOfString[i-counter];indexTwo=i-counter;counter++;
                }
                if(arrayOfString[i].equals("+"))
                arrayOfString[i] = BTS(or.operation(CTB(map.get(firstOperand)),CTB(map.get(secondOperand))));
                else if(arrayOfString[i].equals("^"))
                arrayOfString[i]=BTS(and.operation(CTB(map.get(firstOperand)),CTB(map.get(secondOperand))));

               secondOperand = firstOperand="";
 
            arrayOfString[indexOne]="";
            arrayOfString[indexTwo]="";
              
            }
                
        }
        System.out.println("result is = "+ arrayOfString[resultIndex]);
}
    
}
