package de.entwicklerheld.betterplace.challenge.stage3;

import org.reflections.util.ClasspathHelper;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Stage3 {

    @Target({ ElementType.METHOD })
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface ParameterizedTest {

        boolean ignore() default false;

        String parameterProvider();
    }


    public static class ExtendedTestRunner extends Stage2.TestRunner {

        public static void main(String[] args) {
            System.out.println(runTests());
        }

        public static String runTests() {
            Set<Method> testMethods = new HashSet<>();
            testMethods.addAll(findMethodsAnnotatedWith(Stage1.Test.class));
            testMethods.addAll(findMethodsAnnotatedWith(ParameterizedTest.class));

            TestResult testResult = new TestResult();

            for (Method method : testMethods) {
                runTestMethod(testResult, method);
            }

            return printResult(testResult);
        }

        public static void runTestMethod(final TestResult testResult, final Method method) {
            if (method.isAnnotationPresent(Stage1.Test.class) == true) {
                Stage2.TestRunner.runTestMethod(testResult, method);
            }

            if (method.isAnnotationPresent(Stage3.ParameterizedTest.class) == true) {
                Object object = null;
                try {
                    object = method.getDeclaringClass().newInstance();
                } catch (Exception e) {
                    System.out.println(e);
                }

                if (method.getAnnotation(Stage3.ParameterizedTest.class).ignore()) {
                    testResult.ignoredTests.add(method);
                    return;
                }

                boolean failure = false;
                try {
                    Method m = method.getDeclaringClass().getMethod(method.getAnnotation(Stage3.ParameterizedTest.class).parameterProvider());
                    Object object1 = m.invoke(object);
                    List<TestParameters> tp = (List<TestParameters>) object1;
                    for (TestParameters p : tp) {
                        try {
                           testResult.runnedTests.add(method);
                            method.invoke(object, p.expectedResult, p.parameters); 
                        } catch (Exception e) {
                            failure = true;
                            if (e.getCause() instanceof AssertionError) {
                                testResult.failures.add(method + " : " + e.getCause() + " TestParams: " + tp);
                            } else {
                                testResult.errors.add(method + " : " + e.getCause() + " TestParams: " + tp);
                            }
                        }
                        if (!failure) {
                            testResult.successes.add(method.getName());
                        }
                    }
                } catch (Exception e) {
                    // do nothing here
                }
            }
        }
    }

}
