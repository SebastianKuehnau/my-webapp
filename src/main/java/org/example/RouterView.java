package org.example;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Route(value = "router", layout = MainLayout.class)
public class RouterView extends VerticalLayout implements HasUrlParameter<String>, BeforeEnterObserver {


    @Override
    public void setParameter(BeforeEvent event, @WildcardParameter String parameter) {
        if (parameter != null && !parameter.isEmpty()) {
            removeAll();
            Arrays.stream(StringUtils.split(parameter, "/"))
                    .forEach(s -> add(new Span(String.format("Hello %s", s))));
        } else
            add(new Span("Hello Anonymous!!!"));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        System.out.println("Caught Before Enter Event");
    }
}
