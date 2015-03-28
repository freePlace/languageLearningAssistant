package freeplace.lla.model.entities;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.List;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
@Entity
@Table(name=Language.TABLE_NAME)
public class Language {

    public static final String TABLE_NAME = "language";
    public static final String COLUMN_LANGUAGE_ID = "language_id";
    public static final String COLUMN_LANGUAGE_NAME = "language_name";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name=COLUMN_LANGUAGE_ID)
    private Long id;

    @Column(name=COLUMN_LANGUAGE_NAME, unique=true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name=Language.COLUMN_LANGUAGE_ID)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final Language other = (Language) object;
        return   Objects.equal(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
