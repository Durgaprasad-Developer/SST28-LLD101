public class TaxCalculator {
    public double getTax(double subtotal, double taxPct){
        double tax = subtotal * (taxPct / 100.0);
        
        return tax;
    }
    
}
