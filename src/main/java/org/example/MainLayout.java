package org.example;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLayout;

@Push
@CssImport("styles/shared-styles.css")
@CssImport(value = "styles/button-styles.css", themeFor = "vaadin-button")
public class MainLayout extends VerticalLayout implements RouterLayout {

    private final Span header = new Span("header");
    private final VerticalLayout sideMenu = new VerticalLayout();
    private final Div contentPanel = new Div();
    private final Span footer = new Span("footer");

    public MainLayout() {
        add(header);

        RouteConfiguration configuration = RouteConfiguration.forSessionScope();
        // add all currently available views
        configuration.getAvailableRoutes()
                .forEach(routeData ->
                        sideMenu.add(new Button(routeData.getUrl(), event -> getUI().ifPresent(ui -> ui.navigate(routeData.getNavigationTarget())))));

        sideMenu.setSpacing(true);
        sideMenu.setPadding(false);
        sideMenu.getStyle().remove("width");

        contentPanel.getStyle().set("overflow-y", "scroll");
        contentPanel.setSizeFull();

        final HorizontalLayout centerLayout = new HorizontalLayout(sideMenu, contentPanel);
        centerLayout.setFlexGrow(1, contentPanel);
        centerLayout.setSizeFull();
        centerLayout.setSpacing(true);

        add(centerLayout);

        DragSource<Span> spanDragSource = DragSource.configure(footer, true);
        add(footer);

        setSpacing(true);
        setSizeFull();
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        contentPanel.getElement().removeAllChildren();
        contentPanel.getElement().appendChild(content.getElement());
    }
}
