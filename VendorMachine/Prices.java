public class Prices {

    public static final String COLD_DRINK_NAME ="COCA_COLA";
    public static final String CHIPS_NAME ="AMERICAN_LAYS";
    public static final String CHOCOLATE_NAME ="FRERO_ROCHER";
    public static final String ICECREAM_NAME ="CORNETTO";
    public static final String SANDWICH_NAME ="VEG_SANDWICH";
    public static final int SANDWICH_PRICE = 50;
    public static final int ICECREAM_PRICE = 30;
    public static final int CHOCOLATE_PRICE = 80;
    public static final int CHIPS_PRICE = 20;
    public static final int COLD_DRINK_PRICE = 40;

    public int priceIs(String productName, int quantity){
        int cost =0;
        switch (productName){
            case COLD_DRINK_NAME : cost= quantity*COLD_DRINK_PRICE;
            break;
            case CHIPS_NAME :cost  = quantity * CHIPS_PRICE;
            break;
            case CHOCOLATE_NAME : cost = quantity*CHOCOLATE_PRICE;
            break;
            case ICECREAM_NAME : cost = quantity*ICECREAM_PRICE;
            break;
            case SANDWICH_NAME : cost = quantity*SANDWICH_PRICE;
            break;
        }

        return cost;
    }


}
