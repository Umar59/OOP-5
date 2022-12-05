package Bootstrap;

import DiContainer.Bootstrap.BindingStorage;
import DiContainer.Interfaces.IInstaller;
import TestOfTables.TestTablesInstaller;

import java.util.ArrayList;
import java.util.List;

public class MainInstaller 
{
    private static final List<Class<? extends IInstaller>> installers = new ArrayList<>();
    
    private static void ConfigureInstallers()
    {
        installers.add(TestTablesInstaller.class);
    }
    
    public static void InstallBindings()
    {
        ConfigureInstallers();

       try 
       {
           for (var installer : installers)
           {
               installer
                       .getDeclaredConstructor()
                       .newInstance()
                       .InstallBindings();
           }

            for (var binding : BindingStorage.Bindings) 
            {
                binding.Initialize();
            }
        } 
        catch (Exception e) 
        {
            throw new RuntimeException(e);
        }
    }
}
