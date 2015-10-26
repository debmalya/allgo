/**
 * 
 */
package deb.codefights;

/**
 * @author debmalyajash
 *
 */
public class Clock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 /**
	   * Tony loved to watch his digital clock. He spent his days counting the
	   * number of times each digit occurred on the clock. Eventually it bored him.
	   * Now he wants to know how many times each digits occurs in the given period
	   * of a day. He doesn't know programming. Can You help him?
	   *
	   * Example:
	   *
	   * digit_hours("00:00:00", "00:00:00") = [6,0,0,0,0,0,0,0,0,0]
	   * digit_hours("23:59:58", "23:59:59") = [0,0,2,2,0,4,0,0,1,3] [input] string
	   * period_from
	   *
	   * Time is given in the format hh:mm:ss. It is guaranteed that the given time
	   * is valid. [input] string period_to
	   *
	   * Time is given in the format hh:mm:ss. It is guaranteed that the given time
	   * is valid, and that period_from ≤ period_to. [output] array.integer
	   *
	   * An array of length 10, where the first element defines the number of times
	   * 0 occurs, the second element defines the number of times 1 occurs etc.
	   *
	   * @param period_from
	   * @param period_to
	   * @return
	   */
	  static int[] digit_hours (String period_from, String period_to)
	  {
		int[] v = new int[10];
	   
	   
	  	String[] s = period_from.split (":");
	  	int[] s1 = new int[3];
	  	for (int i = 0; i < s.length; i++)
	  	{
	    	s1[i] = Integer.parseInt (s[i]);
	  	}
	 	 
	  	int from = s1[0]*60*60+s1[1]*60+s1[2];
	 	 
	  	String[] t = period_to.split (":");
	  	int[] t1 = new int[3];
	  	for (int i = 0; i < t.length; i++)
	  	{
	    	t1[i] = Integer.parseInt (t[i]);
	  	}
	 	 
	  	int to = t1[0]*60*60+t1[1]*60+t1[2]+1;
	 	 
	  	while (from < to)
	  	{
	    	v[s1[0]/10]++;
	    	v[s1[0]%10]++;
	    	v[s1[1]/10]++;
	    	v[s1[1]%10]++;
	    	v[s1[2]/10]++;
	    	v[s1[2]%10]++;
	   	 
	   	 
	    	s1[2]++;
	    	if (s1[2] == 60)
	    	{
	      	s1[2] = 0;
	      	s1[1]++;
	    	}
	   	 
	  	 
	    	if (s1[1] == 60)
	    	{
	      	s1[1] = 0;
	      	s1[0]++;
	    	}
	    	from++;
	  	}
	    


		return v;
	  }



}
