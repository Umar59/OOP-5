package DBTutorial.TestOfTables;

import Connection.JDBC;
import DBTutorial.TestOfTables.Interfaces.IDataBaseAccess;

import java.sql.*;

public class Access implements IDataBaseAccess
{
    public void AddAuthor(String firstName, String lastName)
    {
        //language=MySQL
        var addAuthorsTableCommand = "INSERT INTO authors (firstName, lastName)" + "VALUES ('" + firstName + "', '" + lastName + "')";
        Execute(addAuthorsTableCommand);
    }

    public void AddPublisher(String publisherName)
    {
        //language=MySQL
        String updatePublishersTableCommand = "INSERT INTO Publishers (publisherName)" + "VALUES ('" + publisherName + "')";
        Execute(updatePublishersTableCommand);
    }
    
    public void AddTitle(String firstName, String lastName, String publisher, String titleName, int year, int editionNumber, int price)
    {
        //language=MySQL
        String insertIntoTitlesQuery = "INSERT INTO titles(isbn, title, editionNumber, year, publisherID, price)"
                + " VALUES ((SELECT authorID FROM authors WHERE firstName = '" + firstName + "' LIMIT 1), '" + titleName + "', '" + editionNumber + "', '" + year + "'," +
                " (SELECT publisherID FROM publishers WHERE publisherName = '" + publisher + "' LIMIT 1), '" + price + "' )";

        Execute(insertIntoTitlesQuery);
    }

    public void RenamePublisher(String currentName, String newName)
    {
        //language=MySQL
        String updatePublishersTableCommand = "UPDATE books.publishers" + " set publisherName = '" + newName + "'" + " where publisherName = '" + currentName + "'";
        Execute(updatePublishersTableCommand);
    }

    public void RenameAuthor(int id, String firstName, String lastName)
    {
        //language=MySQL
        String updateAuthorsTableCommand = "UPDATE authors" + " set firstName = '" + firstName + "', lastName = '" + lastName + "'" + " where authorID = '" + id + "'";
        Execute(updateAuthorsTableCommand);
    }

    public void GetBooksOfPublisher(String name, boolean IsSorted)
    {
        Statement statement;

        try
        {
            JDBC.setConnection();

            statement = JDBC.connection.createStatement();

            String query;
            
            if (IsSorted)
                //language=MySQL
                query = "SELECT * FROM titles where publisherID = (select publisherID from publishers where publisherName = '" + name + "' limit 1) order by title";
            else
                //language=MySQL
                query = "SELECT * FROM titles where publisherID = (select publisherID from publishers where publisherName = '" + name + "')";

            System.out.println("Titles:");

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
            {
                String title = resultSet.getString("title");
                System.out.println(title);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void GetAllTitles()
    {
        Statement statement;
        try
        {
            JDBC.setConnection();

            statement = JDBC.connection.createStatement();
            //language=MySQL
            String exampleQuery1 = "SELECT * FROM titles";

            System.out.println("Titles:");

            ResultSet resultSet = statement.executeQuery(exampleQuery1);

            while (resultSet.next())
            {
                var isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                String editionNumber = resultSet.getString("editionNumber");
                String year = resultSet.getString("year");
                String publisherID = resultSet.getString("publisherID");
                String price = resultSet.getString("price");
                System.out.println(isbn + "\t" + title + "\t" + editionNumber + "\t" + year + "\t" + publisherID + "\t" + price);
            }
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        finally
        {
            JDBC.closeConnection();
        }
    }

    public void GetAuthors(boolean IsSorted)
    {
        Statement statement;

        try
        {
            JDBC.setConnection();

            statement = JDBC.connection.createStatement();

            String query;

            if (IsSorted)
                //language=MySQL
                query = "SELECT * FROM authors ORDER BY firstName, lastName";
            else
                //language=MySQL
                query = "SELECT * FROM authors";

            System.out.println("Authors:");

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
            {
                var authorID = resultSet.getInt("authorID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                System.out.println(authorID + "\t" + firstName + "\t" + lastName);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void GetPublishers(boolean IsSorted)
    {
        Statement statement;

        try
        {
            JDBC.setConnection();

            statement = JDBC.connection.createStatement();

            String query;

            if (IsSorted)
                //language=MySQL
                query = "SELECT * FROM publishers ORDER BY publisherName";
            else
                //language=MySQL
                query = "SELECT * FROM authors";

            System.out.println("Publishers:");

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
            {
                String publishersName = resultSet.getString("publisherName");
                System.out.println(publishersName);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    private void Execute(String command)
    {
        Statement statement;

        try
        {
            JDBC.setConnection();

            statement = JDBC.connection.createStatement();
            
            try
            {
                statement.executeUpdate(command);
            }
            catch (SQLException e)
            {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
