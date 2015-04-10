import java.util.Scanner;



public class ZeroFactor
{

  public static void main (String[] args)
  {
    Scanner scanner = null;
    try
    {
      scanner = new Scanner (System.in);
      int noOfTestCases = scanner.nextInt ();
      int[] inputs = new int[noOfTestCases];
      for (int i = 0; i < noOfTestCases; i++) {
        inputs[i] = scanner.nextInt ();
      }
      int[] results = getZ(inputs);
      for (int i = 0; i < results.length; i++) {
        System.out.println (results[i]);
      }
    }
    catch (Throwable th)
    {
      System.err.println (th.getMessage ());
    }
    finally
    {
      if (scanner != null)
      {
        scanner.close ();
      }
    }

  }

  private static int[] getZ (int[] inputs)
  {
    int[] result = new int[inputs.length];
    for (int i = 0; i < inputs.length; i++) {
      result[i] = getEachZ(inputs[i]);
    }
    return result;
  }

  public static int getEachZ (int input)
  {
    int result = 0;
    for (int i = 5; i <= input; i*=5) {
      result += input / i;
    }
    return result;
  }
}
