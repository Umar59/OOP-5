package TestOfTables;

import DiContainer.Bootstrap.Container;
import DiContainer.Interfaces.IInstaller;
import TestOfTables.Interfaces.IDataBaseAccess;

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
