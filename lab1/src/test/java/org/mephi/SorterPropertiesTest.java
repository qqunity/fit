package org.mephi;

import static org.junit.Assert.assertTrue;
import java.util.List;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class SorterPropertiesTest {
    @Property
    public void increasingOrder(List<Integer> unsorted) {
        List<Integer> sorted = Sorter.sort(unsorted);
        for (int i = 0; i < sorted.size() - 1; i++) {
            assertTrue(sorted.get(i) <= sorted.get(i + 1));
        }
    }

    @Property
    public void sameElements(List<Integer> unsorted) {
        List<Integer> sorted = Sorter.sort(unsorted);
        assertTrue(unsorted.size() == sorted.size() &&
                unsorted.containsAll(sorted) &&
                sorted.containsAll(unsorted));
    }
}