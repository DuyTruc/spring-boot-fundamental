package fpt.m2;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		stringConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
		converters.add(stringConverter);
	}
}
