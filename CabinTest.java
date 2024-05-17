import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Bryan Munoz-Romero
 */
public class CabinTest {
    private Cabin cabin;

    @Test
    public void testNegativeNumOfCamps() { // Bryan Munoz-Romero
        cabin = new Cabin(-3);

        assertFalse(cabin.getCabinNum() < 0);
    }

    @Test
    public void testSetScheduleToNullCamps() { // Bryan Munoz-Romero
        cabin = new Cabin(3);

        cabin.setSchedule(null);

        assertNull(cabin.getSchedule().toString());
    }

    @Test
    public void testSetCounselorToNull() { // Bryan Munoz-Romero
        cabin = new Cabin(5);

        cabin.setCounselor(null);

        assertNull(cabin.getCounselor().toString());
    }

    @Test
    public void testSetCamperToNull() { // Bryan Munoz-Romero
        cabin = new Cabin(5);
        cabin.addCamper(null);
        assertNull(cabin.getCampers().toString());
    }

    @Test
    public void testPrintScheduleDayToNeg() { // Bryan Munoz-Romero
        cabin = new Cabin(5);
        assertNull(cabin.printScheduleDay(-1, -1, -1));
    }
}
