package cn.porsche.omp.config.swagger;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:false}")
public class SwaggerConfig {

  @Bean
  public Docket controllerApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(new ApiInfoBuilder()
            .title("APIs for Porsche OMP Sample Service")
            .description("Description: ...")
            .contact(new Contact("", "", ""))
            .version("0.0.1")
            .build())
        .select()
        .apis(RequestHandlerSelectors.basePackage("cn.porsche.omp"))
        .paths(PathSelectors.any())
        .build()
        .securitySchemes(securitySchemes())
        .securityContexts(securityContexts());
  }

  private List<ApiKey> securitySchemes() {
    return newArrayList(
        new ApiKey("Authorization", "Authorization", "header"),
        new ApiKey("X-JWT-TOKEN", "X-JWT-TOKEN", "header")
    );
  }

  private List<SecurityContext> securityContexts() {
    return newArrayList(
        SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.any())
            .build()
    );
  }

  List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    return newArrayList(
        new SecurityReference("Authorization", new AuthorizationScope[]{authorizationScope}),
        new SecurityReference("X-JWT-TOKEN", new AuthorizationScope[]{authorizationScope}));
  }
}
