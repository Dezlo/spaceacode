package ru.dezlo.room.core.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dezlo.room.core.models.ModelForumPreview;
import ru.dezlo.room.core.repos.RepoForumArticles;
import ru.dezlo.room.core.repos.RepoForumPreview;
import ru.dezlo.room.core.services.ServiceForumPreview;

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
