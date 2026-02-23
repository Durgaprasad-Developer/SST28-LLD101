public class DoubleRoomPricing implements PricingComponent {
    public Money monthlyCharge(BookingRequest req){
        return new Money(15000.0);
    }
}
