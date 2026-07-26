public class Fraction
{
    private int num;
    private int den;

    public Fraction(int num, int den)
    {
        this.num = num;
        this.den = den;

        int g = gcd(num, den);

        this.num = num / g;
        this.den = den / g;
    }

    public int gcd(int a, int b)
    {
        while(b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String toString()
    {
        return num + "/" + den;
    }

    public boolean equals(Object obj)
    {
        Fraction f = (Fraction)obj;

        if(num == f.num && den == f.den)
            return true;
        else
            return false;
    }

    public int hashCode()
    {
        return num + den;
    }
}