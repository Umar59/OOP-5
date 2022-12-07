package PreparedStatement.action;

import DiContainer.Annotations.Construct;
import PreparedStatement.dao.StudentDao;
import PreparedStatement.model.Student;

import java.math.BigDecimal;
import java.sql.Date;

import static PreparedStatement.start.MenuConsts.*;
import static Utils.StringExtensions.print;

public class StudentAction
{
    private final StudentDao studentDataAccessObject;
    
    @Construct
    public StudentAction(StudentDao studentDataAccessObject)
    {
        this.studentDataAccessObject = studentDataAccessObject;
    }

    public void insert(Student student)
    {
        var status = studentDataAccessObject.insert(student);
        
        if (status == 1) 
        {
            print(STUDENT_INSERTED_SUCCESSFULLY);
        } 
        else if (status == -1)
        {
            print(STUDENT_ALREADY_EXISTS);
        }
        else
        {
            print(UNABLE_TO_INSERT_STUDENT);
        }
    }

    public void update(Student student)
    {
        var status = studentDataAccessObject.update(student);
        
        if (status == 1)
        {
            print(STUDENT_UPDATED_SUCCESSFULLY);
        }
        else
        {
            print(UNABLE_TO_UPDATE_STUDENT);
        }
    }

    public void delete(Long id)
    {
        var status = studentDataAccessObject.delete(id);
        
        if (status == 1)
        {
            print(STUDENT_DELETED_SUCCESSFULLY);
        }
        else
        {
            print(NO_RECORD_FOUND);
        }
    }

    public void fetchById(Long id)
    {
        var student = studentDataAccessObject.fetchById(id);
        
        if (student.getId() == 0)
        {
            print(NO_RECORD_FOUND);
        }
        else
        {
            print(STUDENT_DETAILS_ARE);
            print(student.toString());
        }
    }

    public void fetchByEmailId(String emailId) 
    {
        var student = studentDataAccessObject.fetchByEmailId(emailId);
        
        if (student.getId() == 0)
        {
            print(NO_RECORD_FOUND);
        }
        else
        {
            print(STUDENT_DETAILS_ARE);
            print(student.toString());
        }
    }

    public void fetchByMobileNo(String mobileNo) 
    {
        var student = studentDataAccessObject.fetchByMobileNo(mobileNo);
        
        if (student.getId() == 0) 
        {
            print(NO_RECORD_FOUND);
        }
        else
        {
            print(STUDENT_DETAILS_ARE);
            print(student.toString());
        }
    }

    public void searchByName(String firstName, String lastName)
    {
        var studentList = studentDataAccessObject.searchByName(firstName, lastName);
        
        if (studentList.isEmpty()) 
        {
            print(NO_RECORD_FOUND);
        }
        else
        {
            print(STUDENT_DETAILS_ARE);
            
            for (var student : studentList) 
            {
                print(student.toString());
            }
        }

    }

    public void fetchByCity(String city)
    {
        var studentList = studentDataAccessObject.fetchByCity(city);
        
        if (studentList.isEmpty()) 
        {
            print(NO_RECORD_FOUND);
        }
        else 
        {
            print(STUDENT_DETAILS_ARE);
            
            for (var student : studentList) 
            {
                print(student.toString());
            }
        }
    }

    public void fetchBySalaryRange(BigDecimal salaryStartRange, BigDecimal salaryEndRange) 
    {
        var studentList = studentDataAccessObject.fetchBySalaryRange(salaryStartRange, salaryEndRange);
        
        if (studentList.isEmpty()) 
        {
            print(NO_RECORD_FOUND);
        }
        else 
        {
            print(STUDENT_DETAILS_ARE);
            
            for (var student : studentList) 
            {
                print(student.toString());
            }
        }
    }

    public void fetchByDob(Date dateOfBirth)
    {
        var studentList = studentDataAccessObject.fetchByDob(dateOfBirth);
        
        if (studentList.isEmpty()) 
        {
            print(NO_RECORD_FOUND);
        }
        else
        {
            print(STUDENT_DETAILS_ARE);
            
            for (var student : studentList) 
            {
                print(student.toString());
            }
        }
    }

    public void fetchByRangeDoj(Date dobStartRange, Date dobEndRange) 
    {
        var studentList = studentDataAccessObject.fetchByRangeDoj(dobStartRange, dobEndRange);
        
        if (studentList.isEmpty()) 
        {
            print(NO_RECORD_FOUND);
        }
        else
        {
            print(STUDENT_DETAILS_ARE);
            
            for (var student : studentList) 
            {
                print(student.toString());
            }
        }
    }

    public void fetchAll()
    {
        var studentList = studentDataAccessObject.fetchAll();
        
        if (studentList.isEmpty()) 
        {
            print(NO_RECORD_FOUND);
        }
        else
        {
            print(STUDENT_DETAILS_ARE);
            
            for (var student : studentList) 
            {
                print(student.toString());
            }
        }
    }

}
