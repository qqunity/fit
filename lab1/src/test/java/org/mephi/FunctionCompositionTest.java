package org.mephi;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RunWith(JUnitQuickcheck.class)
public class FunctionCompositionTest {

    private static final List<Function<Integer, Integer>> functions = new ArrayList<>();

    static {
        functions.add(a -> a * 2);
        functions.add(a -> a + 100);
        functions.add(a -> a - 5);
        functions.add(a -> a / 2);
    }

    private Function<Integer, Integer> getFunction(@InRange(minInt = 0, maxInt = 3) int index) {
        return functions.get(index);
    }

    @Property
    public void testIdentityProperties(Integer x,
                                       @InRange(minInt = 0, maxInt = 3) int index1,
                                       @InRange(minInt = 0, maxInt = 3) int index2,
                                       @InRange(minInt = 0, maxInt = 3) int index3) {
        Function<Integer, Integer> f = getFunction(index1);
        Function<Integer, Integer> g = getFunction(index2);
        Function<Integer, Integer> h = getFunction(index3);

        Integer result1 = f.apply(g.apply(h.apply(x)));
        Integer result2 = f.compose(g).compose(h).apply(x);

        assert result1.equals(result2);
    }
}