package ejb;
import javax.ejb.Singleton;

@Singleton
public class CountServletHitsBean {
    private int hitCount;
    public synchronized int getCount()
    {
        return hitCount++;
    }
}
