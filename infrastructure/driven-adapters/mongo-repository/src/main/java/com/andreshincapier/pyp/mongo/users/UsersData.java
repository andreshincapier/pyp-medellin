package com.andreshincapier.pyp.mongo.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "UserDocument")
@NoArgsConstructor
public class UsersData {

    @Id
    private String id;
    private String name;
    private String phone;
    private String type;
    private String plaque;
}
