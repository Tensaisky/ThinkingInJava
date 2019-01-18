package unit14.typeinfo;
/*
    动态代理
    得到$Proxy0.class, 源码中静态代码块调用了equals方法，使得invoke方法被调用
 */

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler2 implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler2(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----- proxy: " + proxy.getClass() +
            ", method: " + method + ", args: " + args);
        byte[] bytes = ProxyGenerator.generateProxyClass(proxy.getClass().getSimpleName(), proxy.getClass().getInterfaces());
        FileOutputStream outputStream = new FileOutputStream("./" + proxy.getClass().getSimpleName() + ".class");
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy2 {
    public static void consumer2(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonono");
    }
    public static void main(String[] args){
        RealObject realObject = new RealObject();
        consumer2(realObject);
        System.out.println("-------");
        // 这里的proxy就是$Proxy0.class生成的实例
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[] { Interface.class },
                new DynamicProxyHandler2(realObject)
        );
        System.out.println(" ");
        consumer2(proxy);
    }
}
