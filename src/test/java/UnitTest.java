import app.Calculator;
import app.Summator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class UnitTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private Calculator calculator;

    @Mock
    private Summator summator;

    private int sum1;
    private int sum2;
    private int result;

    public UnitTest(int sum1, int sum2, int result) {
        this.sum1 = sum1;
        this.sum2 = sum2;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0}, {1, 1, 2}, {2, 1, 3}, {3, 2, 5}, {4, 3, 7}, {5, 5, 10}, {6, 8, 14}
        });
    }
    @Test
    public void test() {

        when(calculator.sum(sum1, sum2)).thenReturn(result);
        int actualResult = calculator.sum(sum1, sum2);


        assertEquals(result, actualResult);
    }
}