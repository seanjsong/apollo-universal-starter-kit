package graphql.schema;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.model.Counter;
import graphql.repository.CounterRepository;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    Logger logger = LogManager.getLogger(Query.class);

    @Autowired
    private CounterRepository counterRepository;

    public Counter serverCounter() {
        logger.info("Get amount");
        return counterRepository.findById(1).get(); //TODO Unsafe
    }
}
