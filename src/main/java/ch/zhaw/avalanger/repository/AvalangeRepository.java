package ch.zhaw.avalanger.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.avalanger.model.Avalange;
import ch.zhaw.avalanger.model.AvalangeState;
import ch.zhaw.avalanger.model.AvalangeStateAggregation;

public interface AvalangeRepository extends MongoRepository<Avalange, String> {
    List<Avalange> findByCountryAndState(String country, AvalangeState state);
    List<Avalange> findByCountry(String country);
    List<Avalange> findByState(AvalangeState state);

    @Aggregation(pipeline = {
        "{'$group': {'_id': '$state', 'avalange_count': {'$count': {}}}}",
        "{'$project': {'state': '$_id', 'avalange_count': 1, '_id': 0}}"
    })
    List<AvalangeStateAggregation> findAvalangeStates();

}
