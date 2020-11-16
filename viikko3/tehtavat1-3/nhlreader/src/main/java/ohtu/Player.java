
package ohtu;

public class Player {
    private String name;
    private String team;
    private Integer goals;
    private Integer assists;
    private String nationality;
    private Integer score;

    public void setName(String name) {
        this.name = name;
    }
    public void setTeam(String team) { this.team = team; }
    public void setGoals(int goals) { this.goals = goals; }
    public void setAssists(int assists) { this.assists = assists; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getName() {
        return name;
    }
    public String getTeam() {return team; }
    public Integer getGoals() {return goals; }
    public Integer getAssists() {return assists; }
    public String getNationality() {return nationality; }
    public Integer getScore() {return goals + assists; }

    @Override
    public String toString() {
        return name +  " " + team + " " + goals + " + " + assists + " = " + (goals + assists);
    }
      
}
