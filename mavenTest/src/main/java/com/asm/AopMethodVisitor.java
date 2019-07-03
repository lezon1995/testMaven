package com.asm;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 被代理类方法的具体实现
 *
 * @author zhuliang
 * @date 2019/7/3 11:50
 * @see AopMethodVisitor#visitCode() 进入被代理的方法前 执行{@link AopInterceptor#before()}方法
 * @see AopMethodVisitor#visitInsn(int) 被代理的方法返回之前 执行{@link AopInterceptor#after()} 方法
 */
public class AopMethodVisitor extends MethodVisitor implements Opcodes {

    public AopMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitCode() {
        super.visitCode();
        this.visitMethodInsn(INVOKESTATIC, "com/asm/AopInterceptor", "before", "()V", false);
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode >= IRETURN && opcode <= RETURN)// 在返回之前安插after 代码。
            this.visitMethodInsn(INVOKESTATIC, "com/asm/AopInterceptor", "after", "()V", false);
        super.visitInsn(opcode);
    }

}