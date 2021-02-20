package com.example.demo.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderService {

    private Set<Order> orders;
    private OrderService() {
        this.orders = exampleData();
    }

    private static OrderService orderService;

    public static OrderService getInstance() {
        if (orderService == null) {
            orderService = new OrderService();
        }
        return orderService;
    }

    public Set<Order> getOrders() {
        return new HashSet<>(orders);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    private Set exampleData() {
        Set orders = new HashSet<>();
        orders.add(new Order("Oris Dental Narvik", "Gayle Laakmann McDowell",  "200977", OrderType.HASTER));
        orders.add(new Order("Oris Dental Madla", "The MIT Press", "200977", OrderType.HASTER));
        orders.add(new Order("Opitz Tannhelsesenter AS", "Michael Sipser", "200977",  OrderType.HASTER));
        orders.add(new Order("Smil Tannregulering AS", "Silberschatz, Galvin, Gagne", "200977",  OrderType.HASTER));
        orders.add(new Order("Brynjar Herland AS", "Alex Michaelides", "200977",  OrderType.NORMAL));
        orders.add(new Order("Fjærvik Klinikken AS", "Margaret Atwood", "200977",  OrderType.HASTER));
        orders.add(new Order("Ullevål Stadion Tannklinikk AS", "Renée Watson", "2222", OrderType.NORMAL));
        return orders;
    }

    public Set<Order> findByDentist(String dentist) {
        return orders.stream().filter(order -> order.getClinic().contains(dentist)).collect(Collectors.toSet());
    }

    public void save(Order order) {
        this.orders.add(order);
    }

    public void delete(Order order) {
        this.orders.remove(order);
    }


}
