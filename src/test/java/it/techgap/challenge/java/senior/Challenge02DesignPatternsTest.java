package it.techgap.challenge.java.senior;

import it.techgap.challenge.java.senior.Challenge02DesignPatterns.Singleton;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class Challenge02DesignPatternsTest {

    @Test
    public void testConstructor() throws Exception {
        assertEquals("No public constructors allowed!", 0, Singleton.class.getConstructors().length);

        final Constructor<?>[] declaredConstructors = Singleton.class.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            Assert.assertFalse("I can still use your constructor!", declaredConstructor.isAccessible());
            final int modifiers = declaredConstructor.getModifiers();
            Assert.assertFalse("I can still use your constructor!", Modifier.isPublic(modifiers));
            Assert.assertFalse("I can still use your constructor!", Modifier.isProtected(modifiers));
        }
    }

    @Test
    public void testSingleInstance() throws Exception {

        final Field[] declaredFields = Singleton.class.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            if (declaredField.getDeclaringClass().isAssignableFrom(Singleton.class)) {
                final int modifiers = declaredField.getModifiers();
                if ((Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) &&
                        Modifier.isStatic(modifiers) &&
                        !Modifier.isFinal(modifiers)
                        ) {
                    Assert.fail("Cheaters can still override your field!");
                }
            }
        }

        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        assertNotNull("Null is not allowed", a);
        assertNotNull("Null is not allowed", b);
        assertSame(a, b);
        assertEquals(a, b);
    }

    @Test
    public void testMultiThread() throws Exception {
        ExecutorService ex = Executors.newCachedThreadPool();
        final List<Singleton> singletons = IntStream.range(0, 100)
                .mapToObj(x -> ex.submit(Singleton::getInstance))
                .map(f -> {
                    try {
                        return f.get();
                    } catch (final Exception exception) {
                        throw new RuntimeException(exception);
                    }
                })
                .collect(Collectors.toList());

        for (Singleton sA : singletons) {
            for (Singleton sB : singletons) {
                assertNotNull("Null is not allowed", sA);
                assertNotNull("Null is not allowed", sB);
                assertEquals(sA, sB);
                assertSame(sA, sB);
            }
        }
    }
}