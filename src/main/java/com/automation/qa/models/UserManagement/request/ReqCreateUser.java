package com.automation.qa.models.UserManagement.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqCreateUser {
    @JsonProperty("name")
    private String name;

    @JsonProperty("job")
    private String job;
}
