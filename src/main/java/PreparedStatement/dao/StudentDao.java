package PreparedStatement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PreparedStatement.model.Student;
import java.math.BigDecimal;
import java.sql.Date;

public class StudentDao 
{
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public Student fetchByMobileNo(String mobileNo) 
    {
        var student = new Student();
        var connection = ConnectionFactory.getConnection();
        try
        {
            //language=MySQL
            var query = "select * from student where mobileNumber = " + "'" + mobileNo + "'";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                student = fetchStudent();
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                connection.close();
            }
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
        }
        return student;
    }

    public List<Student> searchByName(String firstName, String lastName) 
    {
        var studentList = new ArrayList<Student>();
        var connection = ConnectionFactory.getConnection();
        
        try
        {
            //language=MySQL
            var query = "select * from student where student.firstName = " + "'" + firstName + "'" + " and student.lastName = " + "'" + lastName + "'";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                var student = fetchStudent();
                studentList.add(student);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            } 
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Student> fetchBySalaryRange(BigDecimal lowerSalary, BigDecimal higherSalary) 
    {
        var studentList = new ArrayList<Student>();

        var connection = ConnectionFactory.getConnection();
        
        try 
        {
            //language=MySQL
            var query = "select * from student where salary > " + "'" + lowerSalary + "'" + " and doj < " + "'" + higherSalary + "'";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                var student = fetchStudent();
                studentList.add(student);
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                connection.close();
            }
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Student> fetchByRangeDoj(Date startDate, Date endDate) 
    {
        var studentList = new ArrayList<Student>();

        var connection = ConnectionFactory.getConnection();
        try
        {
            //language=MySQL
            var query = "select * from student where doj >= " + "'" + startDate + "'" + " and doj <= " + "'" + endDate + "'";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                var student = fetchStudent();
                studentList.add(student);
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                connection.close();
            }
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Student> fetchAll()
    {
        var studentList = new ArrayList<Student>();

        var connection = ConnectionFactory.getConnection();
        
        try
        {
            //language=MySQL
            var query = "select * from student order by id desc";
            
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) 
            {
                var student = fetchStudent();
                studentList.add(student);
            }
            
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                connection.close();
            }
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public Student fetchByEmailId(String emailId)
    {
        var student = new Student();
        var connection = ConnectionFactory.getConnection();

        try
        {
            //language=MySQL
            var query  = "select * from student where emailId=?";
            
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, emailId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                student = fetchStudent();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        return student;
    }

    public List<Student> fetchByDob(Date dob)
    {
        var studentList = new ArrayList<Student>();

        var connection = ConnectionFactory.getConnection();

        try
        {
            //language=MySQL
            var query = "select * from student where dateOfBirth=?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, dob);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                var student = fetchStudent();
                studentList.add(student);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Student> fetchByCity(String city)
    {
        var studentList = new ArrayList<Student>();
        var connection = ConnectionFactory.getConnection();

        try
        {
            //language=MySQL
            var query = "select * from student where  city=?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                var student = fetchStudent();
                studentList.add(student);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public Student fetchById(long id)
    {
        var student = new Student();
        var connection = ConnectionFactory.getConnection();

        try
        {
            //language=MySQL
            var query = "select * from student where id=?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                student = fetchStudent();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        return student;
    }

    public int delete(long id)
    {
        var connection = ConnectionFactory.getConnection();
        int status = 0;
        
        try
        {
            //language=MySQL
            var query = "delete from student where id=?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            status = preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            status = -2;
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return status;
    }

    public int update(Student student)
    {
        var connection = ConnectionFactory.getConnection();
        int status = 0;
        
        try
        {
            //language=MySQL
            String query = "update student set firstName=?,lastName=?,address=?,mobileNumber=?,emailId=?,city=?, "
                    + "designation=?,dateOfBirth=?,doj=?,salary=? "
                    + "where id=? ";

            SetTableFields(connection, student, query);

            preparedStatement.setLong(11, student.getId());
            status = preparedStatement.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        return status;
    }

    public int insert(Student student)
    {
        int status;
        var connection = ConnectionFactory.getConnection();

        try
        {
            //language=MySQL
            String query = "insert into student(firstName,lastName,address,mobileNumber,emailId,city,designation,dateOfBirth,doj,salary) "
                    + "values(?,?,?,?,?,?,?,?,?,?)";

            SetTableFields(connection, student, query);

            status = preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            status = -1;
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        return status;
    }

    private Student fetchStudent() throws SQLException
    {
        var student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setFirstName(resultSet.getString("firstName"));
        student.setLastName(resultSet.getString("lastName"));
        student.setAddress(resultSet.getString("address"));
        student.setMobileNumber(resultSet.getString("mobileNumber"));
        student.setMailId(resultSet.getString("emailId"));
        student.setCity(resultSet.getString("city"));
        student.setDesignation(resultSet.getString("designation"));
        student.setDateOfBirth(resultSet.getDate("dateOfBirth"));
        student.setDoj(resultSet.getDate("doj"));
        student.setSalary(resultSet.getBigDecimal("salary"));
        return student;
    }

    private void SetTableFields(Connection connection, Student student, String query) throws SQLException 
    {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setString(3, student.getAddress());
        preparedStatement.setString(4, student.getMobileNumber());
        preparedStatement.setString(5, student.getMailId());
        preparedStatement.setString(6, student.getCity());
        preparedStatement.setString(7, student.getDesignation());
        preparedStatement.setDate(8, student.getDateOfBirth());
        preparedStatement.setDate(9, student.getDoj());
        preparedStatement.setBigDecimal(10, student.getSalary());
    }
}
