package org.mephi;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RunWith(JUnitQuickcheck.class)
public class FunctionEqualityTest {

    private static final List<Function<Integer, Integer>> functions = new ArrayList<>();

    static {
        functions.add(a -> a * 2);
        functions.add(a -> a << 1);
    }

    private Function<Integer, Integer> getFunction(@InRange(minInt = 0, maxInt = 1) int index) {
        return functions.get(index);
    }

    @Property
    public void testExtensionalEquality(Integer x,
                                        @InRange(minInt = 0, maxInt = 1) int index1,
                                        @InRange(minInt = 0, maxInt = 1) int index2) {
        Function<Integer, Integer> f = getFunction(index1);
        Function<Integer, Integer> g = getFunction(index2);

        assert f.apply(x).equals(g.apply(x));
    }
}