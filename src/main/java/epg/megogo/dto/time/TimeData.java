package epg.megogo.dto.time;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TimeData {

    @JsonProperty("utc_offset")
    public Long utcOffset;
    @JsonProperty("timestamp_gmt")
    public Long timestampGmt;
    @JsonProperty("timestamp_local")
    public Long timestampLocal;
    @JsonProperty("timezone")
    public String timezone;
    @JsonProperty("time_local")
    public String timeLocal;
    @JsonProperty("timestamp")
    public Long timestamp;
}
