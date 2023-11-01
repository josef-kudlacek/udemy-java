package package2;

public class ClassB {
    public void publicMethod() {
        System.out.println("This is the public method of classB.");
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("This is the private method of classB.");
    }

    protected void protectedMethod() {
        System.out.println("This is the protected method of classB.");
    }

    void packageProtected() {
        System.out.println("This is the package protected of classB.");
    }
}
