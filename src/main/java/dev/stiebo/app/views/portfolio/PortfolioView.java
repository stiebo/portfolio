package dev.stiebo.app.views.portfolio;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.util.List;
import java.util.Optional;

@PageTitle("Portfolio Stefan Bock")
@Route("")
public class PortfolioView extends Main implements HasComponents, HasStyle {

    private OrderedList imageContainer;

    public PortfolioView() {
        constructUI();
        addPortfolioCards();
    }


    private void constructUI() {
        addClassNames("portfolio-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        VerticalLayout headerContainer = new VerticalLayout();
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
        H1 introJob = new H1("Software Engineer");
        Paragraph introText = new Paragraph("""
                                As an experienced engineer and innovation manager with profound knowledge in
                                software development, including Java and Spring Boot, I bring a unique blend of
                                technical expertise and strategic insight to every project. My enthusiasm for software
                                development and dedication to learning ensure that I stay at the forefront
                                of emerging technologies, while my global perspective and inter-disciplinary experience
                                add fresh and innovative ideas.
                """);

        HorizontalLayout introLinks = createContactLinks();

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

        headerContainer.add(intro, new Hr(), skillsHeader, skillsContainer, new Hr(), featuredProjects);

        imageContainer = new OrderedList();
        imageContainer.addClassNames(Gap.MEDIUM, Display.GRID, ListStyleType.NONE, Margin.NONE, Padding.NONE);

        H2 contactTitle = new H2("Contact");
        contactTitle.addClassNames(Margin.Bottom.NONE, Margin.Top.XLARGE, FontSize.XXXLARGE);
        Span contactName = new Span("Stefan Bock");
        Span contactEmail = new Span("stiefbock@outlook.at");
        HorizontalLayout contactLinks = createContactLinks();
        VerticalLayout contactContainer = new VerticalLayout();
        contactContainer.setPadding(false);
        contactContainer.setSpacing(false);
        contactContainer.add(contactTitle, contactName, contactEmail, contactLinks);

        add(headerContainer, imageContainer, contactContainer);

    }

    private HorizontalLayout createContactLinks()  {
        HorizontalLayout linksContainer = new HorizontalLayout();
        linksContainer.setSpacing(true);
        linksContainer.setAlignItems(FlexComponent.Alignment.START);

        SvgIcon linkedInIcon = LineAwesomeIcon.LINKEDIN.create();
        Anchor linkedInLink = new Anchor("https://www.linkedin.com/in/stefan-bock");
        linkedInLink.setTarget("_blank");
        linkedInLink.add(linkedInIcon);

        SvgIcon githubIcon = LineAwesomeIcon.GITHUB.create();
        Anchor githubLink = new Anchor("https://www.github.com/stiebo");
        githubLink.setTarget("_blank");
        githubLink.add(githubIcon);

        SvgIcon jetBrainsIcon = new SvgIcon("icons/jetbrains-academy.svg");
        jetBrainsIcon.setSize("16px");
        Anchor jetBrainsAcademyLink = new Anchor("https://hyperskill.org/profile/500961738");
        jetBrainsAcademyLink.setTarget("_blank");
        jetBrainsAcademyLink.add(jetBrainsIcon);

        linksContainer.add(linkedInLink, githubLink, jetBrainsAcademyLink);
        return linksContainer;
    }

    private void addPortfolioCards() {
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/TransactionSystem.jpg",
                "Transaction System",
                "Java, Vaadin, Spring, JPA, Security, H2",
                """
                        The project demonstrates a transaction system with real-time detection and prevention of
                        potentially fraudulent activities. It helps businesses mitigate risk by leveraging algorithms,
                        blacklists, and transaction scoring. With an intuitive interface, bank clerks can review
                        suspicious transactions and take action.
                        """,
                Optional.of("https://stiebo.dev/transactionsystem"),
                "https://github.com/stiebo/transaction-system"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/ChatWithDocs.jpg",
                "GenAI Document Chat Client",
                "Vaadin, SpringAI, RAG, PGVector",
                """
                        A chat client that can answer questions to your own, internal documents. Upload any document
                        into the database and then "chat with your documents" using chat. The demo uses OpenAI chat
                        and embedding models for performance reasons but can easily be adopted to use Ollama for a
                        pure offline and more data sensitive rollout.
                        """,
                Optional.of("https://stiebo.dev/chatwithdocs/"),
                "https://github.com/stiebo/spring-ai-samples-vaadin"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/AiUtilities.jpg",
                "AI Utilities",
                "SpringAI, OpenAI, PostgreSQL, RAG, multimodal",
                """
                        AI Utilities demos the usage of SpringAI together with OpenAI for various sample applications:
                        'Flashcards' accepts any image or pdf and can create Q&A flashcards for learning purposes.
                        'Chat with my docs' uses RAG to provide chat functionality for any pdf-documents.
                        'CV Analyzer' can analyze any CV and returns its content in a structured JSON format.
                        """,
                Optional.of("https://stiebo.dev/aiutilities/swagger-ui/index.html"),
                "https://github.com/stiebo/spring-ai-samples"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/OpenAPI.jpg",
                "API First / OpenAPI",
                "OpenAPI Generator Maven Plugin ",
                """
                        Same project idea as the Transaction System RestAPI (see below), but showcasing an API First
                        approach. Instead of a controller implemented in Java, all API functionality is defined in an
                        OpenAPI YAML file and the source code generated through the Maven Generator Plugin. Controller
                        and Service layer are connected using the delegate pattern.
                        """,
                Optional.empty(),
                "https://github.com/stiebo/openapi-generator-sample"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/QuarkusRestApi.jpg",
                "Quarkus RestAPI",
                "Quarkus, OpenAPI, GraalVM native",
                """
                        Functionality of this project is similar to the Transaction System RestAPI, but instead of
                        Spring Boot it is implemented using Quarkus. Built as a GraalVM native image it is
                        significantly faster at startup compared to a Spring application and could therefore be
                        deployed in serverless setups.
                        """,
                Optional.of("https://stiebo.dev/quarkusantifraudsystem/q/swagger-ui/"),
                "https://github.com/stiebo/quarkus-anti-fraud-system"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/AntiFraud.jpg",
                "Transaction System RestAPI",
                "Spring, JPA, H2, Security, OpenAPI, JUnit",
                """
                        The project demonstrates a RestAPI for a transaction system with real-time detection and
                        prevention of potentially fraudulent activities. It is created with Spring Boot, Spring Data JPA
                        and Spring Security to showcase a basic RestController with security enabled.
                        """,
                Optional.of("https://stiebo.dev/antifraudsystem/swagger-ui/index.html"),
                "https://github.com/stiebo/Anti-Fraud-System"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/Blockchain.jpg",
                "Blockchain",
                "Java, Crypto mining, Blockchain, Multithreading",
                """
                        Blockchains are data structures where blocks are inseparably connected. What makes blockchains
                        so special is the security level they offer due to the way they are constructed.
                        This project is creating a microcosm where virtual miners earn cryptocurrency and exchange
                        messages and coins using blockchain.
                        """,
                Optional.empty(),
                "https://github.com/stiebo/Blockchain"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/AccountService.jpg",
                "Account Service RestAPI",
                "Java, Spring, Security, JPA, H2",
                """
                        RestAPI for employee accounts and payroll management.
                        The project showcases the Spring Security module, basic user authentication and authorization,
                        how to register security events, and how to handle modern information security standards for
                        web applications.
                        """,
                Optional.empty(),
                "https://github.com/stiebo/AccountService"
        )));
        imageContainer.add(new PortfolioViewCard(new PortfolioCardData(
                "images/JsonDatabase.jpg",
                "JSON Server/Client Exchange",
                "Java, JSON, Gson, Socket, Multithreading",
                """
                        The project showcases skills of working with complex JSON structures. It creates a functional
                        server that exchanges data with clients and can handle multiple requests. A database stores
                        complex data structures as JSON, including objects, arrays and numbers as values.
                        """,
                Optional.empty(),
                "https://github.com/stiebo/JsonDatabaseWithJava_JetBrainsAcademy"
        )));
    }


}
