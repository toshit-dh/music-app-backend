package tech.toshitworks.music.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class GlobalExceptions {

    @GraphQlExceptionHandler
    public GraphQLError handle(NoElementException exception){
        return GraphQLError.newError()
                .message(exception.getMessage())
                .errorType(ErrorType.DataFetchingException)
                .build();
    }
}
