package queue;

/**
 * @ClassName: QueueTest
 * @Description:
 * @author ZXY
 * @date 2016/8/2 17:20
 */
public class QueueTestOne {
    public static void main(String[] args) {
        RunOne runOne = new RunOne();
        RunTwo runTwo = new RunTwo();
        new Thread(runOne).start();
        new Thread(runTwo).start();
    }
}
