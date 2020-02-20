import com.giffgaff.main.ToDoApp;
import com.giffgaff.utility.MiscUtility;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoAppTest {

    MiscUtility toDoApp;
    String words[] = {"Rocket","Launch","Fueling","Build"};
    @BeforeAll
    static void toSetBeforeAllTests(){
        System.out.println("call from toSetBeforeAllTests");
    }

    @BeforeEach
    public void practiceBeforeEachOne(){
        System.out.println("Before each");
        if(toDoApp==null) {
            toDoApp = new MiscUtility();
        }
    }

    @Test
    @DisplayName("truncateAInFirst2Positions")
        void truncateAInFirst2Positions() {
        System.out.println("call from truncateAInFirst2Positions");
        assertEquals("CD", toDoApp.truncateAInFirst2Positions("AACD"));
        assertEquals("CD DS", toDoApp.truncateAInFirst2Positions("CD DS"));
        assertEquals("-CD", toDoApp.truncateAInFirst2Positions("A-CD"));
        assertEquals("CD", toDoApp.truncateAInFirst2Positions("aacd"));
    }

    @Test
    @ParameterizedTest
    @CsvSource({ "CD, AACD", "CD DS, CD DS", "-CD, A-CD","CD,aacd" })
    void truncateAInFirst2PositionsParameterized(String expected, String actual){
        assertEquals(expected, toDoApp.truncateAInFirst2Positions(actual));
    }
    @Test
    @DisplayName("getMaxNumber")
    void getMaxNumber(){
        System.out.println("getMaxNumber");
        assertEquals(1, toDoApp.getMaxNumber(0,1));
    }

    @Test
    @DisplayName("testNullAssertion")
    void testNullAssertion(){
        assertNotNull(toDoApp, "ToDoApp not null");
    }

    @Test
    @DisplayName("compare sorted list")
    public void compareWords(){
        String[] sortedWords = {"Build","Fueling","Launch","Rocket"};
        assertArrayEquals(sortedWords,toDoApp.sortWords(words));
        System.out.println(toDoApp.sortWords(words));
    }

    @Test
    @DisplayName("test an expected Exception")
    void testExpectedException(){
        String s =null;
        assertThrows(NullPointerException.class,() -> {
                s.substring(4);
        });
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(strings = { "Hello", "JUnit" , "Java" })
    void withValueSource(String word) {
        assertTrue(word.length()>4);
    }

    @Disabled
    @ParameterizedTest
    @CsvFileSource(resources = "/courses.csv", numLinesToSkip = 1)
    @DisplayName("CSV file course")
    void test_csv_file(int length, String course) {
        assertTrue(course.contains("java"));
    }

        @Nested
    class MiscTests{

        @Test
        public void assertEquality(){
            System.out.println("assertEquality  ");
            String actual = "SA";
            Assertions.assertNotEquals("SA",actual,"Hello");
        }

        @Test
        public void assertCondition(){
            System.out.println("assertCondition  ");
            int i=1,j=2;
            boolean condition = i==j;
            assertTrue(condition);
        }
    }
}
