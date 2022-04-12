package com.andreshincapier.pyp.mongo.digits;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "DigitsDocument")
@NoArgsConstructor
public class DigitsData {

    @Id
    private String id;
    @Indexed
    private String day;
    private Integer[] cars;
    private Integer[] bikes;
}
