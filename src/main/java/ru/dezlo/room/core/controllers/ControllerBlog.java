package ru.dezlo.room.core.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dezlo.room.core.jwt.JwtFilter;
import ru.dezlo.room.core.jwt.JwtProvider;
import ru.dezlo.room.core.models.ModelBlogArticle;
import ru.dezlo.room.core.requests.RequestBlogOrForumArticle;
import ru.dezlo.room.core.responses.ResponseLikes;
import ru.dezlo.room.core.responses.common.ResponseCommonList;
import ru.dezlo.room.core.responses.common.ResponseCommonOne;
import ru.dezlo.room.core.responses.common.Result;
import ru.dezlo.room.core.services.ServiceBlogArticle;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/blog")
public class ControllerBlog {

    @Autowired
    ServiceBlogArticle serviceBlogArticle;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    JwtFilter jwtFilter;

    /**
     * @return List ModelBlogArticle
     */
    @GetMapping("/articles")
    public ResponseCommonList<ModelBlogArticle> getArticles() {

        Result result;
        List<ModelBlogArticle> payload = null;
        try {
            result = new Result();
            payload = serviceBlogArticle.getBlogList();
        } catch (Exception e) {
            result = Result.builder()
                    .code(1)
                    .message(e.getMessage())
                    .build();
        }
        return ResponseCommonList.<ModelBlogArticle>builder()
                .result(result)
                .payload(payload)
                .build();
    }

    /**
     * @param requestBlogOrForumArticle : {
     *                                  title String,
     *                                  article String
     *                                  hashTagId Integer
     *                                  }
     * @return Result
     */
    @PostMapping("/addArticle")
    public ResponseCommonOne addBlogArticle(@RequestBody RequestBlogOrForumArticle requestBlogOrForumArticle,
                                            ServletRequest servletRequest) {
        Result result;
        String token = jwtFilter.getTokenFromRequest((HttpServletRequest) servletRequest);
        Integer userId = Integer.valueOf(jwtProvider.getUserIdFromToken(token));
        requestBlogOrForumArticle.setAuthorId(userId);
        try {
            serviceBlogArticle.addBlogArticle(requestBlogOrForumArticle);
            result = new Result();
        } catch (Exception e) {
            result = Result.builder()
                    .code(1)
                    .message(e.getLocalizedMessage())
                    .build();
        }
        return ResponseCommonOne.builder()
                .result(result)
                .build();
    }

    /**
     * @return List ResponseLikes
     */
    @GetMapping("/likes/{articleId}")
    public ResponseCommonList<ResponseLikes> getLikes(@PathVariable Integer articleId,
                                                      ServletRequest servletRequest) {
        String token = jwtFilter.getTokenFromRequest((HttpServletRequest) servletRequest);
        Integer userId = Integer.valueOf(jwtProvider.getUserIdFromToken(token));
        Result result;
        List<ResponseLikes> payload = null;
        try {
            payload = serviceBlogArticle.getLikes(articleId, userId);
            result = new Result();
        } catch (Exception e) {
            result = Result.builder()
                    .code(1)
                    .message(e.getLocalizedMessage())
                    .build();
        }
        return ResponseCommonList.<ResponseLikes>builder()
                .result(result)
                .payload(payload)
                .build();
    }

    /**
     * @param request -> articleId Integer
     * @return Result
     */

    @PostMapping("/like")
    public ResponseCommonOne switchLike(@RequestBody Map<String, Integer> request, ServletRequest servletRequest) {
        Result result;
        String token = jwtFilter.getTokenFromRequest((HttpServletRequest) servletRequest);
        Integer userId = Integer.valueOf(jwtProvider.getUserIdFromToken(token));
        try {
            serviceBlogArticle.switchLike(userId, request.get("articleId"));
            result = new Result();
        } catch (Exception e) {
            result = Result.builder()
                    .code(1)
                    .message(e.getLocalizedMessage())
                    .build();
        }
        return ResponseCommonOne.builder()
                .result(result)
                .build();
    }
}
