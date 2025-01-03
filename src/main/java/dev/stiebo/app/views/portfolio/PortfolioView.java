package dev.stiebo.app.views.portfolio;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;
import org.hibernate.query.Order;
import org.vaadin.lineawesome.LineAwesomeIcon;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import javax.sound.sampled.Line;
import java.util.List;
import java.util.Optional;

@PageTitle("Portfolio Stefan Bock")
@Route("")
public class PortfolioView extends Main implements HasComponents, HasStyle {

    private OrderedList imageContainer;

    public PortfolioView() {
        constructUI();

        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
            "images/TransactionSystem.jpg",
            "Transaction System",
            "Java / Spring Boot application with H2 database",
            "The Anti-Fraud System provides real-time detection and prevention of potentially fraudulent activities. It helps businesses mitigate risk by leveraging advanced algorithms, blacklists, and transaction scoring. With a simple and intuitive interface, you can review suspicious transactions and take immediate action.",
                Optional.of("https://stiebo.dev/transactionsystem"),
                "https://github.com/stiebo/transaction-system"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/ChatWithDocs.jpg",
                "GenAI Document Chat Client",
                "Java / Spring Boot application with H2 database",
                "The Anti-Fraud System provides real-time detection and prevention of potentially fraudulent activities. It helps businesses mitigate risk by leveraging advanced algorithms, blacklists, and transaction scoring. With a simple and intuitive interface, you can review suspicious transactions and take immediate action.",
                Optional.of("https://stiebo.dev/chatwithdocs/"),
                "https://github.com/stiebo/spring-ai-samples-vaadin"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/AiUtilities.jpg",
                "AI Utilities",
                "Spring AI demo utilities",
                "This demo showcases Spring AI to integrate advanced AI capabilities, such as vector embeddings and similarity search, into document processing and conversational AI.",
                Optional.of("https://stiebo.dev/aiutilities/swagger-ui/index.html"),
                "https://github.com/stiebo/spring-ai-samples"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/OpenAPI.jpg",
                "API First / OpenAPI",
                "Java / Spring Boot application with H2 database",
                "The Anti-Fraud System provides real-time detection and prevention of potentially fraudulent activities. It helps businesses mitigate risk by leveraging advanced algorithms, blacklists, and transaction scoring. With a simple and intuitive interface, you can review suspicious transactions and take immediate action.",
                Optional.empty(),
                "https://github.com/stiebo/openapi-generator-sample"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/QuarkusRestApi.jpg",
                "Quarkus RestAPI",
                "Java / Spring Boot application with H2 database",
                "The Anti-Fraud System provides real-time detection and prevention of potentially fraudulent activities. It helps businesses mitigate risk by leveraging advanced algorithms, blacklists, and transaction scoring. With a simple and intuitive interface, you can review suspicious transactions and take immediate action.",
                Optional.of("https://stiebo.dev/quarkusantifraudsystem/q/swagger-ui/"),
                "https://github.com/stiebo/quarkus-anti-fraud-system"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/AntiFraud.jpg",
                "Transaction System RestAPI",
                "Java / Spring Boot application with H2 database",
                "The Anti-Fraud System provides real-time detection and prevention of potentially fraudulent activities. It helps businesses mitigate risk by leveraging advanced algorithms, blacklists, and transaction scoring. With a simple and intuitive interface, you can review suspicious transactions and take immediate action.",
                Optional.of("https://stiebo.dev/antifraudsystem/swagger-ui/index.html"),
                "https://github.com/stiebo/Anti-Fraud-System"
        )));
    }

    private void constructUI() {
        addClassNames("portfolio-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        VerticalLayout container = new VerticalLayout();
        HorizontalLayout intro = new HorizontalLayout();

        Div circularDiv = new Div();
        circularDiv.getStyle()
                .set("width", "280px")
                .set("height", "280px")
                .set("border", "3px solid var(--lumo-primary-color)")
                .set("border-radius", "50%")
                .set("overflow", "hidden")
                .set("display", "flex")
                .set("align-items", "center")
                .set("justify-content", "center");

        Image image = new Image("images/StefanBock.jpg", "Profile picture");
        image.getStyle()
                .set("width", "100%")
                .set("height", "100%")
                .set("object-fit", "cover");

        circularDiv.add(image);

        H3 introName = new H3("I am Stefan Bock");
        H1 introJob = new H1("Java Developer");
        Paragraph introText = new Paragraph("""
                                As an experienced engineer and innovation manager with foundational knowledge in
                                software development, including Java and Spring Boot, I bring a unique blend of
                                technical expertise and strategic insight to every project. My enthusiasm for software
                                development and dedication to learning ensure that I stay at the forefront
                                of emerging technologies, while my global perspective and inter-disciplinary experience
                                bring fresh, innovative ideas to every endeavor.
                """);

        HorizontalLayout introLinks = new HorizontalLayout();
        introLinks.setSpacing(true);
        introLinks.setAlignItems(FlexComponent.Alignment.START);
        SvgIcon linkedInIcon = LineAwesomeIcon.LINKEDIN.create();
        Anchor linkedInLink = new Anchor("https://www.linkedin.com/in/stefan-bock", "");
        linkedInLink.setTarget("_blank");
        linkedInLink.add(linkedInIcon);
        SvgIcon githubIcon = LineAwesomeIcon.GITHUB.create();
        Anchor githubLink = new Anchor("https://www.github.com/stiebo");
        githubLink.setTarget("_blank");
        githubLink.add(githubIcon);
        introLinks.add(linkedInLink, githubLink);

        VerticalLayout introTextArea = new VerticalLayout(introName, introJob, introText, introLinks);
        introTextArea.setPadding(false);
        introTextArea.setMaxWidth("600px");

        intro.setWidthFull();
        intro.setWrap(true);
        intro.add(introTextArea, circularDiv);
        circularDiv.addClassName(LumoUtility.Flex.SHRINK_NONE);

        H2 skillsHeader = new H2("Skills");
        skillsHeader.addClassNames(Margin.Bottom.NONE, Margin.Top.XLARGE, FontSize.XXXLARGE);

        HorizontalLayout skillsContainer = new HorizontalLayout();
        skillsContainer.setWidthFull();
        skillsContainer.setWrap(true);
        skillsContainer.add(new SkillsItems("Core", List.of(
                new SkillItem("icons/java-svgrepo-com.svg", "Java"),
                new SkillItem("icons/spring-svgrepo-com.svg", "Spring"),
                new SkillItem("icons/database-svgrepo-com.svg", "Data JPA"),
                new SkillItem("icons/swagger-svgrepo-com.svg", "OpenAPI"),
                new SkillItem("icons/quarkus-icon-svgrepo-com.svg", "Quarkus"),
                new SkillItem("icons/brand-vaadin-svgrepo-com.svg", "Vaadin")
        )
        ));
        skillsContainer.add(new SkillsItems("More", List.of(
                new SkillItem("icons/github-icon-svgrepo-com.svg", "Git"),
                new SkillItem("icons/docker-svgrepo-com.svg", "Docker"),
                new SkillItem("icons/maven-svgrepo-com.svg", "Maven"),
                new SkillItem("icons/sql-svgrepo-com.svg", "SQL"),
                new SkillItem("icons/junit5-svgrepo-com.svg", "JUnit"),
                new SkillItem("icons/linux-svgrepo-com.svg", "Linux")
        )
        ));

        H2 featuredProjects = new H2("Featured Projects");
        featuredProjects.addClassNames(Margin.Bottom.NONE, Margin.Top.XLARGE, FontSize.XXXLARGE);

        container.add(intro, new Hr(), skillsHeader, skillsContainer, new Hr(), featuredProjects);

        imageContainer = new OrderedList();
        imageContainer.addClassNames(Gap.MEDIUM, Display.GRID, ListStyleType.NONE, Margin.NONE, Padding.NONE);

        add(container, imageContainer);

    }
}
