package app.someapi.someapiproject.domain.player;

import app.someapi.someapiproject.domain.player.vo.Status;
import app.someapi.someapiproject.domain.player.vo.Position;
import app.someapi.someapiproject.domain.statistics.Statistics;
import app.someapi.someapiproject.domain.team.Team;
import lombok.Data;

@Data
public class Player {

  private Team team;
  private Status status;
  private Statistics statistics;
  private Position position;
  private String nationality;

}
