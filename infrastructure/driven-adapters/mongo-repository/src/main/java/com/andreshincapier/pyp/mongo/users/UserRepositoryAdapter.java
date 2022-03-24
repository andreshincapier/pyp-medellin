package com.andreshincapier.pyp.mongo.users;

import com.andreshincapier.pyp.model.user.User;
import com.andreshincapier.pyp.model.user.gateways.UserRepository;
import com.andreshincapier.pyp.mongo.config.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAdapter extends
    AdapterOperations<User, UsersData, String, UserDataRepository> implements
    UserRepository {

    @Autowired
    public UserRepositoryAdapter(UserDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper,
            d -> mapper.mapBuilder(d, User.UserBuilder.class).build());
    }
}
