package freeplace.lla.model.entities;

import javax.persistence.*;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
@Entity
@Table(name= MainMenuItem.TABLE_NAME)
public class MainMenuItem {

    public static final String TABLE_NAME = "main_menu_item";
    public static final String COLUMN_MAIN_MENU_ITEM_ID = "main_menu_item_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PICTURE_REFERENCE = "picture_reference";
    public static final String COLUMN_LINK = "link";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name=COLUMN_MAIN_MENU_ITEM_ID)
    private Long id;

    @Column(name=COLUMN_NAME)
    private String name;

    @Column(name=COLUMN_PICTURE_REFERENCE)
    private String pictureReference;

    @Column(name=COLUMN_LINK)
    private String columnLink;

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

    public String getPictureReference() {
        return pictureReference;
    }

    public void setPictureReference(String pictureReference) {
        this.pictureReference = pictureReference;
    }

    public String getColumnLink() {
        return columnLink;
    }

    public void setColumnLink(String columnLink) {
        this.columnLink = columnLink;
    }
}
