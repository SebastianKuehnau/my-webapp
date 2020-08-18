package org.example.designer;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.example.MainLayout;

@CssImport(value = "styles/designer-styles.css", themeFor = "vaadin-button")
@Route(value = "designer", layout = MainLayout.class)
public class DesignerView extends VerticalLayout {

    public DesignerView() {
        add(new MyDesign());
    }
}
