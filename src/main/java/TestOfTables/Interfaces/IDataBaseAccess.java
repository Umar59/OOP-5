package TestOfTables.Interfaces;

public interface IDataBaseAccess 
{
    void AddPublisher(String publisherName);
    void AddAuthor(String firstName, String lastName);
    void AddTitle(String firstName, String lastName, String publisher, String titleName, int year, int editionNumber, int price);
    void RenamePublisher(String currentName, String newName);
    void RenameAuthor(int id, String firstName, String lastName);
    void GetAllTitles();
    void GetAuthors(boolean IsSorted);
    void GetPublishers(boolean IsSorted);
    void GetBooksOfPublisher(String name, boolean IsSorted);
}
