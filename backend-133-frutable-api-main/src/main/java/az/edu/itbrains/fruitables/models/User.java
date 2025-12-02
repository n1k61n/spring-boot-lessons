package az.edu.itbrains.fruitables.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "users", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy = "user")
    private List<RefreshToken> refreshTokens;
}
