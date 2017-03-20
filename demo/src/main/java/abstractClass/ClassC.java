package abstractClass;

/**
 * @author ZXY
 * @ClassName: ClassC
 * @Description:
 * @date 2017/3/16 14:06
 */
public class ClassC extends ClassA implements ClassB {

    @Override
    public void a() {
        System.out.println();
    }

    @Override
    public void b() {

    }

    @Override
    public void c() {
        System.out.println("ClassC 执行");
    }

    public static void main(String[] args) {
        ClassC classC = new ClassC();
        classC.c();
    }
}
