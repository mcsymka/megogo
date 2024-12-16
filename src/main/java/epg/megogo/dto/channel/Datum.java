package epg.megogo.dto.channel;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Datum {

    @JsonProperty("id")
    public Long id;
    @JsonProperty("external_id")
    public Long externalId;
    @JsonProperty("title")
    public String title;
    @JsonProperty("video_id")
    public Long videoId;
    @JsonProperty("programs")
    public List<Program> programs;

}
