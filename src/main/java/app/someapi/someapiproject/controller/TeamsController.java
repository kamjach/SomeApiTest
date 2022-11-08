package app.someapi.someapiproject.controller;

import app.someapi.someapiproject.domain.team.Team;
import app.someapi.someapiproject.service.TeamService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class TeamsController {

  private final TeamService teamService;

  @GetMapping("/teams")
  public ResponseEntity<List<Team>> getTeams(@RequestParam int season) {
    return ResponseEntity.ok().body(teamService.showTeamsForSeason(season));
  }

}
