public class CardPayment extends  Payment{
    private String name;
    private long cardnumber;
    private int cvv;

    public CardPayment( int totalPrice, String name, long cardnumber, int cvv) {
        super("CARD", totalPrice);
        this.name = name;
        this.cardnumber = cardnumber;
        this.cvv = cvv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(long cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
