package epg.megogo.endpoints;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URL;
import java.util.List;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

public enum MegogoUri {

    TIME( "/time" ),
    CHANNEL( "/channel" ),
    ;

    private final String uri;

    MegogoUri( String uri ) {
        this.uri = uri;
    }

    public URI getTime() {
        return fromUriString( uri ).build().toUri();
    }

    public URI getChannel( String ids ) {
        return fromUriString( uri )
                         .queryParam( "video_ids", ids )
                         .build().toUri();
    }
}
