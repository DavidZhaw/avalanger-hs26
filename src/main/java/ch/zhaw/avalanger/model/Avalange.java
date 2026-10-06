package ch.zhaw.avalanger.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@RequiredArgsConstructor
@Document("avalanges")
public class Avalange {
    @Id 
    private String id;
    @NonNull private String country;
    private AvalangeState state = AvalangeState.NEW;
    @NonNull private String description; 
}
