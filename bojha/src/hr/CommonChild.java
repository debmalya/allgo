/**
 * 
 */
package hr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement
 * 
 * Given two strings a and b of equal length, what's the longest string (S) that
 * can be constructed such that it is a child of both?
 * 
 * A string x is said to be a child of a string y if x can be formed by deleting
 * zero or more characters from y.
 * 
 * For example, ‘‘abcd" and ‘‘abdc" has two children with maximum length 3,
 * ‘‘abc" and ‘‘abd". Note that we will not consider ‘‘abcd" as a common child
 * because ′c′ doesn't occur before ′d′ in the second string.
 * 
 * Input Format
 * 
 * Two strings, a and b, with a newline separating them.
 * 
 * Constraints
 * 
 * All characters are in uppercase and lie between ASCII values 65-90. The
 * maximum length of the strings is 5000.
 * 
 * Output Format
 * 
 * Length of string S.
 * 
 * Sample Input
 * 
 * HARRY SALLY
 *
 */
public class CommonChild {
	public static void main(String[] args) throws IOException
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // read first string
        char x[]=br.readLine().toCharArray();
        // read second string
        char y[]=br.readLine().toCharArray();
        // array dimension x.length+1 y.length+1
        int a[][]=new int[x.length+1][];
        int dir[][]=new int[x.length+1][];//0 for terminating condtion,1=diagonal,2=left,3=upper
        for(int i=0;i<a.length;i++)
        {
            a[i]=new int[y.length+1];
            dir[i]=new int[y.length+1];
            
        }
        for(int i=1;i<x.length+1;i++)
        {
            for(int j=1;j<a[0].length;j++)
            {
               a[i][j] = x[i - 1] == y[j -1] ? 1 : 0;
                if(i == j && x[i- 1] == y[j - 1])
                {
                    a[i][j]=a[i-1][j-1]+1;
                    dir[i][j]=1;//diagonal
                }
                else
                {
                    if(a[i-1][j]>a[i][j-1])//upper is greater
                    {
                        a[i][j]=a[i-1][j];
                        dir[i][j]=3;
                        
                    }
                    else//left is greater
                    {
                        a[i][j]=a[i][j-1];
                        dir[i][j]=2;    
                    }
                }
            }
        }
            
        int row=a.length-1;
        int col=a[0].length-1;
        System.out.println(a[row][col]);
    }
}
