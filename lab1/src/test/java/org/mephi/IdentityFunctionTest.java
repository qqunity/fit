package org.mephi;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RunWith(JUnitQuickcheck.class)
public class IdentityFunctionTest {

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
    public void testIdentityProperties(Integer x, @InRange(minInt = 0, maxInt = 3) int index) {
        Function<Integer, Integer> f = getFunction(index);
        Function<Integer, Integer> idA = Function.identity();

        Integer leftIdentity = idA.compose(f).apply(x);
        Integer rightIdentity = f.compose(idA).apply(x);

        assert leftIdentity.equals(f.apply(x));
        assert rightIdentity.equals(f.apply(x));
    }
}
