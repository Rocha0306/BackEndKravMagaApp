package com.Krav.api.Infra.Notifications;
import java.util.List;

public class Emails {

    private List<String> emails;

    private String subject;

    private String body;

    public Emails(List<String> emails, String subject, String body) {
        this.emails = emails;
        this.subject = subject;
        this.body = body;
    }
    public void SendEmail() {

    }

    //Polimorfismo
    //
}
