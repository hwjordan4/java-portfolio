
public class quiz3 {

	public static void main(String[] args) {
		System.out.println(recMethod1("very good"));
		System.out.println(recMethod2(7,2));
		System.out.println(recMethod3(2,5));
	}
	public static String recMethod1(String str) {
	    if (str.length() <= 1)
	      return str;
	    else
	      return recMethod1(str.substring(1)) + str.charAt(0);
	  }
	
	public static int recMethod2(int x, int y) {
	    if (x == y)
	      return 0;
	    else
	      return 1 + recMethod2(x-1, y);
	  }
	public static long recMethod3(int x, int y) {
	    if (y == 0)
	      return 1;
	    else
	      return x * recMethod3(x, y-1);
	  }
}
