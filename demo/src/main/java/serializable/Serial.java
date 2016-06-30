package serializable;

import java.io.Serializable;

/**
 * Created by Martin on 2015/11/24.
 */
public class Serial implements Serializable {
    private static final long serialVersionUID = 6977402643848374753L;
    int    id;
    String name;
    int age;

    public Serial(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
//        return "DATA: " + id + " " + name ;
        return "DATA: " + id + " " + name + " " + age;
    }
}
