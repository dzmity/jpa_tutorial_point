package by.rafalovich.study.simple_jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue( value="PROD" )
//@PrimaryKeyJoinColumn(referencedColumnName="EMPL_ID")
public class ProductionEmployee extends Employee
{
    private DevelopmentTeam developmentTeam;
    private String positionTitle;

    @OneToOne
    public DevelopmentTeam getDevelopmentTeam()
    {
        return developmentTeam;
    }

    public void setDevelopmentTeam(DevelopmentTeam developmentTeam)
    {
        this.developmentTeam = developmentTeam;
    }

    @Column(name = "POSITION_TITLE")
    public String getPositionTitle()
    {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle)
    {
        this.positionTitle = positionTitle;
    }
}
