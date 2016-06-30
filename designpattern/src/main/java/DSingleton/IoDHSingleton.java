package DSingleton;

/**
 * @ClassName: IoDHSingleton
 * @Description: 静态内部类 确保对象唯一性
 * @author ZXY
 * @date 2016/5/18 12:56
 */
class IoDHSingleton {

    private static class HolderClass {
        private static IoDHSingleton instance = new IoDHSingleton();
    }

    private static IoDHSingleton getInstance() {
        return HolderClass.instance;
    }

    public static void main(String[] args) {
        IoDHSingleton s1, s2;
        s1 = IoDHSingleton.getInstance();
        s2 = IoDHSingleton.getInstance();
        System.out.println(s1 == s2);
    }
}
