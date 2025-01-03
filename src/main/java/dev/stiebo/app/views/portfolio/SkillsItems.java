package dev.stiebo.app.views.portfolio;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.List;

public class SkillsItems extends HorizontalLayout {

    public SkillsItems(String title, List<SkillItem> skillItems) {
        setWidthFull();
        setPadding(false);
        setAlignItems(Alignment.CENTER);
        setWrap(true);

//        add(new H3(title));

        for (SkillItem skillItem : skillItems) {
            Span labelSpan = new Span(skillItem.label());
            labelSpan.addClassNames(LumoUtility.FontSize.MEDIUM);
            Span itemSpan = new Span(createIcon(skillItem.svgIconName()), labelSpan);
            itemSpan.setWidth("130px");
            itemSpan.getElement().getThemeList().add("badge contrast");
            add(itemSpan);
        }
    }

    private SvgIcon createIcon(String svgIconName) {
        SvgIcon svgIcon = new SvgIcon(svgIconName);
        svgIcon.getStyle().set("padding", "var(--lumo-space-xs)")
                .set("width", "24px")
                .set("height", "24px");
        return svgIcon;
    }

}
