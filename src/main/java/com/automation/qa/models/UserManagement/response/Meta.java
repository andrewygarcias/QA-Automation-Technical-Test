package com.automation.qa.models.UserManagement.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta{

    @JsonProperty("docs_url")
    private String docsUrl;

    @JsonProperty("cta")
    private Cta cta;

    @JsonProperty("powered_by")
    private String poweredBy;

    @JsonProperty("variant")
    private String variant;

    @JsonProperty("context")
    private String context;

    @JsonProperty("message")
    private String message;

    @JsonProperty("example_url")
    private String exampleUrl;

    @JsonProperty("upgrade_url")
    private String upgradeUrl;
}