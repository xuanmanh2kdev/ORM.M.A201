package training.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_type_id", unique = true, nullable = false)
    private Integer movieTypeId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    @ToString.Exclude
    private Movie movie;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    @ToString.Exclude
    private Type type;

    @Column(nullable = false)
    @NotEmpty(message = "Movie type description is required")
    private String mtDescription;

}
