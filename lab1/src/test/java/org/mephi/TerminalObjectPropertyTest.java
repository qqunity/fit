package org.mephi;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import java.util.function.Function;

@RunWith(JUnitQuickcheck.class)
public class TerminalObjectPropertyTest {

    public static Function<Integer, Void> intToVoid = x -> null;

    public static Function<String, Void> stringToVoid = x -> null;

    @Property
    public <T> void testFunctionWithGenericParameter(T input, Function<T, Void> function) {
        assert function.apply(input) == null;
    }

    @Property
    public void testWithInteger(Integer x) {
        assert intToVoid.apply(x) == null;
    }

    @Property
    public void testWithString(String x) {
        assert stringToVoid.apply(x) == null;
    }
}