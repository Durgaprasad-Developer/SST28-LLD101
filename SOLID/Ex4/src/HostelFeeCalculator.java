import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    // OCP violation: switch + add-on branching + printing + persistence.
    public void process(BookingRequest req) {
        List<PricingComponent> components = new ArrayList<>();

        if(req.roomType == LegacyRoomTypes.SINGLE){
            components.add(new SingleRoomPricing());
        }else if(req.roomType == LegacyRoomTypes.DOUBLE){
            components.add(new DoubleRoomPricing());
        }else if(req.roomType == LegacyRoomTypes.TRIPLE){
            components.add(new TripleRoomPricing());
        }

        for(AddOn a : req.addOns){
            if(a == AddOn.MESS){
                components.add(new MessAddonPricing());
            }else if (a == AddOn.LAUNDRY){
                components.add(new LaundryAddonPricing());
            }else if(a == AddOn.GYM){
                components.add(new GymAddonPricing());
            }
        }
        Money monthly = calculateMonthly(components, req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(List<PricingComponent> components, BookingRequest req) {
        Money total = new Money(0.0);

        for(PricingComponent component : components){
            total = total.plus(component.monthlyCharge(req));
        }

        return total;
    }
}
