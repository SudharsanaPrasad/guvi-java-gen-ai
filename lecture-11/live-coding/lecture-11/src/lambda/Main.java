package lambda;

public class Main {

    interface PriceRule {
        int apply(int price, int discount);
    }

    public static void main(String[] args) {
        PriceRule tenOff = new PriceRule() {
            @Override
            public int apply(int price, int discount) {
                return price - 10;
            }
        };

        // Lambda
        PriceRule twentyOff = (p, d) -> p - d;

        int price = 500;
        int tenOffDiscount = tenOff.apply(price, 10);
        int twentOffDiscount = twentyOff.apply(price, 20);
        System.out.println(tenOffDiscount + ". 20 off discount " + twentOffDiscount);
    }
}
