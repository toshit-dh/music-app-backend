package tech.toshitworks.music.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.util.regex.Pattern;

@Configuration
public class CustomScalerConfig {

    GraphQLScalarType durationScaler = ExtendedScalars
            .newRegexScalar("Duration")
            .description("Custom scalar for duration in hh:mm:ss")
            .addPattern(Pattern.compile("^([0-9]{1,2}):([0-5][0-9]):([0-5][0-9])$"))
            .build();

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer(){
        return wiringBuilder -> wiringBuilder
                .scalar(durationScaler)
                .build();

    }


}
