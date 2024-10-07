package mybean;
import javax.ejb.Stateless;
@Stateless
public class Operations {
  public int add(int n1, int n2) {
    return n1 + n2;
  }
  public int sub(int n1, int n2) {
    return n1 - n2;
  }
  public int mul(int n1, int n2) {
    return n1 * n2;
  }
  public int div(int n1, int n2) {
    return n1 / n2;
  }

  public int mod(int n1, int n2) {
    return n1 % n2;
  }
}
