package epg.megogo;

import epg.megogo.dto.channel.Datum;
import epg.megogo.dto.channel.Program;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import epg.megogo.services.RestService;

import java.time.Instant;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChannelEndpointTest {

    private RestService restService;
    private final String host = "https://epg.megogo.net/";

    @BeforeMethod( alwaysRun = true )
    public void beforeMethod() {
        restService = new RestService( host );
    }

    @DataProvider( name = "video_id" )
    public static Object[][] getVideoId() {
        return new Object[][]{
                { "1639111" },
                { "1585681" },
                { "1639231" }
        };
    }

    @Test( dataProvider = "video_id" )
    public void testThatProgramsSortedByStartTimestamp( String id ) {
        List<Datum> data = restService.getChannel( id ).getData();
        List<Program> programs = data.getFirst().getPrograms();
        long previousTimestamp = 0;
        for ( Program program : programs ) {
            long startTimestamp = program.getStartTimestamp();
            assertTrue(
                    startTimestamp >= previousTimestamp,
                    "Programs are not sorted by start_timestamp."
            );
            previousTimestamp = startTimestamp;
        }
    }

    @Test( dataProvider = "video_id" )
    public void testThatCurrentProgramExists( String id ) {
        long currentTime = Instant.now().getEpochSecond();
        List<Datum> data = restService.getChannel( id ).getData();
        List<Program> programs = data.getFirst().getPrograms();
        boolean exists = programs.stream().anyMatch(
                program -> currentTime >= program.getStartTimestamp() &&
                        currentTime <= program.getEndTimestamp() );
        assertTrue( exists, "No current program exists in the schedule." );
    }

    @Test( dataProvider = "video_id" )
    public void testThatNoProgramsFromPastAndMoreThan24Hours( String id ) {
        List<Datum> data = restService.getChannel( id ).getData();
        List<Program> programs = data.getFirst().getPrograms();
        long currentTime = Instant.now().getEpochSecond();
        boolean allValid = programs.stream().allMatch(
                program -> program.getEndTimestamp() >= currentTime &&
                        program.getStartTimestamp() <= currentTime + 24 * 3600
        );
        assertTrue( allValid, "There are programs outside the valid 24-hour range." );
    }
}
