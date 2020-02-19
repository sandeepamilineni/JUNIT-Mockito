import com.giffgaff.main.ToDoApp;
import com.giffgaff.utility.MiscUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoAppTest {

    MiscUtility toDoApp = new MiscUtility();

    @Test
        void truncateAInFirst2Positions() {
        assertEquals("CD", toDoApp.truncateAInFirst2Positions("AACD"));
        assertEquals("CD DS", toDoApp.truncateAInFirst2Positions("CD DS"));
        assertEquals("-CD", toDoApp.truncateAInFirst2Positions("A-CD"));
        assertEquals("CD", toDoApp.truncateAInFirst2Positions("aacd"));
    }

    @Nested
    class MiscTests{

        @Test
        public void assertEquality(){
            String actual = "SA";
            Assertions.assertNotEquals("SA",actual,"Hello");

        }

        @Test
        public void assertCondition(){
            String actual = "SA";
            boolean condition = false;
            assertTrue(condition);
        }
    }
}
