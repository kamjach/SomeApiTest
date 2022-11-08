package app.someapi.someapiproject.infrastructure.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import lombok.Getter;

@Getter
public class TeamsResponse {

  @JsonProperty("get")
  private String getName;

  @JsonProperty("parameters")
  private Object params;

  @JsonProperty("errors")
  private Object[] error;

  @JsonProperty("results")
  private int result;

  @JsonProperty("response")
  private ArrayList<LinkedHashMap> response;

}
