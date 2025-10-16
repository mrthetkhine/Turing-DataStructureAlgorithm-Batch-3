package com.turing.dsa.ds;
import java.util.HashMap;
import java.util.Stack;
/*
 * 	while there are more symbols to be read
		read the next symbol
			case:
			operand --> output it.
			’(’     --> push it on the stack.
			’)’     --> pop operators from the stack to the output
						until a ’(’ is popped; do not output either
						of the parentheses.
			operator --> pop higher- or equal-precedence operators
						from the stack to the output; stop before
						popping a lower-precedence operator or
						a ’(’. Push the operator on the stack.
			end case
	end while
	pop the remaining operators from the stack to the output
 * */
public class PostfixConverter {
	
	HashMap<Character,Integer> precedence = new HashMap<>();
	
	PostfixConverter()
	{
		this.precedence.put('+',1);
		this.precedence.put('-',1);
		this.precedence.put('*',2);
		this.precedence.put('/',2);
	}
	public boolean isOperator(char ch)
	{
		return ch=='+' || ch =='-' || ch=='*' || ch =='/';
	}
	public boolean isOperand(char ch)
	{
		return Character.isLetter(ch);
	}
	public boolean isHigherOrEqualPrcedence(char opOne, char opTwo)
	{
		int p1 = this.precedence.get(opOne);
		int p2 = this.precedence.get(opTwo);
		
		return p1 >= p2;
	}
	public String transform(String infix)
	{
		if(infix == null || infix.isEmpty())
		{
			return infix;
		}
		Stack stack = new Stack();
		String postfix = "";
		for(int i=0;i< infix.length();i++)
		{
			char ch = infix.charAt(i);
			if(this.isOperand(ch))
			{
				postfix += ch;
			}
			else if(this.isOperator(ch))
			{
				if(stack.isEmpty())
				{
					stack.push(ch);
				}
				else
				{
					/* 
					    operator --> pop higher- or equal-precedence operators
						from the stack to the output; stop before
						popping a lower-precedence operator or
						a ’(’. Push the operator on the stack.
					 * */
					while(!stack.isEmpty())
					{
						char opOne = (Character)stack.peek();
						if(opOne=='(')
						{
							break;
						}
						else if(this.isOperator(opOne) && this.isHigherOrEqualPrcedence(opOne, ch))
						{
							postfix += stack.pop();
							
						}
						else if(this.isOperator(opOne))
						{
							break;
						}
					}
					stack.push(ch);
				}
				
				
			}
			else if(ch =='(')
			{
				stack.push('(');
			}
			else if(ch==')')
			{
				while( (char)stack.peek() !='(')
				{
					postfix += stack.pop();
				}
				stack.pop();//pop '('
			}
		}
		while(!stack.isEmpty())
		{
			postfix+= stack.pop();
		}
		return postfix;
	}
}
