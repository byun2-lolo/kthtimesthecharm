import java.util.*;
public class KTimeCharm {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int factorial = factorial(num);
        for (int i = 0; i < factorial; i++) {
            int[] arr = new int[num];
            for (int j = 0; j < num; j++) arr[j] = i / factorial(num - j - 1) % (num - j);
            int[] row = new int[num];
            ArrayList<Integer> done = new ArrayList<Integer>();
            for (int j = 0, index = 0; j < num; j++) {
                index %= num;
                while (done.contains(index)) {
                    index++;
                    index %= num;
                }
                for (int k = 0; k < arr[j]; k++) {
                    index++;
                    index %= num;
                    while (done.contains(index)) {
                        index++;
                        index %= num;
                    }
                }
                row[j] = index;
                done.add(index);
            }
            boolean nice = false;
            for (int j = 0; j < num; j++) if (row[row[j]] != j) {
                nice = !nice;
                break;
            }
            boolean cont = false;
            for (int j = 0; j < num; j++) if (row[row[row[j]]] != j) {
                nice = !nice;
                cont = !cont;
                break;
            }
            if (nice) System.out.println(Arrays.toString(arr) + " " + (cont ? '2' : '3'));
        }
    }
    public static int factorial (int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) factorial *= i;
        return factorial;
    }
}
/*
echo "# kthtimesthecharm" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/byun2-lolo/kthtimesthecharm.git
git push -u origin main
 */