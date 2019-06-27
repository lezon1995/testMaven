package com.proxy.custom_dynamic_proxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 生成动态代理对象的代码
 *
 * @author zhuliang
 * @date 2019/4/18
 */
public class MyProxy {
    private static Class clazz = MyProxy.class;
    private static final String ln = ";\n";
    private static final String enter = "\n";


    public static Object newProxyInstance(MyClassLoader classLoader, Class<?> interfaces, MyInvocationHandler h) throws IllegalArgumentException {

        //1、生成源代码
        String sourceCode = generateCode(interfaces);

        //2、将生成的源代码（.java文件）保存到硬盘当中
        File javaFile = null;
        try {
            String path = MyProxy.class.getResource("").getPath();
            javaFile = new File(path + "$Proxy0.java");
            FileWriter writer = new FileWriter(javaFile);
            writer.write(sourceCode);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3、编译源代码，并且生成.class文件
        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(javaFile);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            javaFile.delete();
        }


        //4、将class文件动态加载到JVM中
        Constructor<?> constructor;
        Object instance = null;
        try {
            Class<?> proxyClass = classLoader.findClass("$Proxy0");
            constructor = proxyClass.getConstructor(MyInvocationHandler.class);
            instance = constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //5、返回被代理后的代理对象
        return instance;
    }

    private static String generateCode(Class<?> interfaces) {
        StringBuilder s = new StringBuilder();
        s.append("package ").append(clazz.getPackage().getName()).append(ln);
        s.append("import ").append("java.lang.reflect.Method").append(ln);
        s.append("public class $Proxy0 implements  ").append(interfaces.getName()).append("{").append(enter);
        s.append("MyInvocationHandler h").append(ln);
        s.append("public  $Proxy0(MyInvocationHandler h){").append(enter);
        s.append("this.h = h").append(ln);
        s.append("}").append(ln);
        for (Method m : interfaces.getMethods()) {
            String returnType = m.getReturnType().getName();
            s.append("public ").append(returnType).append(" ").append(m.getName()).append("() {").append(enter);
            s.append("try{");
            s.append("Method m = ").append(interfaces.getName()).append(".class.getMethod(\"" + m.getName() + "\",new Class[]{})").append(ln);
            s.append("this.h.invoke(this,m,null)").append(ln);
            s.append("}catch (Throwable throwable) {");
            s.append("throwable.printStackTrace();");
            s.append("}");
            if (!"void".equals(returnType)) {
                s.append("return null").append(ln);
            }
            s.append("}").append(ln);
        }
        s.append("}");
        return s.toString();
    }

}
