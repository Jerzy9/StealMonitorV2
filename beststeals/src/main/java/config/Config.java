package config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({"controllers"})
public class Config extends WebMvcConfigurerAdapter{
	
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry){
		    registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		}
		
//	@Override
//	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//	      	// Register resource handler for CSS and JS, sciezka 
//			//"D:/statics/" jest zapasowa, bez niej tez dziala, ale niech zostanie
//	      registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/", "D:/statics/")
//	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
//		
//
//	      // Register resource handler for images
//	      registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
//	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
//	   }
}
