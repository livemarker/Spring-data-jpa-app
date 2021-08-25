package task23.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String login;
    @Column
    private String topic;
    @Column
    private String text;
    @Column
    private String status;

    public Ticket(Integer id, String login, String topic, String text, String status) {
        this.id = id;
        this.login = login;
        this.topic = topic;
        this.text = text;
        this.status = status;
    }

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n id=" + id +
                ", login=" + login +
                ", topic='" + topic + '\'' +
                ", text='" + text + '\'' +
                ", status='" + status + '\'';
    }
}