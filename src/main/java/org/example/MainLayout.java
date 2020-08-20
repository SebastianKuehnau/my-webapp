package org.example;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLayout;

@Push
public class MainLayout extends HorizontalLayout implements RouterLayout {

    private final VerticalLayout menuLayout = new VerticalLayout();
    private final Div contentLayout = new Div();

    public MainLayout() {

        menuLayout.setSizeUndefined();
        contentLayout.setSizeFull();

        add(menuLayout, contentLayout);

        RouteConfiguration configuration = RouteConfiguration.forSessionScope();
        configuration.getAvailableRoutes()
                .forEach(routeData -> menuLayout.add(new Button(routeData.getUrl(),
                            event -> UI.getCurrent().navigate(routeData.getNavigationTarget()))));
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        contentLayout.removeAll();
        contentLayout.add((Component) content);
    }
}
