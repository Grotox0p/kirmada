package mybeans;

import javax.ejb.Stateless;

@Stateless
public class CCBean 
{
    public double r2Dollars(double r)
    {
        return r/83.97;
    }
    public double d2Rupees(double d)
    {
        return d*83.97;
    }
}
