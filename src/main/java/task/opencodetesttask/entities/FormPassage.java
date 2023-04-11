package task.opencodetesttask.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "form_passage")
public class FormPassage {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "person")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "form")
    private Form form;

    @Column(name = "repeatable")
    private boolean repeatable;

    @OneToMany
    private Set<Question> questions;

    @ManyToMany
    @JoinTable(
            name = "form_passage_answer",
            joinColumns = {@JoinColumn(name = "form_passage")},
            inverseJoinColumns = {@JoinColumn(name = "answer")})
    private Set<Answer> answers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormPassage that = (FormPassage) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
