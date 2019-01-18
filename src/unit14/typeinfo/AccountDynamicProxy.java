package unit14.typeinfo;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Account{
    public Account deposit(double value);
    public double getBalance();
}

class AccountInvocationHandler implements InvocationHandler{
    private double balance;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("----- proxy: " + proxy.getClass() +
//                ", method: " + method + ", args: " + args);
//        byte[] bytes = ProxyGenerator.generateProxyClass(proxy.getClass().getSimpleName(), proxy.getClass().getInterfaces());
//        FileOutputStream outputStream = new FileOutputStream("./" + proxy.getClass().getSimpleName() + ".class");
//        outputStream.write(bytes);
//        outputStream.flush();
//        outputStream.close();
        if ("deposit".equals(method.getName())){
            Double value = (Double) args[0];
            System.out.println("deposit: " + value);
            balance += value;
            //return proxy;
        }
        if ("getBalance".equals(method.getName())){
            return balance;
        }
        return null;
    }
}

public class AccountDynamicProxy {
    public static void main(String[] args) {
        Account account = (Account) Proxy.newProxyInstance(
                Account.class.getClassLoader(),
                new Class[]{Account.class, Serializable.class},
                new AccountInvocationHandler()
        );
        //account.deposit(5000).deposit(4000).deposit(-2500);
        account.deposit(5000);
        account.deposit(4000);
        account.deposit(-2500);
        System.out.println("Balance: " + account.getBalance());
    }
}

/*
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import unit14.typeinfo.Account;

public final class $Proxy0 extends Proxy implements Account, Serializable {
    private static Method m1;
    private static Method m4;
    private static Method m2;
    private static Method m3;
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

    public final double getBalance() throws  {
        try {
            return (Double)super.h.invoke(this, m4, (Object[])null);
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

    public final Account deposit(double var1) throws  {
        try {
            return (Account)super.h.invoke(this, m3, new Object[]{var1});
        } catch (RuntimeException | Error var4) {
            throw var4;
        } catch (Throwable var5) {
            throw new UndeclaredThrowableException(var5);
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
            m4 = Class.forName("unit14.typeinfo.Account").getMethod("getBalance");
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m3 = Class.forName("unit14.typeinfo.Account").getMethod("deposit", Double.TYPE);
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
}

 */