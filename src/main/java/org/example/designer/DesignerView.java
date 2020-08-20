package org.example.designer;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.example.MainLayout;

@Route(value = "designer", layout = MainLayout.class)
public class DesignerView extends VerticalLayout {
    public DesignerView() {
        add(new DesignerComponent());
        setSizeFull();
    }
}
