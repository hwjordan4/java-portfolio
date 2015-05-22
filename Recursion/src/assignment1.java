/*****************************************
 *  @author Harrison Jordan
 ****************************************/
/* Harrison Jordan
 * CS 3401
 * Assignment 1
 * 01/12/2015
 */
public class assignment1 {

	public static void main(String[] args) {
		String s = "KeNNesaW StaTE UniVERsitY";
		int index = s.length()-1;
		System.out.println(upperCaseCount(s, index));
		
		String binary = "";
		int decimal = 155;
		String result ="";
		System.out.print(decimalToBinary(decimal, result));
	}
	
	public static int upperCaseCount (String s, int index) 
	{
		assert (s != null);
		assert (s.length()>0);
		
		int count = 0;
		if(Character.isUpperCase(s.charAt(index)) && index == 0)
		{
			count++;
			return count;
		}
		else if(index == 0)
		{
			return count;
		}
		else
		{
			if(Character.isUpperCase(s.charAt(index)))
			{
				count = upperCaseCount(s, index-1) + 1;
			}
			else
			{
				count = upperCaseCount(s, index - 1);
			}	
		}
		return count;
	}
	
	public static String decimalToBinary (int n, String r)
	{
		
		
		assert(n>=0);
		if(n > 0)
			{
				decimalToBinary(n/2, r);
				r += ""+(n%2);
				
			}
		else
		{
			return "0";
		}
		
	return r;
		
	
	}

	
}
