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
        orders.add(new Order("Oris Dental Narvik", "Gayle Laakmann McDowell",  200977L, "Implant", "Atlantis ISUS, Co/Cr porselen", 3, OrderType.HASTER));
        orders.add(new Order("Oris Dental Madla", "The MIT Press", 200345L, "Fixed denture", "Etsebro Co/Cr", 1,  OrderType.HASTER));
        orders.add(new Order("Opitz Tannhelsesenter AS", "Michael Sipser", 200872L, "Additional", "Implantatmodell med gingivamaske", 1, OrderType.HASTER));
        orders.add(new Order("Smil Tannregulering AS", "Silberschatz, Galvin, Gagne", 200764L, "Fixed denture","IPS e.max", 8, OrderType.HASTER));
        orders.add(new Order("Brynjar Herland AS", "Alex Michaelides", 200542L, "Implant", "NobelProcera FCZ", 5, OrderType.NORMAL));
        orders.add(new Order("Fjærvik Klinikken AS", "Margaret Atwood", 200816L, "Implant", "Zirkonzahn Prettau på Titan-base", 8, OrderType.HASTER));
        orders.add(new Order("Ullevål Stadion Tannklinikk AS", "Renée Watson", 200761L, "Implant", "Kirurgisk stent/operasjonsguide", 1, OrderType.NORMAL));
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
