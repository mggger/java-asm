package generating;

import jdk.internal.org.objectweb.asm.ClassWriter;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class App {

    public static void main(String[] args) {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "pkg/Comparable", null, "java/lang/Object",
                new String[] { "pkg/Mesurable" });
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
                null, new Integer(1)).visitEnd(); cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();

        cw.visitEnd();
        byte[] b = cw.toByteArray();

        MyClassLoader myClassLoader = new MyClassLoader();

        Class c = myClassLoader.defineClass("pkg.Comparable", b);
        System.out.println(c.getClass());
    }
}
