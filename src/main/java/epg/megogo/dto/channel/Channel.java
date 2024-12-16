package epg.megogo.dto.channel;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Channel {

    @JsonProperty("result")
    public String result;
    @JsonProperty("data")
    public List<Datum> data;

}
