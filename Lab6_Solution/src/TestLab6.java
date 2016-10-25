import java.lang.reflect.Method;

/**
 * Instructions:
 * You can run this file to check whether you have solved the problems correctly.
 * You MUST NOT MODIFY this file.
 *
 * Created by Jun Yuan on 23/10/2016.
 */
public class TestLab6 {
    public static void main(String[] argv) {
        try {
            Class lab6;
            lab6 = Class.forName("Lab6");

            char[] a = {'1', '2', '3', '4', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6'};
            char[] b = {'1', '2', '2', '4', '5', '6'};
            char[] c = {'6', '6', '6'};
            char[] d = {'0', '7', '6', '6'};
            char[] e = {'0', '6', '6', '6'};

            Method m = lab6.getMethod("compare", new Class[]{char[].class, char[].class});
            if ((int) m.invoke(lab6, a, b) > 0 && (int) m.invoke(lab6, b, c) > 0 && (int) m.invoke(lab6, c, a) < 0
                    && (int) m.invoke(lab6, c, e) == 0 && (int) m.invoke(lab6, c, d) < 0)
                System.out.println("Congratulations! You solved problem 1.");
            else
                System.out.println("Oops! Something wrong with your problem 1.");


            int[][] aa = {{3, 2, 3}, {2, 2, 2}, {1, 2, 2}};
            int[][] bb = {{1, 2, 3, 3}, {2, 2, 2, 2}};
            int[][] cc = {{1, 2, 3, 4, 4, 3, 2, 1}};

            m = lab6.getMethod("compare", new Class[]{int[][].class, int[][].class});
            if ((int) m.invoke(lab6, aa, bb) > 0 && (int) m.invoke(lab6, aa, cc) < 0
                    && (int) m.invoke(lab6, bb, cc) < 0 && (int) m.invoke(lab6, aa, aa ) == 0)
                System.out.println("Congratulations! You solved problem 2.");
            else
                System.out.println("Oops! Something wrong with your problem 2.");

        } catch (Exception e) {
            System.out.println("Oops! Something wrong with your code.");
            e.printStackTrace();
        }
    }
}