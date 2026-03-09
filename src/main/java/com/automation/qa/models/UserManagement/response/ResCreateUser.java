package com.automation.qa.models.UserManagement.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResCreateUser {

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("name")
    private String name;

    @JsonProperty("_meta")
    private Meta meta;

    @JsonProperty("id")
    private String id;

    @JsonProperty("job")
    private String job;
}