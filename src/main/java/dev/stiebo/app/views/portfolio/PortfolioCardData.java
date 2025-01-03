package dev.stiebo.app.views.portfolio;

import java.util.Optional;

public record PortfolioCardData(
        String imageLink,
        String title,
        String subTitle,
        String description,
        Optional<String> linkDemo,
        String linkGithub
) {
}
