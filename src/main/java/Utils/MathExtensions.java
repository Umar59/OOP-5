package Utils;

public class MathExtensions
{
    public static boolean isNumeric(String string)
    {
        if (string == null)
            return true;
        try 
        {
            var d = Double.parseDouble(string);
        }
        catch (NumberFormatException exception) 
        {
            return true;
        }
        
        return false;
    }
    
    public static class float2
    {
        public float x;
        public float y;

        public float2(float x, float y) 
        {
            this.x = x;
            this.y = y;
        }
        
        public float[] toArray()
        {
            return new float[] { this.x, this.y };
        }
        
        public boolean equals(float2 other)
        {
            return Float.compare(this.x, other.x) == 0 && Float.compare(this.y, other.y) == 0;
        }
    }

    public static double CalculateFunction(double x, double y)
    {
        double xy2abs = Math.abs(x + y * y);
        double xSquare = x * x;
        return 5 * Math.atan(x) - 0.25d * Math.cos((x + 3 * Math.abs(x - y) + xSquare)/(xy2abs * xy2abs * xy2abs + xSquare * x));
    }
}
