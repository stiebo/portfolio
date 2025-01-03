package dev.stiebo.app.views.myview;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("My View")
@Route("my-view")
public class MyViewView extends Composite<VerticalLayout> {

    public MyViewView() {
        Avatar avatar = new Avatar();
        Paragraph textLarge = new Paragraph();
        Hr hr = new Hr();
        H1 h1 = new H1();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        avatar.setName("Firstname Lastname");
        textLarge.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        textLarge.setWidth("100%");
        textLarge.getStyle().set("font-size", "var(--lumo-font-size-xl)");
        h1.setText("Heading");
        h1.setWidth("max-content");
        getContent().add(avatar);
        getContent().add(textLarge);
        getContent().add(hr);
        getContent().add(h1);
    }
}
