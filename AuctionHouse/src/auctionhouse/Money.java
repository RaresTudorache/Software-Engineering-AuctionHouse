/**
 * 
 */
package auctionhouse;

/**
 * @author pbj
 */
public class Money implements Comparable<Money> {
 
    private double value;
    
    private static long getNearestPence(double pounds) {
        return Math.round(pounds * 100.0);
    }
 
    private static double normalise(double pounds) {
        return getNearestPence(pounds)/100.0;
        
    }
 
    public Money(String pounds) {
        value = normalise(Double.parseDouble(pounds));
    }
    
    private Money(double pounds) {
        value = pounds;
    }
    
    public Money add(Money m) {
        return new Money(value + m.value);
    }
    
    public Money subtract(Money m) {
        return new Money(value - m.value);
    }
 
    public Money addPercent(double percent) {
        return new Money(normalise(value * (1 + percent/100.0)));
    }
     
    @Override
    public String toString() {
        return String.format("%.2f", value);
        
    }
    public int compareTo(Money m) {
        return Long.compare(getNearestPence(value),  getNearestPence(m.value)); 
    }
    
    public Boolean lessEqual(Money m) {
        return compareTo(m) <= 0;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Money)) return false;
        Money oM = (Money) o;
        return compareTo(oM) == 0;       
    }
    
    @Override
    public int hashCode() {
        return Long.hashCode(getNearestPence(value));
    }
      

}
