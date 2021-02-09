package ru.dezlo.room.enterprise.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dezlo.room.enterprise.models.ModelForumPreview;
import ru.dezlo.room.enterprise.repos.RepoForumArticles;
import ru.dezlo.room.enterprise.repos.RepoForumPreview;
import ru.dezlo.room.enterprise.services.ServiceForumPreview;

import java.util.List;

@Service
public class ServiceForumPreviewImpl implements ServiceForumPreview {

    @Autowired
    RepoForumPreview repoForumPreview;

    @Autowired
    RepoForumArticles repoForumArticles;

    public List<ModelForumPreview> preview() {

        List<ModelForumPreview> list = repoForumPreview.findAll();
        return list;
    }
}
