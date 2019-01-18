package Atester;

public class test {
    public int aaa() {
        int x = 1;

        try {
            System.out.println(x);
            return ++x;
        } catch (Exception e) {

        } finally {
            System.out.println(x);
            ++x;
            System.out.println(x);
        }
        System.out.println("after finally");
        return x;
    }

    public static void main(String[] args) {
        test t = new test();
        int y = t.aaa();
        System.out.println("y=" + y);
    }
}
