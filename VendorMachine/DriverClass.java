import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DriverClass {

    final static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to VendingPlayground");
        System.out.println("Available Products are :");
        HashMap<String , ArrayList<Product>> inventoryList = inventory.getProductInventory();
        inventoryList.keySet().forEach((key)->{
            System.out.println(key+" : "+inventoryList.get(key).size());
        });

        System.out.println("At a time you can choose at max 5 items");
        ArrayList<ProductRequest> request = getRequest(sc, inventoryList);
        VendingRequest request1 = new VendingRequest(request);
        ArrayList<Product> itemsToBeServed = inventory.serveItems(request1);
        int totalCost = findTotalPrice(request);
        int finalCost=  choiceOfPayment(totalCost,sc);
        System.out.println("Your final amount is : "+finalCost);
        System.out.println("Please pay the amount by typing it");

        int payment = 0;
        do{
            payment= sc.nextInt();
            if(payment!=finalCost){
                System.out.println("Please enter valid amount");
            }
        }while(payment!=finalCost);

        System.out.println("Your Items are");
        itemsToBeServed.forEach((item)->{
            System.out.println("["+item.getName()+"]");
        });

        System.out.println("********************************");
        System.out.println("Thank you");
        System.out.println("********************************");


    }

    private static ArrayList<ProductRequest> getRequest(Scanner sc, HashMap<String , ArrayList<Product>> inventoryList){
        int choice =0;
        int remainingItem = 5;
        int quantity = 0;

        String[] productNameList = {Prices.CHOCOLATE_NAME,Prices.CHIPS_NAME,Prices.ICECREAM_NAME,Prices.SANDWICH_NAME,Prices.COLD_DRINK_NAME};
        ArrayList<ProductRequest> list = new ArrayList<>();
        int[] countOfProducts = fillthecount(inventoryList,productNameList);
        do{
            System.out.println("Enter 1 for chocolate");
            System.out.println("Enter 2 for chips");
            System.out.println("Enter 3 for icecream");
            System.out.println("Enter 4 for sandwich");
            System.out.println("Enter 5 for coldDrink");
            System.out.println("Enter -1 for no further choice");
            System.out.println("Your choice remaining item = "+ remainingItem);
            choice = sc.nextInt();
            boolean vaildChoice = true;
            if(choice>5){
                System.out.println("please have valid choice");
                vaildChoice= false;
            }else{
                if(inventoryList.get(productNameList[choice-1]).size()!=0) {
                    System.out.println("Please Provide the quantity required for " + productNameList[choice - 1]);
                    System.out.println("Available Item for this product are : " + countOfProducts[choice-1]);
                    boolean validQuantity= true;
                    do {
                        quantity = sc.nextInt();
                        if (quantity > countOfProducts[choice-1] || quantity>remainingItem) {
                            System.out.println("Please enter valid quantity");
                        }else{
                            validQuantity=false;
                        }
                    }while(validQuantity);
                }else{
                    System.out.println("This item is not available select something else.");
                    vaildChoice=false;
                }
            }
            if(vaildChoice){
                ProductRequest productRequest = new ProductRequest(productNameList[choice-1],quantity);
                remainingItem-=quantity;
                countOfProducts[choice-1]-=quantity;
                list.add(productRequest);
            }


        }while((choice>5 || choice<-1|| choice==0 || (choice<5 && choice>0)) && remainingItem>0);

        return list;

    }

    private static int[] fillthecount(HashMap<String,ArrayList<Product>> inventoryList,String[] productname){
        int[] arr = new int[5];

        for(int i =0;i<5;i++){
            arr[i]= inventoryList.get(productname[i]).size();
        }
        return arr;
    }

    private static int findTotalPrice(ArrayList<ProductRequest> requests){
         int cost =0;
        Prices prices = new Prices();
        for(int i =0;i<requests.size();i++){
            cost += prices.priceIs(requests.get(i).getProductName(),requests.get(i).getQuantity());
        }
        return cost;
    }

    private  static int choiceOfPayment(int cost,Scanner sc ){
        System.out.println("Choice of payment is?");
        System.out.println("Enter 1 for card ");
        System.out.println("Enter 2 for cash");
        int choice =0;
        do{
            choice = sc.nextInt();
            if(choice==1){
                cardInput(cost*2,sc);
                return cost*2;
            }else if(choice==2){
                return cost;
            }else{
                System.out.println("Please give valid input");
            }
        }while(choice<=0 || choice>2);

        return cost;

    }

    private  static void cardInput(int cost ,Scanner sc){
        System.out.println("Please enter Your name");
        String name = sc.next();
        System.out.println("Please Enter your card number");
        String cardnumber = sc.next();
        System.out.println("Please provide your cvv");
        String cvv = sc.next();
        CardPayment cardPayment = new CardPayment(cost,name,Long.valueOf(cardnumber),Integer.valueOf(cvv));
    }
}

