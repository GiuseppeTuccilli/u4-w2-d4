package giuseppetuccilli;


import giuseppetuccilli.entities.Customer;
import giuseppetuccilli.entities.Order;
import giuseppetuccilli.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Product prodotto1 = new Product("Lavatrice", "boys", 500);
        Product prodotto2 = new Product("T-shirt", "boys", 20);
        Product prodotto3 = new Product("trapano a colonna", "boys", 1000);
        Product prodotto4 = new Product("il guardiano degli innocenti", "books", 200);
        Product prodotto5 = new Product("ritorno al nuovo mondo", "books", 50);
        Product prodotto6 = new Product("il ritorno del re", "books", 300);
        Product prodotto7 = new Product("passeggino", "baby", 300);
        Product prodotto8 = new Product("altro", "baby", 300);

        Customer cliente1 = new Customer("pippo", 2);
        Customer cliente2 = new Customer("pluto", 3);
        Customer cliente3 = new Customer("tizio", 3);

        ArrayList<Product> listaProd = new ArrayList<>();

        listaProd.add(prodotto1);
        listaProd.add(prodotto2);
        listaProd.add(prodotto3);
        listaProd.add(prodotto4);
        listaProd.add(prodotto5);
        listaProd.add(prodotto6);

        Order ordine1 = new Order(cliente1, listaProd);

        ArrayList<Product> listaProd2 = new ArrayList<>();

        listaProd2.add(prodotto5);
        listaProd2.add(prodotto6);
        listaProd2.add(prodotto7);
        listaProd2.add(prodotto8);

        Order ordine2 = new Order(cliente2, listaProd2);

        ArrayList<Product> listaProd3 = new ArrayList<>();

        listaProd3.add(prodotto1);
        listaProd3.add(prodotto2);
        listaProd3.add(prodotto3);
        listaProd3.add(prodotto4);
        listaProd3.add(prodotto5);
        listaProd3.add(prodotto6);
        listaProd3.add(prodotto7);
        listaProd3.add(prodotto8);

        Order ordine3 = new Order(cliente3, listaProd3);
        Order ordine4 = new Order(cliente3, listaProd2);

        ArrayList<Order> orders = new ArrayList<>();

        orders.add(ordine1);
        orders.add(ordine2);
        orders.add(ordine3);

        Map<Customer, List<Order>> ordersForClient = orders.stream().collect(Collectors.groupingBy(order -> order.getCustomer()));
        System.out.println(ordersForClient);

        orders.stream().map(order -> order.getProducts()).map(products -> products.stream().map(product -> product.getPrice()).reduce((double) 0, (par, curr) -> par + curr));

        Map<Customer, Double> totalForClient = orders.stream().collect(Collectors.groupingBy(order -> order.getCustomer(), Collectors.summingDouble(
                order -> order.getProducts().stream().mapToDouble(product -> product.getPrice()).sum())));

        System.out.println(totalForClient);

    }
}
