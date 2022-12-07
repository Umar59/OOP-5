package org.example;

import Bootstrap.MainInstaller;
import DiContainer.Bootstrap.Container;
import DBTutorial.TestOfTables.Interfaces.IDataBaseAccess;

public class Main 
{
    public static void main(String[] args) 
    {
        MainInstaller.InstallBindings();
        
        fifthLab();
    }

    private static void fifthLab()
    {
        IDataBaseAccess dataBaseAccess = Container.Resolve(IDataBaseAccess.class);

        if (dataBaseAccess == null) return;

        dataBaseAccess.RenameAuthor(76, "Artsiom", "Kim");
        dataBaseAccess.AddTitle("Artsiom", "Kim", "Penguin", "Wonderland", 2003, 3, 12);
        
        dataBaseAccess.AddPublisher("Umar");
        dataBaseAccess.GetAllTitles();
        dataBaseAccess.GetAuthors(true);
        dataBaseAccess.GetPublishers(true);
        dataBaseAccess.RenamePublisher("Art", "Artsiom");
        dataBaseAccess.GetBooksOfPublisher("Penguin", true);
        dataBaseAccess.AddAuthor("ABC", "EFG");
        dataBaseAccess.GetAuthors(true);
    }
}