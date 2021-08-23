package task23.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "support_tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numberTicket;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String topic;
    @Column
    private String text;
    @Column
    private String status;

}
