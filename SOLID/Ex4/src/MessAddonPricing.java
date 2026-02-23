public class MessAddonPricing implements PricingComponent {
    public Money monthlyCharge(BookingRequest req){
        return new Money(1000.0);
    }
}
