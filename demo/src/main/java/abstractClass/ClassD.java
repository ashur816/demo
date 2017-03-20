package abstractClass;

/**
 * @author ZXY
 * @ClassName: ClassD
 * @Description:
 * @date 2017/3/16 14:10
 */
public abstract class ClassD extends ClassA implements ClassB {

    public static void main(String[] args) {
        ClassD classD = new ClassD() {
            @Override
            public void a() {

            }

            @Override
            public void b() {

            }
        };

        ClassC classC = new ClassC();
    }
}
