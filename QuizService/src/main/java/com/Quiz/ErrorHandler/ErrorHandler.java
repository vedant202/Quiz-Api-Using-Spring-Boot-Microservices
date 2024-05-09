package com.Quiz.ErrorHandler;

import java.util.Arrays;
import java.util.List;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ErrorHandler extends DataFetcherExceptionResolverAdapter {

	@Override
	protected List<GraphQLError> resolveToMultipleErrors(Throwable ex, DataFetchingEnvironment env) {
		// TODO Auto-generated method stub

		GraphQLError error = GraphqlErrorBuilder.newError(env).message(ex.getMessage()).build();


		return Arrays.asList(error);
	}

}
