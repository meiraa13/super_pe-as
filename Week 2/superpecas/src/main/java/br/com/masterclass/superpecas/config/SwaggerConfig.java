package br.com.masterclass.superpecas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI defineOpenApi(){
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        Contact contact = new Contact();
        contact.setName("Marcelo Meirelles");
        contact.setEmail("meirellesm@hotmail.com");

        Info info = new Info();
        info.title("Api developed for Masterclass");
        info.version("1.0");
        info.description("api for managing cars and car pieces");
        info.contact(contact);

        return new OpenAPI().info(info).servers(List.of(server));

    }
}
