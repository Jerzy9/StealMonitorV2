package config;

import org.jsoup.nodes.Element;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"products"})
public class LoaderConfig {
	
	@Bean
	public Element element() {
		
		return null;
	}

}
