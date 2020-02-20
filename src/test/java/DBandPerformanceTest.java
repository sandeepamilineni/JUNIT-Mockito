import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class DBandPerformanceTest {

    @Test
    void returnValueBeforeTimeoutExceeded() {
        final String message = assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50);
            return "a message";
        });
       // assertEquals("a message", message);
    }

    @Test
    void abortIfTimeoutExceeded() {
        final int count = assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            return ((int) IntStream.range(1, 10000000).filter(number -> number % 3 == 0).count());
        });
        System.out.println(count);
    }





}
