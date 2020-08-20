package org.example.grid;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;
import org.example.MainLayout;
import org.vaadin.klaudeta.PaginatedGrid;

@CssImport(value = "styles/person-grid.css", themeFor = "vaadin-grid")
@Route(value = "grid", layout = MainLayout.class)
public class GridView extends VerticalLayout {

    private Icon icon = VaadinIcon.ABACUS.create();
    PersonService personService = new PersonService();

    public GridView() {
        add(new Span("Hello Grid World!"));

        PaginatedGrid<Person> personGrid = new PaginatedGrid<>();
        personGrid.addClassName("person-grid");
        personGrid.addColumn(Person::getName).setHeader("Person Name");
        personGrid.addColumn(Person::getAge)
                .setClassNameGenerator(person -> person.getAge() % 2 == 0 ? "red-cell" : "green-cell")
                .setHeader("Age");
        personGrid.addColumn(TemplateRenderer.<Person>of(
                "<div>[[item.email]]</div>")
                .withProperty("email", Person::getEmail))
                .setHeader("E-Mail");
        personGrid.addColumn(Person::getBirthday).setHeader("Birthday");
        personGrid.addColumn(new ComponentRenderer<>(person -> {
            Icon icon = VaadinIcon.ABACUS.create() ;
            icon.addClickListener(event -> Notification.show("Abacus clicked"));
            return icon;
        }));
        personGrid.setItemDetailsRenderer(new ComponentRenderer<>(
                person -> new Span(person.getAge() + " " + person.getBirthday().toString())
        ));


        //Das PaginatedGrid Geht leider nicht mit lazy load.
//        CallbackDataProvider<Person, Void> dataProvider = DataProvider.fromCallbacks(
//                        query -> personService.getPersons(query.getOffset(), query.getLimit(), null),
//                        query -> personService.countPersons(query.getOffset(), query.getLimit(), null));
//        personGrid.setDataProvider(dataProvider);

        personGrid.setItems(personService.persons);

        personGrid.setPageSize(15);
        personGrid.setPaginatorSize(5);

        add(personGrid);
    }
}
