package org.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route(value = "main", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class MainView extends VerticalLayout {

    public MainView() {
        Button button = new Button("Click me",
                event -> Notification.show("Clicked!"));
        button.addClassName("red-color");
        add(button);

    }
}
