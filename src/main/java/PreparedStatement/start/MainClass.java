package PreparedStatement.start;

import Bootstrap.MainInstaller;
import DiContainer.Bootstrap.Container;

public class MainClass 
{
    public static void main(String[] args)
    {
        MainInstaller.InstallBindings();
        
        DOBClientWorkflow dobWorkflow = Container.Resolve(DOBClientWorkflow.class);

        dobWorkflow.ShowMenu();
        /*
        salary
        date format excepton handling
         */
    }
}
