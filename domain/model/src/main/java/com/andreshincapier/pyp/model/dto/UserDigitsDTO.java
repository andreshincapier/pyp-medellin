package com.andreshincapier.pyp.model.dto;

import com.andreshincapier.pyp.model.digits.Digits;
import com.andreshincapier.pyp.model.user.User;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UserDigitsDTO {

    private Digits digits;
    private List<User> userList;
}
