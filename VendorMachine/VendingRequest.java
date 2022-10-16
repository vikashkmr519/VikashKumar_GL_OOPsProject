import java.util.ArrayList;

public class VendingRequest {

    private ArrayList<ProductRequest> requestedProducts;

    public VendingRequest(ArrayList<ProductRequest> requestedProducts) {
        this.requestedProducts = requestedProducts;
    }

    public ArrayList<ProductRequest> getRequestedProducts() {
        return requestedProducts;
    }

    public void setRequestedProducts(ArrayList<ProductRequest> requestedProducts) {
        this.requestedProducts = requestedProducts;
    }

    public void addProductRequest(ProductRequest request){
        this.requestedProducts.add(request);
    }
}
