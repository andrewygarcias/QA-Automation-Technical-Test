package com.automation.qa.models.UserManagement.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cta{

    @JsonProperty("label")
    private String label;

    @JsonProperty("url")
    private String url;
}