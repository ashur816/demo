package test;

/**
 * Created by Martin on 2015/7/24.
 */
class C {
    public static void main(String[] args) throws Exception {
        int a = 1;
        int b = 2;
        System.out.print("7" + 5 + 4);
        System.out.print(m() + a + 3);
        System.out.println(a + b + m());
    }

    public static String m() {
        return "6";
    }
}
