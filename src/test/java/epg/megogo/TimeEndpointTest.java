package epg.megogo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import epg.megogo.services.RestService;

import java.time.Instant;

import static org.testng.Assert.assertTrue;

public class TimeEndpointTest {

    private RestService restService;
    private final String host = "https://epg.megogo.net/";

    @BeforeMethod( alwaysRun = true )
    public void beforeMethod() {
        restService = new RestService( host );
    }

    @Test
    public void checkThatServerTimeIsCorrect() {
        long requestStart = Instant.now().getEpochSecond();
        long serverTime = restService.getTime().getData().getTimestamp();
        long requestEnd = Instant.now().getEpochSecond();
        assertTrue(serverTime >= requestStart && serverTime <= requestEnd,
                   "Server time is outside the expected range.");
    }
}
