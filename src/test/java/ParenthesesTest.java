import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scene.Parentheses;

public class ParenthesesTest {

    @Test
    public void Test() {
        String test = "[()]{}{[()()]()}";
        Parentheses parentheses = new Parentheses();
        boolean res = parentheses.t(test);
        Assertions.assertTrue(res);
    }


    @Test
    public void Test2() {
        String test = "[(])";
        Parentheses parentheses = new Parentheses();
        boolean res = parentheses.t(test);
        Assertions.assertFalse(res);
    }
}
