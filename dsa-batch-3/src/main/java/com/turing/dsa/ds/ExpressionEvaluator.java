package com.turing.dsa.ds;

import java.util.HashMap;
import java.util.Stack;
public class ExpressionEvaluator {

	public int execute(String input, HashMap<Character, Integer> variables) {
		
		Stack expStack = new Stack();
		PostfixConverter converter = new PostfixConverter();
		String postFix = converter.transform(input);
		
		for(int i=0;i< postFix.length();i++)
		{
			char ch = postFix.charAt(i);
			if( converter.isOperand(ch))
			{
				int value = (int) variables.get(ch);
				expStack.push(value);
			}
			else if(converter.isOperator(ch))
			{
				int op2 = (int) expStack.pop();
				int op1 = (int) expStack.pop();
				
				switch(ch)
				{
					case '+':
						expStack.push(op1+op2);
					break;
					case '-':
						expStack.push(op1-op2);
					break;
					case '*':
						expStack.push(op1*op2);
					break;
					case '/':
						expStack.push(op1/op2);
					break;
				}
			}
		}
		return (int)expStack.pop();
	}

}
