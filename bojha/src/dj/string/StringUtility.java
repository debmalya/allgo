package dj.string;

import java.util.HashSet;
import java.util.Set;


public class StringUtility
{

  public StringUtility ()
  {
    // TODO Auto-generated constructor stub
  }



  /**
   * @param args
   */
  public static void main (String[] args)
  {
    // TODO Auto-generated method stub

  }



  /**
   * To determine if a string has all unique characters. What if we can not use
   * additional data structures.
   * 
   * @param str
   *          to be checked for unique characters.
   * @return true in contain unique characters false otherwise.
   */
  public boolean containsUniqueCharacter (String str)
  {
    if (str == null)
    {
      throw new IllegalArgumentException ("Passed a null string");
    }


    for (int i = 0; i < str.length (); i++)
    {
      for (int j = 0; j < str.length (); j++)
      {
        if (i != j)
        {

          if (str.charAt (i) == str.charAt (j))
          {
            return false;
          }


          if (toLowerCase (str.charAt (i)) == toLowerCase (str.charAt (j)))
          {
            return false;
          }
        }
      }
    }
    return true;
  }



  /**
   * Write a code to reverse a C-Style String. (C-String means that "abcd' is
   * represented as five characters, including null characters.
   * 
   * @param string
   *          to be reversed.
   * @return reversed string.
   */
  public String reverse (String str)
  {
    if (str == null)
    {
      throw new IllegalArgumentException ("Passed null string");
    }

    str = str.replace ("\n", "");
    char[] reversed = new char[str.length ()];
    for (int i = str.length () - 1; i > -1; i--)
    {
      reversed[str.length () - i - 1] = str.charAt (i);
    }
    return String.valueOf (reversed);
  }



  /**
   * Design an algorithm to remove duplicate characters in a String. Without
   * using any additional buffer. NOTE: one or two additional variables are
   * fine.
   * 
   * @param str
   *          from where duplicate characters will be removed.
   * @return string without duplicate characters.
   */
  public String removeDuplicate (String str)
  {
    if (str == null)
    {
      throw new IllegalArgumentException ("Passed a null string");
    }


    StringBuilder withoutDuplicate = new StringBuilder ();
    for (int i = 0; i < str.length (); i++)
    {
      boolean isDuplicate = false;
      for (int j = 0; j < str.length (); j++)
      {

        if (i != j)
        {

          if (toLowerCase (str.charAt (i)) == toLowerCase (str.charAt (j)))
          {
            isDuplicate = true;
            break;
          }
        }
      }
      if (!isDuplicate || withoutDuplicate.indexOf (String.valueOf(str.charAt (i))) == -1)
      {
        withoutDuplicate.append(str.charAt (i));
      }


    }
    return withoutDuplicate.toString();
  }



  /**
   * Convert to lower case without using library methods.
   */
  public String toLowerCase (String str)
  {
    char[] values = new char[str.length ()];
    for (int i = 0; i < str.length (); i++)
    {
      if (str.charAt (i) >= 'A' && str.charAt (i) <= 'Z')
      {
        values[i] = (char)(str.charAt (i) + 'a' - 'A');
      }
      else
      {
        values[i] = str.charAt (i);
      }
    }
    return String.valueOf (values);
  }



  /**
   * To convert it into lower case.
   * 
   * @param c
   *          to be converted in lower case.
   * @return lower case character.
   */
  public char toLowerCase (char c)
  {
    if (c >= 'A' && c <= 'Z')
    {
      return (char)(c + 'a' - 'A');
    }
    return c;
  }
  
  /**
   * Write a method to decide if two strings are anagram or not.
   * @param str first string.
   * @param str2 second string.
   * @return true if they are anagram, false otherwise.
   */
  public boolean isAnagram(String str,String str2) {
    if (str.length () != str2.length ()) {
       return false;
    }
    Set<Character> characters = new HashSet<Character>(str.length ());
    for (int i = 0; i<str.length (); i++) {
      characters.add (str.charAt (i));
    }
    
    for (int i = 0; i<str2.length (); i++) {
      if (characters.add (str2.charAt (i)))
        return false;
    }
    return true;
  }

  
  /**
   * To check whether the string is palindromic  or not.
   * 
   * @param str to be checked.
   * @return true if palindrom, false otherwise.
   */
  public boolean isPalindrom(String str) {
    int len = str.length ();
    for (int i = 0; i < len /2 ; i++)
      if (str.charAt (i)!= str.charAt (len -i -1)) {
        return false;
      }
    return true;
  }

}
