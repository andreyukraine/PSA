package ua.artcode.test.expr;

/**
 * Created by serhii on 04.09.16.
 */
public class TestFindCurrentPoint {

    public static void main(String[] args) {
        point2();
    }

    public static void point2(){
        StackTraceElement x = Thread.currentThread().getStackTrace()[1];
        System.out.println(x.toString());
    }
}
