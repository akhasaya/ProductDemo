package ProductDemo;

import java.util.ArrayList;
import java.util.List;
import java.time.Year;
import java.util.stream.Stream;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProduct(String name){
        for(Product p : products){
            if(p.getName().equals(name))
                return p;
        }

        return null;
    }

    public Stream<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        Stream<Product> prods = products.stream()
                .filter(p -> p.getName().toLowerCase().contains(str) || p.getType().toLowerCase().contains(str) || p.getPlace().toLowerCase().contains(str));
        return prods;
    }

    public Stream<Product> getProductInPlace(String text) {
        String str = text.toLowerCase();
        Stream<Product> prods = products.stream()
                        .filter(p -> p.getPlace().toLowerCase().equals(str));
        return prods;

    }

    public Stream<Product> getProductsWithoutWarrenty() {
        int year = Year.now().getValue();
        Stream<Product> p = products.stream().filter(x -> x.getWarranty()<year);
        return p;
    }

}
