package package1;

import package2.ClassB;

public class ClassA {
    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB.publicMethod();
        //private access - classB.privateMethod();
        /*
        * protected access:
        * classB.protectedMethod();
        * classB.packageProtected();
        */

    }
}
