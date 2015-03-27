package freeplace.lla.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name=Role.TABLE_NAME)
public class Role {

    public static final String TABLE_NAME = "role";
    public static final String COLUMN_ROLE_ID = "role_id";
    public static final String COLUMN_ROLE_NAME = "name";
    
    public Role(){}
    
    public Role(String name) {
        this.name = name;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name=COLUMN_ROLE_ID)
    private Long id;
    
    @Column(name=COLUMN_ROLE_NAME, unique=true)
    private String name;
    
    @OneToMany()
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long roleId) {
        this.id = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id)
                .add("name", name)
                .omitNullValues()
                .toString();
    }
    
    @Override
    public boolean equals(Object object) {
        if(object == null) {
            return false;
        }
        if(getClass() != object.getClass()) {
            return false;
        }
        final Role obj = (Role) object;
        return Objects.equal(this.getId(), obj.getId())
                     && Objects.equal(this.getName(), obj.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.id, this.name);
    }
}