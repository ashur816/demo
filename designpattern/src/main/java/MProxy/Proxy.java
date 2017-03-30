package MProxy;

/**
 * @author ZXY
 * @ClassName: Proxy
 * @Description: 代理主题角色
 * @date 2017/3/30 15:22
 */
public class Proxy extends Subject{

    private RealSubject realSubject = new RealSubject();

    @Override
    public void Request() {
        //pre逻辑
        realSubject.Request();
        //post逻辑
    }
}
