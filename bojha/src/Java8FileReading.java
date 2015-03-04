import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Java8FileReading
{

  public Java8FileReading ()
  {
    // TODO Auto-generated constructor stub
  }



  /**
   * @param args
   */
  public static void main (String[] args)
  {
    if (args != null && args.length > 0)
    {
      try
      {
        List<String> lines = Files.readAllLines (Paths.get (args[0]), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder (1024);

        for (String line : lines)
        {
          sb.append (line);
          sb.append("\n");
        }

        System.out.println (sb);


      }
      catch (IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace ();
      }
    }
    else
    {
      System.err.println ("USAGE : java Java8FileReading <file name with path>.");
    }

  }

}
