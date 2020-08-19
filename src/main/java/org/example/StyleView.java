package org.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@CssImport(value = "styles/my-styles.css", themeFor = "vaadin-button")
@Route(value = "style", layout = MainLayout.class)
public class StyleView extends VerticalLayout {
    public StyleView() {
        Button button = new Button("test", event -> Notification.show("Button clicked"));
        button.addClassName("yellow");
        add(button);
    }
}
