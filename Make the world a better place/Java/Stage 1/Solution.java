package de.entwicklerheld.betterplace.challenge.stage1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

class Stage1 {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Test{
        boolean ignore() default false;
    }

    public static class Assert {

        public static void assertEquals(final Object expected, final Object actual, final String message) {
            if (expected != actual) {
                throw new AssertionError(message + "Expected: " + expected + ", but got: " + actual);
            }
        }

        public static void fail(final String message) {
            throw new AssertionError(message);
        }

    }

}
