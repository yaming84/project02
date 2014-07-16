/**
 * an object of this class is 
 * 
 * @author bluesnow
 *
 */
public class Country
{
   private String name;
   private SubscriptionYear [] subscriptions;
   
   /**
    * build the construction of class Country, take the country name whose type is String and number of years whose type is integer as parameters.
    * @param countryName
    * @param numYears
    */
   public Country(String countryName, int numYears)
   {
      name = countryName;
      subscriptions = new SubscriptionYear [numYears];
   }
   
   /**
    * add each year's data of one country into array
    * 
    * @param startingYear
    * @param subscriptions
    */
   public void addSubscriptionYear(int year, double newSubscriptions)
   {
      SubscriptionYear subscriptionYear = new SubscriptionYear(year, newSubscriptions);
//      int n = year - 1960;
//      subscriptions[n] = subscriptionYear;
      
      int n = 0;
      while (subscriptions[n] != null)
         n++;
      subscriptions[n] = subscriptionYear;  
   }
   
   /**
    * return sum of specified period data.
    * 
    * @param startyingYear
    * @param endingYear
    * @return
    */
   public double getNumSubscriptionsForPeriod(int startingYear, int endingYear)
   {
      double sum = 0;
      
      try
      {
         int lengthForPeriod = endingYear - startingYear; 
      for (int i = 0; i <= lengthForPeriod; i++)
      {
         sum += subscriptions[i].getNumberOfSubscriptions();
      }
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
         System.out.println("requested period between " + startingYear + " and " + endingYear + " is out of bounds.");
         return -1;
      }
      
      return sum;
   }
   
   /**
    * return a String contains all data stored in the instance.
    */
   public String toString()
   {
      StringBuilder data = new StringBuilder();
      data.append(name).append(": ");
      for (int i = 0; i < subscriptions.length; i++)
      {
         data.append(subscriptions[i].getNumberOfSubscriptions()).append(", ");
      }
      return data.toString();
   }

}
