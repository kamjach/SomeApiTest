package app.someapi.someapiproject.service;

import static java.util.Objects.isNull;

import app.someapi.someapiproject.domain.team.Team;
import app.someapi.someapiproject.infrastructure.Endpoint;
import app.someapi.someapiproject.infrastructure.FootballApiMapping;
import app.someapi.someapiproject.infrastructure.response.TeamsResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TeamService {

  private final RestTemplate restTemplate;
  private final Map<Endpoint, String> urlToEndpoint;
  private final List<Team> teams = new ArrayList<>();

  public List<Team> showTeamsForSeason(int season) {
    TeamsResponse apiResponse = restTemplate.getForObject(urlToEndpoint.get(Endpoint.TEAM).concat(String.valueOf(season)), TeamsResponse.class);
    if (isNull(apiResponse.getResponse())) {
      throw new NoSuchElementException("No teams in response");
    }
    apiResponse.getResponse().forEach(team -> {
      var singleTeam = (HashMap<String, String>) team.get("team");
      teams.add(new Team(String.valueOf(FootballApiMapping.POLISH_LEAGUE_ID), singleTeam.get("name")));
    });

    return teams;
  }
}
