package com.andreshincapier.pyp.model.digits;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Digits {

    private String id;
    private String day;
    private List<Integer> cars;
    private List<Integer> bikes;
}
