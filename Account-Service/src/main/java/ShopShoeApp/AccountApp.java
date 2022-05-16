package ShopShoeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountApp {
    public static void main(String[] args) {
        SpringApplication.run(AccountApp.class, args);
    }
}