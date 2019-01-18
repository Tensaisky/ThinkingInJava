package unit14.typeinfo;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class MethodSelector implements InvocationHandler{
    private Object proxied;
    public MethodSelector(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----- proxy: " + proxy.getClass() +
                ", method: " + method);
        byte[] bytes = ProxyGenerator.generateProxyClass(proxy.getClass().getSimpleName(), proxy.getClass().getInterfaces());
        FileOutputStream outputStream = new FileOutputStream("./" + proxy.getClass().getSimpleName() + ".class");
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        return method.invoke(proxied, args);
    }
}

interface SomeMethods{
    void boring1();
    int boring2();
    String boring3();
}

class Implementation implements SomeMethods{
    @Override
    public void boring1() {
        System.out.println("boring 1");
    }

    @Override
    public int boring2() {
        System.out.println("boring 2");
        return 1;
    }

    @Override
    public String boring3() {
        System.out.println("boring 3");
        return "boring 3";
    }

    private void boring4(){
        System.out.println("boring 4");
    }
}

public class SelectingMethods {
    public static void main(String[] args){
        // 这里的proxy就是$Proxy0.class生成的实例
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[] { SomeMethods.class},
                new MethodSelector( new Implementation())
        );
        System.out.println("proxy: " + proxy.getClass().getSimpleName());
        proxy.boring1();
        proxy.boring2();
        proxy.boring3();
    }
}

/*
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import unit14.typeinfo.SomeMethods;

public final class $Proxy0 extends Proxy implements SomeMethods {
    private static Method m1;
    private static Method m3;
    private static Method m5;
    private static Method m4;
    private static Method m2;
    private static Method m0;

    public $Proxy0(InvocationHandler var1) throws  {
        super(var1);
    }

    public final boolean equals(Object var1) throws  {
        try {
            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final void boring1() throws  {
        try {
            super.h.invoke(this, m3, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final String boring3() throws  {
        try {
            return (String)super.h.invoke(this, m5, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final int boring2() throws  {
        try {
            return (Integer)super.h.invoke(this, m4, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final String toString() throws  {
        try {
            return (String)super.h.invoke(this, m2, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final int hashCode() throws  {
        try {
            return (Integer)super.h.invoke(this, m0, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m3 = Class.forName("unit14.typeinfo.SomeMethods").getMethod("boring1");
            m5 = Class.forName("unit14.typeinfo.SomeMethods").getMethod("boring3");
            m4 = Class.forName("unit14.typeinfo.SomeMethods").getMethod("boring2");
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
}

 */