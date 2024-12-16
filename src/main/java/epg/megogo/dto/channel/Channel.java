package epg.megogo.dto.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Channel {

    @JsonProperty( "result" )
    public String result;
    @JsonProperty( "data" )
    public List<Datum> data;

}
