package KFacade;

/**
 * @author ZXY
 * @ClassName: Facade
 * @Description:
 * @date 2017/3/30 13:19
 */
class Facade {

    private SubSystemA systemA = new SubSystemA();
    private SubSystemB systemB = new SubSystemB();

    public void method(){
        systemA.methodA();
        systemB.methodB();
    }
}
