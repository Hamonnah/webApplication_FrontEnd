package com.example.demo;

import com.example.demo.domain.Order;
import com.example.demo.domain.OrderForm;
import com.example.demo.domain.OrderService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    private OrderService orderService = OrderService.getInstance();
    private Grid grid = new Grid<>(Order.class);
    private TextField filter = new TextField();
    private OrderForm form = new OrderForm(this);
    private Button addNewOrder = new Button("Add new order");

    public MainView() {

        filter.setPlaceholder("Filter by dentist...");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> update());
        grid.setColumns("clinic", "dentist", "scanId", "type");
        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(filter, mainContent);
        setSizeFull();
        refresh();
        grid.asSingleSelect().addValueChangeListener(event -> form.setBook((Order) grid.asSingleSelect().getValue()));
    }

    private void update() {
        grid.setItems(orderService.findByDentist(filter.getValue()));
    }

    public void refresh() {
        grid.setItems(orderService.getOrders());
    }

}
