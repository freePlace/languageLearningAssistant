package freeplace.lla.model.entities;

import javax.persistence.*;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
@Entity
@Table(name= SiteContent.TABLE_NAME)
public class SiteContent {

    public static final String TABLE_NAME = "site_content";
    public static final String COLUMN_SITE_CONTENT_ID = "site_content_id";
    public static final String COLUMN_ENGLISH = "english";
    public static final String COLUMN_RUSSIAN = "russian";
    public static final String COLUMN_FRENCH = "french";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SITE_CONTENT_ID)
    private Long id;

    @Column(name=COLUMN_ENGLISH)
    private String english;

    @Column(name=COLUMN_RUSSIAN)
    private String russian;

    @Column(name=COLUMN_FRENCH)
    private String french;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getRussian() {
        return russian;
    }

    public void setRussian(String russian) {
        this.russian = russian;
    }

    public String getFrench() {
        return french;
    }

    public void setFrench(String french) {
        this.french = french;
    }
}
