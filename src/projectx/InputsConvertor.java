package projectx;

import java.util.Stack;

public class InputsConvertor {
    private Stack<String> inputStack=new Stack<>();
    public  String[] postExpression;
    private Inputs in=new Inputs();
    private Stack<String> temporarilyStack = new Stack<>();
    
    public InputsConvertor(Stack st)
    {
       temporarilyStack.addAll(st);
    }
    
    private void Reverser()
    {
        
        int counter=0;

        while(!temporarilyStack.isEmpty())
        {inputStack.push(temporarilyStack.pop());counter++;}
        
        
         postExpression=new String[counter];

    }

    public String[] converter()
    {
  
        Reverser();
        int count=0;
        Stack<String> operationStack=new Stack<>();
        String temp;

        while(!inputStack.isEmpty())
        {
             
            temp=inputStack.pop();
            
              if(!"(".equals(temp) && !")".equals(temp) && !"~".equals(temp) &&!"^".equals(temp) &&!"+".equals(temp) )
               {
                   postExpression[count]=temp; count++;
               }
             
               else if("~".equals(temp)){operationStack.push(temp);}
               else if("(".equals(temp)){operationStack.push(temp);}

               else if("^".equals(temp))
               {
                   if(!operationStack.isEmpty())
                   {if("^".equals(operationStack.peek())){postExpression[count]=operationStack.pop();count++;}}
                   operationStack.push(temp); 
               }

               else if("+".equals(temp))
               {
                   if(operationStack.isEmpty()||operationStack.peek().equals("(" ))
                   {operationStack.push(temp);}
                   else
                   {
                    
                       while(!operationStack.isEmpty())
                       {
                         if(operationStack.peek().equals("("))break;
                          {postExpression[count]=operationStack.pop();count++; }
                       }

                       operationStack.push(temp);
                     
                   }

               }

               else if(")".equals(temp))
               {
                    while(true)
                    {
                    if("(".equals(operationStack.peek()))
                    {  
                        break;
                    }
                    {postExpression[count]=operationStack.pop();count++;  }
                    
                    }
                    
                     operationStack.pop(); 
                
               }

        }
        
        while(!operationStack.isEmpty())
        {
           postExpression[count]=operationStack.pop(); count++;
        }

        return postExpression;

    }
}
