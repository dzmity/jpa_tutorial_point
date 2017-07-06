package by.rafalovich.study.simple_jpa.entity;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.AccessType.PROPERTY;

@Entity
@Table(name = "DEV_TEAM")
@Access(value = PROPERTY)
public class DevelopmentTeam
{
    private Long teamId;
    private String teamName;

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    @Column(name = "DEV_TEAM_ID")
    public Long getTeamId()
    {
        return teamId;
    }

    public void setTeamId(Long teamId)
    {
        this.teamId = teamId;
    }

    @Column(name = "DEV_TEAM_NAME")
    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }
}
