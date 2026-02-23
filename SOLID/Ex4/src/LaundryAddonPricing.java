public class LaundryAddonPricing implements PricingComponent {
    public Money monthlyCharge(BookingRequest req){
        return new Money(500.0);
    }
}
