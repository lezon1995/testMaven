package com.asm;


import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.ClassReader;

/**
 * 利用ASM模拟spring AOP
 * 此类是中间转换类
 * 作用是 将{@link ClassReader}读取到的类 做自己的处理
 *
 * @author zhuliang
 * @date 2019/7/3 11:50
 * @see AopClassAdapter#visitMethod 重写了该方法
 * 如果被代理的类的方法名以"test"开头
 * 让其返回自定义实现的{@link AopMethodVisitor}
 */
public class AopClassAdapter extends ClassVisitor implements Opcodes {

    public AopClassAdapter(int api, ClassVisitor cv) {
        super(api, cv);
    }

    /**
     * 当
     *
     * @param access
     * @param name
     * @param desc
     * @param signature
     * @param exceptions
     * @return
     */
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        // 对test开头的方法进行特殊处理
        if (name.startsWith("test")) {
            mv = new AopMethodVisitor(this.api, mv);
        }
        return mv;
    }

}