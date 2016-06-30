package serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by Martin on 2015/11/24.
 */
public class DeserialTest {

    public static void main(String[] args) throws Exception {
        Serial serial2;
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ZXY\\Desktop\\serialTest.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        serial2 = (Serial)objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Object Deserial"+serial2);
    }
}
