package org.example.designer;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.ShortcutRegistration;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Dial;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the designer-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("designer-component")
@JsModule("./designer-component.js")
public class DesignerComponent extends PolymerTemplate<DesignerComponent.DesignerComponentModel> {

    @Id("vaadinTextField")
    private TextField vaadinTextField;
    @Id("vaadinButton")
    private Button vaadinButton;

    /**
     * Creates a new DesignerView.
     */
    public DesignerComponent() {
        // You can initialise any data required for the connected UI components here.
        vaadinButton.addClickListener(event -> {
            Dialog dialog = new Dialog(new Span("Deine Name ist: " + vaadinTextField.getValue()));
            dialog.setModal(true);
            dialog.setCloseOnEsc(true);
            dialog.open();
        });
        vaadinButton.addClickShortcut(Key.ENTER);
    }

    /**
     * This model binds properties between DesignerView and designer-view
     */
    public interface DesignerComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
