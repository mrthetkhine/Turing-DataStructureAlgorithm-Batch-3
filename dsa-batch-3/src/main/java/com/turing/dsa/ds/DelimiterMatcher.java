package com.turing.dsa.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class DelimiterMatcher {

	List<Character> opening = new ArrayList<>();
	List<Character> closing = new ArrayList<>();
	
	DelimiterMatcher()
	{
		this.opening.add('[');
		this.closing.add(']');
		
		this.opening.add('{');
		this.closing.add('}');
		
		this.opening.add('(');
		this.closing.add(')');
	}
	boolean isOpening(char ch)
	{
		return this.opening.contains(ch);
	}
	boolean isClosing(char ch)
	{
		return this.closing.contains(ch);
	}
	boolean isBalance(char opCh, char closeCh)
	{
		int opIndex = this.opening.indexOf(opCh);//
		int closingCh = this.closing.get(opIndex);
		return closingCh == closeCh;
	}
	//"cd]"->false
	public boolean match(String input) {
		if(input==null)
		{
			return true;
		}
		Stack stack = new Stack();
		for(int i=0; i< input.length();i++)
		{
			char ch = input.charAt(i);
			if(isOpening(ch))
			{
				stack.push(ch);
			}
			else if(isClosing(ch))
			{
				//System.out.println("Closing "+ch);
				if(stack.isEmpty())
				{
					//System.out.println("Stack empty "+ch);
					return false;
				}
				char opeingCh = (Character)stack.pop();
				if(!this.isBalance(opeingCh, ch))
				{
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
