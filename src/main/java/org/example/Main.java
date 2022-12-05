package org.example;

import Bootstrap.MainInstaller;
import DiContainer.Bootstrap.Container;
import TestOfTables.Interfaces.IDataBaseAccess;

public class Main 
{
    public static void main(String[] args) 
    {
        MainInstaller.InstallBindings();
        
        IDataBaseAccess dataBaseAccess = Container.Resolve(IDataBaseAccess.class);
        
        dataBaseAccess.AddPublisher("Umar");
        dataBaseAccess.GetAllTitles();
        dataBaseAccess.GetAuthors(true);
        dataBaseAccess.GetPublishers(true);
        dataBaseAccess.RenamePublisher("Art", "Artsiom");
        dataBaseAccess.GetBooksOfPublisher("Penguin", true);
        dataBaseAccess.AddAuthor("ABC", "EFG");
        dataBaseAccess.GetAuthors(true);

        dataBaseAccess.RenameAuthor(76, "Artsiom", "Kim");
        dataBaseAccess.AddTitle("Artsiom", "Kim", "Penguin", "Wonderland", 2003, 3, 12);
    }
}