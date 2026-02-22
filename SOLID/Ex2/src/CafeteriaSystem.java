import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceRepository store;
    private final TaxPolicy taxPolicy;

    public CafeteriaSystem(InvoiceRepository store, TaxPolicy taxPolicy){
        this.store = store;
        this.taxPolicy = taxPolicy;
    }
    
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        // pricing

        PricingService price = new PricingService();
        double subtotal = price.getSubtotal(lines, menu);

        // tax
        double taxPct = taxPolicy.taxPercent(customerType);
        TaxCalculator t = new TaxCalculator();
        double tax = t.getTax(subtotal, taxPct);

        // discount
        double discount = DiscountRules.discountAmount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;
        //  invoice formating
        InvoicePrinter invoice = new InvoicePrinter();
        String out = invoice.buildInvoice(invId, lines, menu, subtotal, taxPct, tax, discount, total);

        String printable = InvoiceFormatter.identityFormat(out.toString());
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
