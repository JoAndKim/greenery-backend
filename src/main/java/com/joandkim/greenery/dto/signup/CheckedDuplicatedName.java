package com.joandkim.greenery.dto.signup;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckedDuplicatedName {
    private Boolean isExistingUsername;
    private Boolean isExistingNickname;
}
