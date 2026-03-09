package com.automation.qa.models.UserManagement.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResGetUserId {
    @JsonProperty("data")
    private DataR data;

    @JsonProperty("support")
    private Support support;

    @JsonProperty("_meta")
    private Meta meta;


}
