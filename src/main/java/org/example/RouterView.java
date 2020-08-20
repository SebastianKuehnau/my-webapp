package org.example;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.WildcardParameter;

@Route(value = "router", layout = MainLayout.class)
public class RouterView extends VerticalLayout /* implements HasUrlParameter<String> */ {
    public RouterView() {
        add(new Span("Hello World"));
    }

//    @Override
//    public void setParameter(BeforeEvent event, @WildcardParameter String parameter) {
//        add(new Span("Welcome " + parameter));
//    }
}
