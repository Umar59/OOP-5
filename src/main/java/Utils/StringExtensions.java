package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringExtensions 
{
    public static void print(String string )
    {
        System.out.println(string);
    }
    
    public static void ClearConsole()
    {
        System.out.flush();
    }
    
    public static void CreateMenuString(String string)
    {
        print("\n" + string + "\n");
    }
    
    public static String TakeInputField()
    {
        var input = "";
        var reader = new BufferedReader(new InputStreamReader(System.in));
        
        try 
        {
            input = reader.readLine();
        }
        catch (IOException ignored){}
        
        return input;
    }
}
