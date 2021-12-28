package pt.up.fe.ldts.example3;

public class Discount {
    private final int fixed;
    private final double percentage;

    public Discount(int fixed) {
        this.fixed = fixed;
        this.percentage = 0;
    }

    public Discount(double percentage) {
        this.percentage = percentage;
        this.fixed = 0;
    }

    public double applyDiscount(double price) {

        if (fixed > 0)
            if( fixed > price)
                price = 0;
            else
                price -= fixed;
        else if (percentage > 0)
            price = price - price * percentage;
        return price;
    }
}
