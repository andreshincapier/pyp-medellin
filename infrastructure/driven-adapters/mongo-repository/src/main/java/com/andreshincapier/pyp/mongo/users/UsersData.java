package com.andreshincapier.pyp.mongo.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "DNAAnalysis")
@NoArgsConstructor
public class UsersData {

    @Id
    private String id;
    private String name;
    private Integer phone;
    private String plaque;
}
