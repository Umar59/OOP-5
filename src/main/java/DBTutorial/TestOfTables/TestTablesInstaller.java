package DBTutorial.TestOfTables;

import DBTutorial.TestOfTables.Interfaces.IDataBaseAccess;
import DiContainer.Bootstrap.Container;
import DiContainer.Interfaces.IInstaller;

public class TestTablesInstaller implements IInstaller
{

    @Override
    public void InstallBindings() throws Exception 
    {
        Container.Bind(Access.class)
                .ToInterface(IDataBaseAccess.class)
                .AsSingle()
                .Lazy();
    }
}
