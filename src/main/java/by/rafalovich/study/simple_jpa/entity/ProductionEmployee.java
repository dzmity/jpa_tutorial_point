package by.rafalovich.study.simple_jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value="PROD" )
public class ProductionEmployee extends Employee
{
    private String commandName;
    private String positionTitle;

    @Column(name = "COMMAND_NAME")
    public String getCommandName()
    {
        return commandName;
    }

    public void setCommandName(String commandName)
    {
        this.commandName = commandName;
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
