FROM eclipse-temurin:21-jdk
SHELL ["/bin/bash", "-c"]
RUN apt update \
    && apt install -y zip unzip \
    && curl -s "https://get.sdkman.io" | bash \
    && source "$HOME/.sdkman/bin/sdkman-init.sh" \
    && sdk install maven 3.9.5 \
    && sdk install gradle 8.14.2 \
    && sdk install springboot 3.5.3
