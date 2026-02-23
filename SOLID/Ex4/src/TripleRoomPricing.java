public class TripleRoomPricing implements PricingComponent {
    public Money monthlyCharge(BookingRequest req){
        return new Money(12000.0);
    }
}
