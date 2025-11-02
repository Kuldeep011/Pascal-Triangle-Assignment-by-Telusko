import java.util.HashMap;
import java.util.Map;
public class Main 
{
    private static Map<String, Integer> memo = new HashMap<>();
    public static void main(String[] args)
    {
        System.out.println("Code Change!");
        int row = 5; 
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j <= row - i; j++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) 
            {
                int cof = Coefficient(i, j);
                System.out.print(cof + " ");
            }
            System.out.println();
        }
    }
    static int Coefficient(int row, int col) 
    {
        if (col == 0 || col == row) 
        {
            return 1;
        }

        String key = row + "," + col;
        if (memo.containsKey(key)) 
        {
            return memo.get(key);
        }

        int cof = Coefficient(row - 1, col - 1) + Coefficient(row - 1, col);
        memo.put(key, cof);
        return cof;
    }
}
