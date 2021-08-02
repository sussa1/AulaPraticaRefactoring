import java.util.Enumeration;

public abstract class Statement {
  protected abstract String getResultName(Customer aCustomer);

  protected abstract String getFigures(Rental each);

  protected abstract String getFooterLines(Customer aCustomer);

  public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = getResultName(aCustomer);
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += getFigures(each);
      }
      result += getFooterLines(aCustomer);
      return result;
   }
}
