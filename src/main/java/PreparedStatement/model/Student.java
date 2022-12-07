package PreparedStatement.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Student 
{
    //region Getters
    public long getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public String getMailId()
    {
        return mailId;
    }

    public String getCity()
    {
        return city;
    }

    public String getDesignation()
    {
        return designation;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public Date getDoj()
    {
        return doj;
    }

    public BigDecimal getSalary()
    {
        return salary;
    }

    public Timestamp getAddDate()
    {
        return addDate;
    }
    //endregion

    //region Setters
    public void setId(long id)
    {
        this.id = id;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public void setMailId(String mailId) 
    {
        this.mailId = mailId;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public void setDesignation(String designation) 
    {
        this.designation = designation;
    }

    public void setDateOfBirth(Date dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDoj(Date doj)
    {
        this.doj = doj;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }

    public void setAddDate(Timestamp addDate) 
    {
        this.addDate = addDate;
    }
    
    //endregion

    //region Private Fields
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String mailId;
    private String city;
    private String designation;
    private Date dateOfBirth;
    private Date doj;
    private BigDecimal salary;
    private Timestamp addDate;
    
    //endregion
    
    public Student(){}

    public Student(long id, String fname, String lname, String address, String mobileNo, String mailId, String city, String designation, Date dob, Date doj, BigDecimal salary) {
        this.id = id;
        this.firstName = fname;
        this.lastName = lname;
        this.address = address;
        this.mobileNumber = mobileNo;
        this.mailId = mailId;
        this.city = city;
        this.designation = designation;
        this.dateOfBirth = dob;
        this.doj = doj;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Student{" + "id =" + id + ", " +
                "firstName =" + firstName + ", " +
                "lastName =" + lastName + ", " +
                "address =" + address + ", " +
                "mobileNumber =" + mobileNumber + ", " +
                "mailId =" + mailId + ", " +
                "city =" + city + ", " +
                "designation =" + designation + ", " +
                "dateOfBirth =" + dateOfBirth + ", " +
                "doj =" + doj + ", " +
                "salary =" + salary + ", " +
                "addDate =" + addDate + '}';
    }
}


