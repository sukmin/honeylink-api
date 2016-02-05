package kr.netty.honeylink.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages={"kr.netty.honeylink.api"},
	excludeFilters={
		@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
	}
)
public class RootConfig {

}
