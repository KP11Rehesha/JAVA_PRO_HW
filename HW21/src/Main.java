import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    int priority() default 5;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BeforeSuite {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AfterSuite {}

class TestClass {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite method");
    }

    @Test(priority = 7)
    public void testMethod1() {
        System.out.println("TestMethod1");
    }

    @Test(priority = 3)
    public void testMethod2() {
        System.out.println("TestMethod2");
    }

    @Test(priority = 10)
    public void testMethod3() {
        System.out.println("TestMethod3");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite method");
    }
}

class TestRunner {
    public static void start(Class<?> testClass) throws Exception {
        Object obj = testClass.getDeclaredConstructor().newInstance();
        Method[] methods = testClass.getDeclaredMethods();
        List<Method> beforeSuiteMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();
        List<Method> afterSuiteMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteMethods.add(method);
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteMethods.add(method);
            }
        }

        if (beforeSuiteMethods.size() > 1 || afterSuiteMethods.size() > 1) {
            throw new RuntimeException("Only one @BeforeSuite and one @AfterSuite method should be present");
        }

        beforeSuiteMethods.get(0).invoke(obj);

        testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));
        for (Method testMethod : testMethods) {
            testMethod.invoke(obj);
        }

        afterSuiteMethods.get(0).invoke(obj);
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        TestRunner.start(TestClass.class);
    }
}