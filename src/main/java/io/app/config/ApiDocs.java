package io.app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.EnableMBeanExport;

@OpenAPIDefinition(
		info = @Info(
				title = "BANKING-DOCS",
				description = "This comprehensive banking system facilitates account management, allowing users to seamlessly add, delete, deposit, and withdraw funds. With a straightforward interface, it empowers clients to efficiently handle their financial transactions, ensuring a user-friendly and secure banking experience.",
				termsOfService = "T&C",
				contact = @Contact(
						name = "Jhantu Bala",
						email = "jhantubala626@gmail.com"
				),
				version = "V1"
		),
		servers = {
				@Server(
						description = "Prod",
						url = "http://localhost:8081"
				),
				@Server(
						description = "Test",
						url = "http://localhost:8081"
				)
		}
)
public class ApiDocs {
}
