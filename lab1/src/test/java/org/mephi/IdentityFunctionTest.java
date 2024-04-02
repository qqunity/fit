package org.mephi;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import java.util.function.Function;

@RunWith(JUnitQuickcheck.class)
public class IdentityFunctionTest {

    @Property
    public void testIdentityProperties(Integer x) {
        Function<Integer, Integer> f = a -> a * 2;
        Function<Integer, Integer> idA = Function.identity();

        Integer leftIdentity = idA.compose(f).apply(x);
        Integer rightIdentity = f.compose(idA).apply(x);

        assert leftIdentity.equals(f.apply(x));
        assert rightIdentity.equals(f.apply(x));
    }
}