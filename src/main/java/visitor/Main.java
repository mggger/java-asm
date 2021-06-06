package visitor;

import jdk.internal.org.objectweb.asm.ClassReader;

public class Main {

    public static void main(String[] args) throws Exception {
        ClassPrinter cp = new ClassPrinter();
        ClassReader cr = new ClassReader("visitor.Test");
        cr.accept(cp, 0);
    }
}
