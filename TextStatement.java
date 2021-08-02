import java.util.Enumeration;

public class TextStatement extends Statement {
  public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = getResultName(aCustomer);
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for this rental
         result += getFigures(each);
      }
      //add footer lines
      result += getFooterLines(aCustomer);
      return result;
   }

   private String getResultName(Customer aCustomer) {
    return "Rental Record for " + aCustomer.getName() + "\n";
  }

  private String getFigures(Rental each) {
    return "\t" + each.getMovie().getTitle()+ "\t" + String.valueOf(each.getCharge()) + "\n";
  }

  private String getFooterLines(Customer aCustomer) {
    return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n" +
      "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " frequent renter points";
  }
}
