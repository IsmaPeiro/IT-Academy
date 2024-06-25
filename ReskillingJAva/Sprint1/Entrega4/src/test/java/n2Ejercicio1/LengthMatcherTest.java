package n2Ejercicio1;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matcher;
import org.hamcrest.FeatureMatcher;
import org.junit.jupiter.api.Test;

class LengthMatcherTest {
    @Test
    public void testStringLength() {
        LengthMatcher test = new LengthMatcher("Mordor");
        assertThat(test.getStr(), length(is(8)));
    }
    
    public static Matcher<String> length(Matcher<? super Integer> matcher) {
        return new FeatureMatcher<String, Integer>(matcher, "a String of length that", "length") {
            @Override
            protected Integer featureValueOf(String actual) {
                return actual.length();
            }
        };
    }
}