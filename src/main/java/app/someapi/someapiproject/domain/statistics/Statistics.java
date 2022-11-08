package app.someapi.someapiproject.domain.statistics;

import lombok.Data;

@Data
public class Statistics {

  private int appearences;
  private int minutes;
  private int goals;

  public double goalsPerMatch(){
    return goals / appearences;
  }

  public double minutesPerMatch(){
    return minutes/appearences;
  }
}
