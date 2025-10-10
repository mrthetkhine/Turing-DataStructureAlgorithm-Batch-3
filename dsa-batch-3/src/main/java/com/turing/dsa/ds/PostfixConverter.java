package com.turing.dsa.ds;
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
	
	public boolean isOperator(char ch)
	{
		return ch=='+' || ch =='-' || ch=='*' || ch =='/';
	}
	public boolean isOperand(char ch)
	{
		return Character.isLetter(ch);
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
				stack.push(ch);
			}
		}
		while(!stack.isEmpty())
		{
			postfix+= stack.pop();
		}
		return postfix;
	}
}
