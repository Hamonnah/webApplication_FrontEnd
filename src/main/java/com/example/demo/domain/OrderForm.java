package com.example.demo.domain;

import com.example.demo.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class OrderForm extends FormLayout {

    private TextField title = new TextField("Clinic");
    private TextField author = new TextField("Dentist");
    private TextField publicationYear = new TextField("ScanId");
    private ComboBox<OrderType> type = new ComboBox<>("Order type");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private final Binder<Order> binder = new Binder<>(Order.class);

    private MainView mainView;

    private OrderService service = OrderService.getInstance();

    public OrderForm(MainView mainView) {
        this.mainView = mainView;
        type.setItems(OrderType.values());
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(title, author, publicationYear, type, buttons);
        binder.bindInstanceFields(this);

        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());
    }

    private void save() {
        Order order = binder.getBean();
        service.save(order);
        mainView.refresh();
        setBook(null);
    }

    private void delete() {
        Order order = binder.getBean();
        service.delete(order);
        mainView.refresh();
        setBook(null);
    }

    public void setBook(Order order) {
        binder.setBean(order);

        if (order == null) {
            setVisible(false);
        } else {
            setVisible(true);
            title.focus();
        }
    }

}
