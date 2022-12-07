package PreparedStatement;

import DiContainer.Bootstrap.Container;
import DiContainer.Interfaces.IInstaller;
import PreparedStatement.action.StudentAction;
import PreparedStatement.dao.StudentDao;
import PreparedStatement.start.DOBClientWorkflow;

public class Installer implements IInstaller
{
    @Override
    public void InstallBindings() throws Exception 
    {
        Container
                .Bind(DOBClientWorkflow.class)
                .AsSingle()
                .Lazy();
        Container
                .Bind(StudentAction.class)
                .AsSingle()
                .Lazy();
        Container
                .Bind(StudentDao.class)
                .AsSingle()
                .Lazy();
    }
}
