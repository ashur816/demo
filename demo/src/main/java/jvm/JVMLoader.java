package jvm;

import java.net.URL;

/**
 * @author ZXY
 * @ClassName: JVMLoader
 * @Description:
 * @date 2017/3/16 15:29
 */
public class JVMLoader {

    public static void main(String[] args) {
        //以下代码来获得bootstrap classloader加载了那些核心类库
        URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }

        System.out.println(System.getProperty("java.ext.dirs"));
        ClassLoader extensionClassloader=ClassLoader.getSystemClassLoader().getParent();
        System.out.println("the parent of extension classloader : "+extensionClassloader.getParent());

        System.out.println(System.getProperty("java.class.path"));

    }
}
