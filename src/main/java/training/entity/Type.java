package training.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Type implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id", unique = true, nullable = false)
    private Integer typeId;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Type name is required")
    private String typeName;

    @Column(nullable = false)
    @NotEmpty(message = "Type description is required")
    private String typeDescription;

    @ToString.Exclude
    @OneToMany(mappedBy = "type", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<MovieType> movieType;
}
