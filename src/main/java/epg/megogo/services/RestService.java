package epg.megogo.services;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import epg.megogo.dto.time.Time;
import epg.megogo.dto.channel.Channel;
import epg.megogo.endpoints.MegogoUri;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

public class RestService extends RestAssuredRequests {

    private static final ObjectMapper objectMapper = initializeMapper();
    private final RequestSpecification specification;

    public RestService( String host ) {
        specification = new RequestSpecBuilder().setBaseUri( host )
                                                .setUrlEncodingEnabled( false )
                                                .build();
    }

    private <T> T readValue( String body, Class<T> valueType ) {
        try {
            return objectMapper.readValue( body, valueType );
        } catch ( IOException e ) {
            throw new RuntimeException( "Failed to parse JSON to " + valueType.getSimpleName(), e );
        }
    }

    private static ObjectMapper initializeMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility( objectMapper.getSerializationConfig()
                                                .getDefaultVisibilityChecker()
                                                .withFieldVisibility( JsonAutoDetect.Visibility.DEFAULT ) );
        objectMapper.setSerializationInclusion( JsonInclude.Include.NON_NULL );
        objectMapper.disable( WRITE_DATES_AS_TIMESTAMPS );
        objectMapper.disable( FAIL_ON_UNKNOWN_PROPERTIES );
        objectMapper.disable( FAIL_ON_IGNORED_PROPERTIES );
        return objectMapper;
    }

    public Time getTime() {
        return readValue(
                executeGet(
                        specification,
                        MegogoUri.TIME.getTime()
                ),
                Time.class
        );
    }

    public Channel getChannel( String ids ) {
        return readValue(
                executeGet(
                        specification,
                        MegogoUri.CHANNEL.getChannel( ids )
                ),
                Channel.class
        );
    }

}
