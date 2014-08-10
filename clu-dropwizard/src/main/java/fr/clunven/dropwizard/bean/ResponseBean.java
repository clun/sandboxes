package fr.clunven.dropwizard.bean;

import org.hibernate.validator.constraints.Length;

public class ResponseBean {

    private long id;

    @Length(max = 3)
    private String content;

    public ResponseBean() {

    }
}
