package cjSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
//import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
//@EnableSwagger2
@EnableAsync
@EnableScheduling
public class CjSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CjSecurityApplication.class, args);
	}

/*	@Bean
	public Docket swaggerEmployeeApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	            .apis(RequestHandlerSelectors.basePackage("my page"))
	            .paths(PathSelectors.any())
	        .build()
	        .apiInfo(new ApiInfoBuilder().version("1.0").title("API CjSecurity").description("Documentation API v1.0").build());
	}*/

}
