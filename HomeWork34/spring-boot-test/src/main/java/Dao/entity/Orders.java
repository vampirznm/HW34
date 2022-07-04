package Dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "\"order\"")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client clientid;

    @OneToOne
    @JoinColumn(name = "cost")
    private OrderDetails cost;
}