package com.automation.qa.models.UserManagement.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResUpdateUser {
    @JsonProperty("_meta")
    private Meta meta;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
}
