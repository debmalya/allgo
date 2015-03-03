import java.io.*;
import java.util.*;
import java.security.*;

/*
 * This code is for testing MovingNQueens.
 */
public class MovingNQueensVis {
    final int MIN_NQ = 8, MAX_NQ = 100;
    // ----------------------------------------------------------------------------------
    int NQ;                            // number of queens
    int[] QR, QC;                      // coordinates of queens (initial -> current -> final)
    int rawScore;
    int maxMoves;                      // constraint on # of moves in return
    // ----------------------------------------------------------------------------------
    void generate(String seed) {
      try {
        SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG");
        rnd.setSeed(Long.parseLong(seed));
        if (seed.equals("1")) {
            NQ = MIN_NQ;
        } else {
            NQ = rnd.nextInt(MAX_NQ - MIN_NQ + 1) + MIN_NQ;
        }
        if (debug) {
            System.out.println("Number of queens = " + NQ);
        }

        // queens are placed randomly within a SZ x SZ square
        int min_sz = (int) Math.sqrt(NQ) + 1;
        int max_sz = min_sz * 2;
        int sz = rnd.nextInt(max_sz - min_sz + 1) + min_sz;
        if (debug) {
            System.out.println("Initial arrangement size = " + sz);
        }

        QR = new int[NQ];
        QC = new int[NQ];
        char[][] queenPlaced = new char[sz][sz];
        for (int i = 0; i < sz; ++i) {
            Arrays.fill(queenPlaced[i], '.');
        }

        int r, c, nPlaced = 0;
        while (nPlaced < NQ) {
            r = rnd.nextInt(sz);
            c = rnd.nextInt(sz);
            if (queenPlaced[r][c] == '.') {
                queenPlaced[r][c] = 'Q';
                QR[nPlaced] = r;
                QC[nPlaced] = c;
                ++nPlaced;
            }
        }
        if (debug) {
            for (int i = 0; i < sz; ++i) {
                System.out.println(new String(queenPlaced[i]));
            }
            System.out.println();
        }
      }
      catch (Exception e) { 
        System.err.println("An exception occurred while generating the test case.");
        e.printStackTrace(); 
      }
    }
    // ----------------------------------------------------------------------------------
    boolean isValidMove(int dR, int dC) {
        return dR == 0 || dC == 0 || dR == dC || dR == -dC;
    }
    // ----------------------------------------------------------------------------------
    public double runTest(String seed) {
      try {
        generate(seed);
        rawScore = 0;
        maxMoves = NQ * 8;

        String[] moves = rearrange(QR, QC);
 
        // apply the moves from the return while checking them for validity
        if (moves == null || moves.length == 0) {
            addFatalError("Your return must contain at least one element.");
            return 0;
        }
        if (moves.length > maxMoves) {
            addFatalError("Your return can contain at most " + maxMoves + " elements (contains " + moves.length + ").");
            return 0;
        }

        for (int i = 0; i < moves.length; ++i) {
            String[] s = moves[i].split(" ");
            if (s.length != 3) {
                addFatalError("Each element of your return must be formatted as \"INDEX ROW COL\" (element " + i + " is \"" + moves[i] + "\").");
                return 0;
            }
            int ind, newRow, newCol;
            try {
                ind = Integer.parseInt(s[0]);
                newRow = Integer.parseInt(s[1]);
                newCol = Integer.parseInt(s[2]);
            } catch (Exception e) {
                addFatalError("Each element of your return must be formatted as \"INDEX ROW COL\" (element " + i + " is \"" + moves[i] + "\").");
                return 0;
            }
            if (ind < 0 || ind >= NQ) {
                addFatalError("Element " + i + ": invalid queen index " + ind + ".");
                return 0;
            }
            // valid move direction: horizontal, vertical or diagonal
            int dRow = newRow - QR[ind];
            int dCol = newCol - QC[ind];
            if (dRow == 0 && dCol == 0) {
                addFatalError("Element " + i + ": a queen must move at least one square (queen " + ind + " stayed at (" + newRow + "," + newCol + ")).");
                return 0;
            }
            if (!isValidMove(dRow, dCol)) {
                addFatalError("Element " + i + ": a queen can move in a straight line vertically, horizontally or diagonally only (queen " + ind + " moved by (" + dRow + "," + dCol + ")).");
                return 0;
            }
            // extract move distance and move direction
            int dist = Math.max(Math.abs(dRow), Math.abs(dCol));
            dRow /= dist;
            dCol /= dist;
            // valid move: over unoccupied squares only, to an unoccupied cell
            for (int j = 0; j < NQ; ++j) {
                if (ind == j) {
                    continue;
                }
                // check that queen j is not in the way of the moving one
                int dRowJ = QR[j] - QR[ind];
                int dColJ = QC[j] - QC[ind];
                if (!isValidMove(dRowJ, dColJ)) {
                    continue;
                }
                int distJ = Math.max(Math.abs(dRowJ), Math.abs(dColJ));
                dRowJ /= distJ;
                dColJ /= distJ;
                if (dRow == dRowJ && dCol == dColJ && distJ <= dist) {
                    addFatalError("Element " + i + ": a queen can move only over unoccupied squares (queen " + ind + " passed queen " + j + " at (" + QR[j] + "," + QC[j] + ")).");
                    return 0;
                }
            }

            // valid move - do it and update score (Chebyshev length of the move)
            rawScore += Math.max(Math.abs(newRow - QR[ind]), Math.abs(newCol - QC[ind]));
            QR[ind] = newRow;
            QC[ind] = newCol;
        }

        // now all moves are done - check that the result is valid
        for (int i = 0; i < NQ; ++i)
        for (int j = i + 1; j < NQ; ++j) {
            if (isValidMove(QR[i] - QR[j], QC[i] - QC[j])) {
                addFatalError("After all moves queens " + i + " and " + j + " threaten each other.");
                return 0;
            }
        }

        // score is based on the total Chebyshev length of individual queen moves
        return rawScore;
      }
      catch (Exception e) { 
        System.err.println("An exception occurred while trying to get your program's results.");
        e.printStackTrace(); 
        return 0.0;
      }
    }
// ------------- server part ------------------------------------------------------------
    public String checkData(String test) {
        return "";
    }
    // ----------------------------------------------------------------------------------
    public String displayTestCase(String test) {
        StringBuffer sb = new StringBuffer();
        sb.append("Seed = " + test + "\n");
        generate(test);
        sb.append("Number of queens = " + NQ + "\n");
        for (int i = 0; i < NQ; ++i) {
            sb.append("(" + QR[i] + "," + QC[i] + ") ");
        }
        return sb.toString();
    }
    // ----------------------------------------------------------------------------------
    public double[] score(double[][] sc) {
        double[] res = new double[sc.length];
        // relative scoring to minimize score: each individual score divides the minimal score for this test case
        for (int i = 0; i < sc.length; i++)
            res[i] = 0;
        for (int j = 0; j < sc[0].length; ++j) {
            double minsc = -1;
            for (int i = 0; i < sc.length; i++) {
                // a valid score will always be positive, because initial configuration always has queens attacking each other
                if (minsc < 0 || sc[i][j] > 0 && minsc > sc[i][j])
                    minsc = sc[i][j];
            }
            for (int i = 0; i < sc.length; i++) {
                if (sc[i][j] != 0)
                    res[i] += minsc / sc[i][j];
            }
        }
        return res;
    }
// ------------- local tester part -----------------------------------------------------
    static String exec;
    static boolean debug;
    static Process proc;
    InputStream is;
    OutputStream os;
    BufferedReader br;
    // ----------------------------------------------------------------------------------
    String[] rearrange(int[] queenRows, int[] queenCols) throws IOException {
    	
        int i,j;
        String[] ret = new String[0];
        if (exec != null)
        {   // imitate passing params and receiving return
            StringBuffer sb = new StringBuffer();
            sb.append(NQ).append('\n');
            for (i = 0; i < NQ; ++i)
                sb.append(queenRows[i]).append('\n');
            sb.append(NQ).append('\n');
            for (i = 0; i < NQ; ++i)
                sb.append(queenCols[i]).append('\n');
            os.write(sb.toString().getBytes());
            os.flush();
 
            int Nret = Integer.parseInt(br.readLine());
            ret = new String[Nret];
            for (i = 0; i < Nret; ++i)
                ret[i] = br.readLine();
        }
        
//    	String[] ret = MovingNQueens.rearrange(queenRows, queenCols);
        return ret;
    }
    // ----------------------------------------------------------------------------------
    public MovingNQueensVis(String seed) {
      try {
        // interface for runTest
        if (exec != null) {
            try {
                Runtime rt = Runtime.getRuntime();
                proc = rt.exec(exec);
                os = proc.getOutputStream();
                is = proc.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                new ErrorReader(proc.getErrorStream()).start();
            } catch (Exception e) { e.printStackTrace(); }
        }
        System.out.println("Score = " + runTest(seed));
        if (proc != null)
            try { proc.destroy(); } 
            catch (Exception e) { e.printStackTrace(); }
      }
      catch (Exception e) { e.printStackTrace(); }
    }
    // ----------------------------------------------------------------------------------
    public static void main(String[] args) {
        String seed = "1";
        debug = false;
        for (int i = 0; i<args.length; i++)
        {   if (args[i].equals("-seed"))
                seed = args[++i];
            if (args[i].equals("-exec"))
                exec = args[++i];
            if (args[i].equals("-debug"))
                debug = true;
        }
        MovingNQueensVis bw = new MovingNQueensVis(seed);
    }
    // ----------------------------------------------------------------------------------
    void addFatalError(String message) {
        System.out.println(message);
    }
}
 
class ErrorReader extends Thread{
    InputStream error;
    public ErrorReader(InputStream is) {
        error = is;
    }
    public void run() {
        try {
            byte[] ch = new byte[50000];
            int read;
            while ((read = error.read(ch)) > 0)
            {   String s = new String(ch,0,read);
                System.out.print(s);
                System.out.flush();
            }
        } catch(Exception e) { }
    }
} 