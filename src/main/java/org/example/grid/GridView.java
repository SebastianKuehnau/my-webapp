package org.example.grid;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.CallbackDataProvider;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.Route;

@Route("grid")
public class GridView extends VerticalLayout {

    final PersonService service = new PersonService();

    public GridView() {
        setWidth("100%");

        final Grid<Person> grid = new Grid<>();
        grid.setWidth("90%");
        add(grid);

        final CallbackDataProvider<Person, Void> dataProvider = DataProvider.fromCallbacks(
                query -> service.getPersons(query.getOffset(), query.getLimit(), null),
                query -> service.countPersons(query.getOffset(), query.getLimit(), null)
        );

        grid.setDataProvider(dataProvider);

        grid.addColumn(Person::getName).setHeader("Name").setKey("name");
        grid.addColumn(Person::getEmail).setHeader("Email").setKey("email");
        grid.addColumn(Person::getAge).setHeader("Age").setKey("age");
        grid.addColumn(new LocalDateRenderer<>(Person::getBirthday)).setHeader("Birthday").setKey("birthday");
    }
}
