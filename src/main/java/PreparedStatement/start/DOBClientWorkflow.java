package PreparedStatement.start;

import DiContainer.Annotations.Construct;
import PreparedStatement.IDOBMenu;
import PreparedStatement.action.StudentAction;
import PreparedStatement.model.Student;

import java.sql.Date;
import java.util.Scanner;

import static PreparedStatement.start.MenuConsts.*;
import static Utils.StringExtensions.ClearConsole;
import static Utils.StringExtensions.print;

public class DOBClientWorkflow implements IDOBMenu
{
    private final StudentAction action;
    
    @Construct
    public DOBClientWorkflow(StudentAction action)
    {
        this.action = action;
    }
    
    public void ShowMenu()
    {
        int input;

        do
        {
            ClearConsole();
            
            print(MENU_ENTRANCE);
            print(MENU_OPTIONS);
            print(MENU_GUIDE);

            var scanner = new Scanner(System.in);

            input = scanner.nextInt();

            switch (input)
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    fetchAllStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    fetchStudentById();
                    break;
                case 5:
                    fetchStudentByEmail();
                    break;
                case 6:
                    fetchStudentByMobileNumber();
                    break;
                case 7:
                    fetchStudentByName();
                    break;
                case 8:
                    fetchStudentByCity();
                    break;
                case 9:
                    fetchBySalary();
                    break;
                case 10:
                    fetchStudentByDob();
                    break;
                case 11:
                    fetchStudentByDojRange();
                    break;
                case 12:
                    fetchAllStudent();
                    break;
                case 0:
                    print(EXITING_CODE);
                    break;
                default:
                    print(NOT_VALID_ENTRY);
            }
        } while (input != 0);

    }

    private void fetchStudentByDojRange()
    {
        var input = new Scanner(System.in);
        print(ENTER_DATE_OF_BIRTH_START_RANGE);
        var startDate = input.next();
        print(ENTER_DATE_OF_BIRTH_END_RANGE);
        var endDate = input.next();
        
        action.fetchByRangeDoj(Date.valueOf(startDate), Date.valueOf(endDate));
    }

    private void fetchBySalary()
    {
        var input = new Scanner(System.in);
        print(ENTER_SALARY_START_RANGE);
        var salaryStartRange = input.nextBigDecimal();
        print(ENTER_SALARY_END_RANGE);
        var salaryEndRange  = input.nextBigDecimal();

        action.fetchBySalaryRange(salaryStartRange, salaryEndRange);
    }

    private void fetchStudentByName()
    {
        var input = new Scanner(System.in);
        print(ENTER_FIRST_NAME);
        var firstName = input.nextLine();
        print(ENTER_LAST_NAME);
        var lastName = input.nextLine();
        
        action.searchByName(firstName, lastName);
    }

    private void fetchStudentByMobileNumber()
    {
        var input = new Scanner(System.in);
        print(ENTER_MOBILE_NO);
        var mobileNo = input.nextLine();
        
        action.fetchByMobileNo(mobileNo);
    }

    private void fetchStudentByEmail()
    {
        var input = new Scanner(System.in);
        print(ENTER_MAIL_ID);
        var mailId = input.nextLine();
        
        action.fetchByEmailId(mailId);
    }

    private void fetchStudentByDob()
    {
        var input = new Scanner(System.in);
        print(ENTER_DATE_OF_BIRTH);
        var dateOfBirth = input.next();
        
        action.fetchByDob(Date.valueOf(dateOfBirth));
    }

    private void fetchStudentByCity()
    {
        var input = new Scanner(System.in);
        print(ENTER_CITY);
        var city = input.nextLine();
        
        action.fetchByCity(city);
    }

    private void fetchStudentById() 
    {
        var input = new Scanner(System.in);
        print(ENTER_STUDENT_ID);
        var id = input.nextLong();
        
        action.fetchById(id);
    }

    private void deleteStudent()
    {
        var input = new Scanner(System.in);
        print(ENTER_STUDENT_ID);
        var id = input.nextLong();
        
        action.delete(id);
    }

    private void fetchAllStudent()
    {
        action.fetchAll();
    }

    private void updateStudent()
    {
        var student = new Student();
        var input = new Scanner(System.in);

        print(ENTER_STUDENT_ID);
        student.setId(input.nextLong());
        
        FillStudentInfo(student, input);
        action.update(student);
    }
    
    private void addStudent()
    {
        var student = new Student();
        var scanner = new Scanner(System.in);

        FillStudentInfo(student, scanner);
        action.insert(student);
    }

    private void FillStudentInfo(Student student, Scanner insert)
    {
        print(ENTER_FIRST_NAME);
        student.setFirstName(insert.next());
        print(ENTER_LAST_NAME);
        student.setLastName(insert.next());
        print(ENTER_ADDRESS);
        student.setAddress(insert.next());
        print(ENTER_MOBILE_NO);
        student.setMobileNumber(insert.next());
        print(ENTER_MAIL_ID);
        student.setMailId(insert.next());
        print(ENTER_CITY);
        student.setCity(insert.next());
        print(ENTER_DESIGNATION);
        student.setDesignation(insert.next());
        print(ENTER_DATE_OF_BIRTH);
        student.setDateOfBirth(Date.valueOf(insert.next()));
        print(ENTER_DATE_OF_JIRTH);
        student.setDoj(Date.valueOf(insert.next()));
        print(ENTER_SALARY);
        student.setSalary(insert.nextBigDecimal());
    }
}
