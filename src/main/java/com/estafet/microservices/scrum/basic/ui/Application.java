package com.estafet.microservices.scrum.basic.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;
import io.opentracing.Tracer;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public static Tracer init() {
		final SamplerConfiguration samplerConfig = SamplerConfiguration.fromEnv().withType("const")
				.withParam(new Integer(1));
		final ReporterConfiguration reportConfig = ReporterConfiguration.fromEnv().withLogSpans(Boolean.TRUE);
		final io.jaegertracing.Configuration configuration = new io.jaegertracing.Configuration("basic-ui")
				.withSampler(samplerConfig).withReporter(reportConfig);
		return configuration.getTracer();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}
}
