package dev.stiebo.app.views.portfolio;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Background;
import com.vaadin.flow.theme.lumo.LumoUtility.BorderRadius;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FlexDirection;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;
import com.vaadin.flow.theme.lumo.LumoUtility.Width;

public class PortfolioViewCard extends ListItem {

    public PortfolioViewCard(PortfolioCardData data) {
        addClassNames(Background.CONTRAST_5, Display.FLEX, FlexDirection.COLUMN, AlignItems.START, Padding.MEDIUM,
                BorderRadius.LARGE);

        Div div = new Div();
        div.addClassNames(Background.CONTRAST, Display.FLEX, AlignItems.START, JustifyContent.CENTER,
                Margin.Bottom.MEDIUM, Overflow.HIDDEN, BorderRadius.MEDIUM, Width.FULL);
        div.setHeight("160px");

        Image image = new Image();
        image.setWidth("100%");
        image.setSrc(data.imageLink());
        image.setAlt(data.title());

        div.add(image);

        Span header = new Span();
        header.addClassNames(FontSize.XLARGE, FontWeight.SEMIBOLD);
        header.setText(data.title());

        Span subtitle = new Span();
        subtitle.addClassNames(FontSize.SMALL, TextColor.SECONDARY);
        subtitle.setText(data.subTitle());

        Paragraph description = new Paragraph(
                data.description());
        description.addClassName(Margin.Vertical.MEDIUM);

        Anchor githubLink = new Anchor(data.linkDemo());
        githubLink.setTarget("_blank");
        Button githubLinkButton = new Button("Live Demo");
        githubLinkButton.getStyle().set("cursor", "pointer");
        githubLinkButton.getElement().setAttribute("tabindex", "-1");
        githubLinkButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        githubLink.add(githubLinkButton);

        Anchor demoLink = new Anchor(data.linkGithub());
        demoLink.setTarget("_blank");
        Button demoLinkButton = new Button("View Code");
        demoLinkButton.getStyle().set("cursor", "pointer");
        demoLinkButton.getElement().setAttribute("tabindex", "-1");
        demoLinkButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        demoLink.add(demoLinkButton);

        HorizontalLayout links = new HorizontalLayout(githubLink, demoLink);

        add(div, header, subtitle, description, links);

    }
}