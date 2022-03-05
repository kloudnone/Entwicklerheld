package de.entwicklerheld.betterplace.challenge.stage2;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class Stage2 {

    public static class Service {

        public static int add(int... summands) {
            
            if (summands.length == 0) {
                throw new IllegalArgumentException("Input is required!");
            }

            int sum = 0;
            for (Integer summand : summands) {
                sum += summand;
            }

            return sum;
        }
    }


    public static class TestRunner {

        public static void main(String[] args) {
            runTests();
        }

        public static String runTests() {
            Set<Method> testMethods = findMethodsAnnotatedWith(Stage1.Test.class);
            de.entwicklerheld.betterplace.challenge.stage2.Stage2.TestRunner.TestResult testResult = new de.entwicklerheld.betterplace.challenge.stage2.Stage2.TestRunner.TestResult();
            for (Method method : testMethods) {
                runTestMethod(testResult, method);
            }
            return printResult(testResult);
        }

        public static Set<Method> findMethodsAnnotatedWith(Class<? extends Annotation> annotation) {
            ConfigurationBuilder cBuilder = new ConfigurationBuilder();
            cBuilder.setUrls(ClasspathHelper.forPackage("de.entwicklerheld.betterplace.challenge.stage2"));
            cBuilder.setScanners(new MethodAnnotationsScanner());

            Reflections reflections = new Reflections(cBuilder);

            return reflections.getMethodsAnnotatedWith(annotation);
        }

        public static void runTestMethod(final de.entwicklerheld.betterplace.challenge.stage2.Stage2.TestRunner.TestResult testResult, final Method method) {
            Object object = null;
            try {
                object = method.getDeclaringClass().newInstance();
            } catch (Exception e) {
                System.out.println(e.getCause());
            }

            if (method.getDeclaredAnnotation(Stage1.Test.class).ignore()) {
                testResult.ignoredTests.add(method);
                return;
            }

            testResult.runnedTests.add(method);

            boolean failure = false;
            try {
                method.invoke(object);
            } catch (Exception e) {
                failure = true;
                if (e.getCause() instanceof AssertionError) {
                    testResult.failures.add(method + " : " + e.getCause().getMessage());
                } else {
                    testResult.errors.add(method + " : " + e.getCause());
                }
            }

            if (!failure) {
                testResult.successes.add(method.getName());
            }
        }

        public static String printResult(final de.entwicklerheld.betterplace.challenge.stage2.Stage2.TestRunner.TestResult testResult) {
            String res = testResult.getSuccesses().size() + " test(s) finished without errors.\n" + testResult.getIgnoredTests().size() + " test(s) were ignored.\n" + testResult.getFailures().size() + " test(s) failed.\n" + testResult.getErrors().size() + " test(s) threw an exception.\n";
            for(String fail : testResult.getFailures()){
                res += fail + "\n";
            }
            for(String err : testResult.getErrors()){
                res += err + "\n";
            }    
            return res;
        }

        public static class TestResult {

            List<String> failures;

            List<String> errors;

            List<String> successes;

            List<Method> runnedTests;

            List<Method> ignoredTests;

            public TestResult() {
                failures = new ArrayList<>();
                errors = new ArrayList<>();
                successes = new ArrayList<>();
                runnedTests = new ArrayList<>();
                ignoredTests = new ArrayList<>();
            }

            public List<String> getFailures() {
                return failures;
            }

            public List<String> getErrors() {
                return errors;
            }

            public List<String> getSuccesses() {
                return successes;
            }

            public List<Method> getRunnedTests() {
                return runnedTests;
            }

            public List<Method> getIgnoredTests() {
                return ignoredTests;
            }

        }
    }



}
