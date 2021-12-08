public class Email {

    private String title;
    private String body;
    private User sender;
    private User receiver;
    private Boolean status;

    public Email() {

    }

    public Email(String title, String body, User sender, User receiver, Boolean status) {
        this.title = title;
        this.body = body;
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
