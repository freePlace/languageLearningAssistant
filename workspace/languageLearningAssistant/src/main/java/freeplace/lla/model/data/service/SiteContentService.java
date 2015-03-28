package freeplace.lla.model.data.service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
public interface SiteContentService<SiteContent> extends BasicService<SiteContent>{
    List<SiteContent> get();
}
