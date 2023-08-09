package training.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Movie implements Serializable {
    @Id
    @Column(name = "movie_id", unique = true, nullable = false, length = 10)
    @Length(max=10)
    private String movieId;

    @Column(nullable = false)
    @NotEmpty(message = "Actor must not be empty")
    private String actor;

    @Column(nullable = false, length = 1000)
    @NotEmpty(message = "Content must not be empty")
    @Length(max=1000)
    private String content;

    @Column(nullable = false)
    @NotEmpty(message = "Director must not be empty")
    private String director;

    @Column(nullable = false)
    @NotNull(message = "Duration must not be empty")
    private Double duration;

    @Column(nullable = false)
    @NotNull(message = "From date must not be null")
    private LocalDate fromDate;

    @Column(nullable = false)
    @NotNull(message = "To date must not be null")
    private LocalDate toDate;

    @Column(nullable = false)
    @NotEmpty(message = "Movie production company must not be empty")
    private String movieProductionCompany;

    @Column(nullable = false)
    @NotEmpty(message = "Version must not be empty")
    private String version;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Movie name eng must not be empty")
    private String movieNameEng;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Movie name vn must not be empty")
    private String movieNameVn;

    @Column(nullable = false)
    @NotEmpty(message = "Large image must not be empty")
    private String largeImage;

    @Column(nullable = false)
    @NotEmpty(message = "Small image must not be empty")
    private String smallImage;

    @ToString.Exclude
    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<MovieType> movieType;
}
