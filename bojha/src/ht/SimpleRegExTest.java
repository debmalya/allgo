/**
 * 
 */
package ht;

/**
 * @author debmalyajash
 *
 */
import java.util.regex.Matcher;

import java.util.regex.Pattern;

 

public class SimpleRegExTest {

 

       public static void main(String[] args) {

              Pattern p = Pattern.compile("\\d*");

              Matcher m = p.matcher("ab34ef");

              boolean b = false;

              while(b = m.find()) {

                     System.out.print(m.start()+m.group());

              }

 

       }

 

}
