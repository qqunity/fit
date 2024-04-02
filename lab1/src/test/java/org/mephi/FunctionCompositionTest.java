package org.mephi;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import java.util.function.Function;

@RunWith(JUnitQuickcheck.class)
public class FunctionCompositionTest {

    @Property
    public void testAssociativity(Integer x) {
        Function<Integer, Integer> f = a -> a + 1;
        Function<Integer, Integer> g = a -> a * 2;
        Function<Integer, Integer> h = a -> a - 1;

        Integer result1 = f.apply(g.apply(h.apply(x)));
        Integer result2 = f.compose(g).compose(h).apply(x);

        assert result1.equals(result2);
    }
}