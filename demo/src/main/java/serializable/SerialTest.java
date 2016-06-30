package serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Martin on 2015/11/24.
 */
public class SerialTest {
    public static void main(String[] args) throws Exception {
        Serial serial1 = new Serial(1,"song");
//        serial1.age=2;

        System.out.println("Object Serial"+serial1);
        FileOutputStream fileOutStream = new FileOutputStream("C:\\Users\\ZXY\\Desktop\\serialTest.txt");
        ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);
        objectOutStream.writeObject(serial1);
        objectOutStream.flush();
        objectOutStream.close();
    }
}
