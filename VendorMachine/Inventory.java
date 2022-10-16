import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private final HashMap<String, ArrayList<Product>> productInventory;

    public Inventory() {
        productInventory = new HashMap<>();
        fillTheProducts();
    }

    private void fillTheProducts(){
       productInventory.put(Prices.CHOCOLATE_NAME, fillChocolate());
        productInventory.put(Prices.CHIPS_NAME, fillChips());
        productInventory.put(Prices.ICECREAM_NAME, fillIcecream());
        productInventory.put(Prices.SANDWICH_NAME, fillSandwich());
        productInventory.put(Prices.COLD_DRINK_NAME, fillColdDrink());
    }

    private ArrayList<Product> fillChocolate(){
        ArrayList<Product> list = new ArrayList<>();

        for(int i =0;i<5;i++){
            list.add(new Chocolate());
        }
        return list;
    }

    private ArrayList<Product> fillChips(){
        ArrayList<Product> list = new ArrayList<>();

        for(int i =0;i<5;i++){
            list.add(new Chips());
        }
        return list;
    }
    private ArrayList<Product> fillIcecream(){
        ArrayList<Product> list = new ArrayList<>();

        for(int i =0;i<5;i++){
            list.add(new Icecream());
        }
        return list;
    }
    private ArrayList<Product> fillSandwich(){
        ArrayList<Product> list = new ArrayList<>();

        for(int i =0;i<5;i++){
            list.add(new Sandwich());
        }
        return list;
    }
    private ArrayList<Product> fillColdDrink(){
        ArrayList<Product> list = new ArrayList<>();

        for(int i =0;i<5;i++){
            list.add(new ColdDrink());
        }
        return list;
    }

    public boolean doesProductExists(String productName){
        if(productInventory.get(productName).size()>0){
            return true;
        }
        return false;
    }

    public ArrayList<Product> serveItems(VendingRequest request)
    {
        ArrayList<Product> list = new ArrayList<>();
        request.getRequestedProducts().forEach((item)->{
            ArrayList<Product> products  = productInventory.get(item.getProductName());
           int  size  =productInventory.get(item.getProductName()).size();
           for(int i =0;i<item.getQuantity();i++){
               list.add(products.remove(0));
           }
        });

        return list;


    }

    public HashMap<String, ArrayList<Product>> getProductInventory() {
        return productInventory;
    }


}
