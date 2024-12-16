package dto.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Program {

    @JsonProperty("external_id")
    public Long externalId;
    @JsonProperty("title")
    public String title;
    @JsonProperty("start_timestamp")
    public Long startTimestamp;
    @JsonProperty("end_timestamp")
    public Long endTimestamp;
    @JsonProperty("id")
    public Long id;
    @JsonProperty("start")
    public String start;
    @JsonProperty("end")
    public String end;
    @JsonProperty("virtual_object_id")
    public String virtualObjectId;
    @JsonProperty("schedule_type")
    public String scheduleType;

}
