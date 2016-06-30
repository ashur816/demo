package finalClass;

/**
 * Created by Martin on 2015/11/28.
 */
public final class ServiceFactory {
    private static Object serviceInvoke = null;

    static{
        try {
            serviceInvoke = Class.forName("ServiceFactory").newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
