package com.Krav.api.Infra.Notifications;


import java.util.ArrayList;
import java.util.List;

public class ExceptionEmails extends Emails {

    private List<String> email;
    private String Subject;
    private String Body;

    public ExceptionEmails(List<String> emails, String Subject, String Body) {
        super(emails, Subject, Body);
    }
}
