package com.asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;


/**
 * @author zhuliang
 * @date 2019/7/3 11:50
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //初始化ClassWriter
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //初始化AopClassAdapter 接受ClassWriter
        ClassVisitor cv = new AopClassAdapter(Opcodes.ASM4, cw);
        //初始化ClassReader pter
        ClassReader cr = new ClassReader(TestAop.class.getName());

        //接受AopClassAda 在内存中生成代理类
        cr.accept(cv, 0);

        //获取代理类的字节码
        byte[] bytes = cw.toByteArray();

        //自定义加载器
        MyClassLoader loader = new MyClassLoader();
        //将代理类加载到jvm
        Class<?> appClass = loader.defineClass(null, bytes);
        //反射调用test方法
        appClass.getMethods()[0].invoke(appClass.newInstance(), null);

    }
}

/**
 * 结果
 *
 *
 * .......before().......
 * hello i am test AOP
 * .......after().......
 */
