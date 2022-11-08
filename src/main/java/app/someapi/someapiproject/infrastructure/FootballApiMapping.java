package app.someapi.someapiproject.infrastructure;

import java.util.EnumMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FootballApiMapping {

  public static final int POLISH_LEAGUE_ID = 106;

  @Bean
  public Map<Endpoint, String> urlToEndpoint() {
    Map<Endpoint, String> mapping = new EnumMap<>(Endpoint.class);
    mapping.put(Endpoint.TEAM, "https://api-football-beta.p.rapidapi.com/teams?league=" + POLISH_LEAGUE_ID + "&season=");
    return mapping;
  }
}
