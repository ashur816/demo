package extendsFS;

/**
 * Created by Martin on 2015/7/24.
 */
public class Father {

    public Father() {
        System.out.println("father");
    }

    public Father(String s) {
        System.out.println("father:" + s);
    }

    void good() {
        System.out.println("father:good");
    }

    void good(String s) {
        boolean a = true;
        if (a = false) {
            System.out.println(s);
        }
    }

}

