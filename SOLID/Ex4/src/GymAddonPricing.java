public class GymAddonPricing implements PricingComponent {
    public Money monthlyCharge(BookingRequest req){
        return new Money(300.0);
    }
}
