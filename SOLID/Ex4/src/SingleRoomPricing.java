public class SingleRoomPricing implements PricingComponent {
    public Money monthlyCharge(BookingRequest req){
        return new Money(14000.0);
    }
}
