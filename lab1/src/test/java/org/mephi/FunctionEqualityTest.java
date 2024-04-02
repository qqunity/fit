package org.mephi;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import java.util.function.Function;

@RunWith(JUnitQuickcheck.class)
public class FunctionEqualityTest {

    @Property
    public void testExtensionalEquality(Integer x) {
        Function<Integer, Integer> f = a -> a * 2;
        Function<Integer, Integer> g = a -> a << 1;

        assert f.apply(x).equals(g.apply(x));
    }
}