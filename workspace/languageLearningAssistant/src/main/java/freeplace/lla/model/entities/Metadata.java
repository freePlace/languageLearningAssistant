package freeplace.lla.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name=Metadata.TABLE_NAME)
public class Metadata {

    public static final String TABLE_NAME = "metadata";
    public static final String COLUMN_METADATA_ID = "metadata_id";
    public static final String COLUMN_PROJECT_NAME = "project_name";
    public static final String COLUMN_AUTHOR_NAME = "author_name";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name=COLUMN_METADATA_ID)
    private Long id;
    @Column(name=COLUMN_PROJECT_NAME)
    private String projectName;
    @Column(name=COLUMN_AUTHOR_NAME)
    private String authorName;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        Metadata other = (Metadata) obj;
        return Objects.equal(this.id, other.id)
                && Objects.equal(this.projectName, other.projectName)
                && Objects.equal(this.authorName, other.authorName);
    }
    
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.id, this.projectName, this.authorName);
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id)
                .add("projectName", projectName)
                .add("authorName", authorName)
                .omitNullValues()
                .toString();
    }
}
