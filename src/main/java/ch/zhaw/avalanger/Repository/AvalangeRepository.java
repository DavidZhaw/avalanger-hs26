package ch.zhaw.avalanger.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import ch.zhaw.avalanger.model.Avalange;
import ch.zhaw.avalanger.model.AvalangeState;

public interface AvalangeRepository extends MongoRepository<Avalange, String> {
    List<Avalange> findByCountryAndState(String country, AvalangeState state);
    List<Avalange> findByCountry(String country); 
    List<Avalange> findByState(AvalangeState state);
}
