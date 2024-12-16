package dto.time;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Time implements Serializable {

    @JsonProperty("result")
    public String result;
    @JsonProperty("data")
    public TimeData data;

    @Override
    public String toString() {
        return "ApiResponse{" +
                "result='" + result + '\'' +
                ", data=" + data +
                '}';
    }
}