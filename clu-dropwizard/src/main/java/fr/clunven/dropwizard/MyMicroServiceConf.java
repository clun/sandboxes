package fr.clunven.dropwizard;

import java.io.Serializable;

import io.dropwizard.Configuration;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The data are loaded from yaml fichier.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class MyMicroServiceConf extends Configuration implements Serializable {

    /** serial. */
    private static final long serialVersionUID = -4438325515818458918L;

    /** Property. */
    @NotEmpty
    private String message;

    @NotEmpty
    private String defaultName = "alors";

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public void setMessage(String template) {
        this.message = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

}
