package extendsFS;

/**
 * Created by Martin on 2015/7/24.
 */
public class Son extends Father {

    public Son(String s){
        System.out.println(s);
    }

    void good(){
        System.out.println("son:good");
    }

    public static void main(String[] args) {
        Son s = new Son("s");
        s.good();
    }
}
