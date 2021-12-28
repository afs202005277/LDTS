package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    @Test
    public void filter() {
        List<Integer> l = Arrays.asList(1, 2, 3, -15, 0, -2);
        PositiveFilter pos = new PositiveFilter();
        DivisibleByFilter div = new DivisibleByFilter(5);

        ListFilterer g_pos = new ListFilterer(pos);
        ListFilterer g_div = new ListFilterer(div);

        Assertions.assertEquals(Arrays.asList(1, 2, 3), g_pos.filter(l));
        Assertions.assertEquals(Arrays.asList(-15, 0), g_div.filter(l));
    }
}
