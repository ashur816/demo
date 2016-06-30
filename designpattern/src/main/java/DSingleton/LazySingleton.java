package DSingleton;

/**
 * @ClassName: LazySingleton
 * @Description: 懒汉式单例 DCL 双检锁  volatile
 * @author ZXY
 * @date 2016/5/18 10:58
 */
class LazySingleton {

    private volatile static LazySingleton instance = null;

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        //第一重判断
        if(instance == null){
            synchronized(LazySingleton.class) {
                //第二重判断
                if(instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
