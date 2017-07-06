package by.rafalovich.study.simple_jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue( value="NON_PROD" )
@PrimaryKeyJoinColumn(referencedColumnName="EMPL_ID")
public class NonProductionEmployee extends Employee
{
    private String officeAddress;

    @Column(name = "OFFICE_ADDRESS")
    public String getOfficeAddress()
    {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress)
    {
        this.officeAddress = officeAddress;
    }
}
