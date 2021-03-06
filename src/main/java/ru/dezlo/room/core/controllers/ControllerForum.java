package ru.dezlo.room.core.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dezlo.room.core.jwt.JwtFilter;
import ru.dezlo.room.core.jwt.JwtProvider;
import ru.dezlo.room.core.models.ModelForumArticle;
import ru.dezlo.room.core.models.ModelForumComment;
import ru.dezlo.room.core.models.ModelForumPreview;
import ru.dezlo.room.core.requests.RequestForumComment;
import ru.dezlo.room.core.responses.ResponseLikes;
import ru.dezlo.room.core.responses.common.ResponseCommonList;
import ru.dezlo.room.core.responses.common.ResponseCommonOne;
import ru.dezlo.room.core.responses.common.Result;
import ru.dezlo.room.core.services.ServiceForumArticle;
import ru.dezlo.room.core.services.ServiceForumComment;
import ru.dezlo.room.core.services.ServiceForumPreview;
import ru.dezlo.room.utils.ErrorCodes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/forum")
public class ControllerForum {

    @Autowired
    ServiceForumArticle serviceForumArticle;

    @Autowired
    ServiceForumComment serviceForumComment;

    @Autowired
    ServiceForumPreview serviceForumPreview;

    @Autowired
    JwtFilter jwtFilter;

    @Autowired
    JwtProvider jwtProvider;


    /**
     * @param hashTagId Integer
     * @return List ModelForumArticle
     */

    @GetMapping("/articles/{hashTagId}")
    public ResponseCommonList<ModelForumArticle> getArticles(@PathVariable Integer hashTagId) {
        Result result;
        List<ModelForumArticle> payload = new ArrayList<>();
        try {
            payload = serviceForumArticle.getForumList(hashTagId);
            result = new Result();
        } catch (Exception e) {
            result = Result.builder()
                    .code(1)
                    .message(e.getLocalizedMessage())
                    .build();
        }
        return ResponseCommonList.<ModelForumArticle>builder()
                .result(result)
                .payload(payload)
                .build();
    }

    /**
     * @param modelForumArticle :{
     *                          title String,
     *                          article String,
     *                          hashTagId Integer
     *                          }
     * @return Result
     */

    @PostMapping("/addArticle")
    public ResponseCommonOne addForumArticle(@RequestBody ModelForumArticle modelForumArticle,
                                             ServletRequest servletRequest) {
        Result result;
        String token = jwtFilter.getTokenFromRequest((HttpServletRequest) servletRequest);
        log.debug("addForumArticleToken: " + token);
        Integer userId = Integer.valueOf(jwtProvider.getUserIdFromToken(token));
        modelForumArticle.setAuthorId(userId);
        try {
            serviceForumArticle.addForumArticle(modelForumArticle);
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
     * @param articleId Integer
     * @return List ModelForumComment
     */
    @GetMapping("/comment/{articleId}")
    public ResponseCommonList<ModelForumComment> forumComment(@PathVariable Integer articleId, ServletRequest servletRequest) {
        Result result;
        List<ModelForumComment> payload = null;
        String token = jwtFilter.getTokenFromRequest((HttpServletRequest) servletRequest);
        Integer userId = Integer.valueOf(jwtProvider.getUserIdFromToken(token));
        try {
            payload = serviceForumComment.getComments(userId, articleId);
            result = new Result();
        } catch (Exception e) {
            log.debug(e.getLocalizedMessage());
            result = Result.builder()
                    .code(1)
                    .message(e.getLocalizedMessage())
                    .build();
        }
        return ResponseCommonList.<ModelForumComment>builder()
                .result(result)
                .payload(payload)
                .build();
    }

    /**
     * @param requestForumComment: {
     *                             articleId Integer,
     *                             message String
     *                             }
     * @return Result
     */

    @PostMapping("/addComment")
    public ResponseCommonOne addForumComment(@RequestBody RequestForumComment requestForumComment,
                                             ServletRequest servletRequest) {
        log.debug("requestForumComment: " + requestForumComment);
        String token = jwtFilter.getTokenFromRequest((HttpServletRequest) servletRequest);
        Integer userId = Integer.valueOf(jwtProvider.getUserIdFromToken(token));
        Result result;
        requestForumComment.setAuthorId(userId);
        try {
            serviceForumComment.addForumComment(requestForumComment);
            result = Result.builder()
                    .code(ErrorCodes.forCode(ErrorCodes.NO_ERRORS))
                    .message(ErrorCodes.forMessage(ErrorCodes.NO_ERRORS))
                    .build();
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
     * @return List ModelForumPreview
     */

    @GetMapping("/preview")
    public ResponseCommonList<ModelForumPreview> preview() {
        Result result;
        List<ModelForumPreview> payload = null;
        try {
            payload = serviceForumPreview.preview();
            result = Result.builder()
                    .code(ErrorCodes.forCode(ErrorCodes.NO_ERRORS))
                    .message(ErrorCodes.forMessage(ErrorCodes.NO_ERRORS))
                    .build();
        } catch (Exception e) {
            result = Result.builder()
                    .code(1)
                    .message(e.getLocalizedMessage())
                    .build();
        }
        return ResponseCommonList.<ModelForumPreview>builder()
                .result(result)
                .payload(payload)
                .build();
    }

    /**
     * @param articleId Integer
     * @return List ResponseLikes
     */

    @GetMapping("/likes/{articleId}")
    public ResponseCommonList<ResponseLikes> getLikes(@PathVariable Integer articleId,
                                                      ServletRequest servletRequest) {
        String token = jwtFilter.getTokenFromRequest((HttpServletRequest) servletRequest);
        Integer userId = Integer.valueOf(jwtProvider.getUserIdFromToken(token));
        log.debug("token: " + token);
        log.debug("articleId: " + articleId);
        log.debug("userId: " + userId);
        Result result;
        List<ResponseLikes> payload = null;
        try {
            payload = serviceForumArticle.getLikes(articleId, userId);
            result = Result.builder()
                    .code(ErrorCodes.forCode(ErrorCodes.NO_ERRORS))
                    .message(ErrorCodes.forMessage(ErrorCodes.NO_ERRORS))
                    .build();
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
        log.debug("request: " + request);
        Result result;
        String token = jwtFilter.getTokenFromRequest((HttpServletRequest) servletRequest);
        log.debug("token: " + token);
        Integer userId = Integer.valueOf(jwtProvider.getUserIdFromToken(token));
        log.debug("userId: " + userId);
        try {
            serviceForumArticle.switchLike(userId, request.get("articleId"));
            result = Result.builder()
                    .code(ErrorCodes.forCode(ErrorCodes.NO_ERRORS))
                    .message(ErrorCodes.forMessage(ErrorCodes.NO_ERRORS))
                    .build();
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
     * @param commentId Integer
     * @return List ResponseLikes
     */
    @GetMapping("/likes/comment/{commentId}")
    public ResponseCommonList<ResponseLikes> getCommentLikes(@PathVariable Integer commentId,
                                                             ServletRequest servletRequest) {
        String token = jwtFilter.getTokenFromRequest((HttpServletRequest) servletRequest);
        Integer userId = Integer.valueOf(jwtProvider.getUserIdFromToken(token));
        Result result;
        List<ResponseLikes> payload = null;
        try {
            payload = serviceForumComment.getCommentLikes(commentId, userId);
            result = Result.builder()
                    .code(ErrorCodes.forCode(ErrorCodes.NO_ERRORS))
                    .message(ErrorCodes.forMessage(ErrorCodes.NO_ERRORS))
                    .build();
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
     * @param request -> commentId Integer
     * @return Result
     */
    @PostMapping("/commentLike")
    public ResponseCommonOne switchCommentLike(@RequestBody Map<String, Integer> request, ServletRequest servletRequest) {
        Result result;
        String token = jwtFilter.getTokenFromRequest((HttpServletRequest) servletRequest);
        Integer userId = Integer.valueOf(jwtProvider.getUserIdFromToken(token));
        try {
            serviceForumComment.switchLike(userId, request.get("commentId"));
            result = Result.builder()
                    .code(ErrorCodes.forCode(ErrorCodes.NO_ERRORS))
                    .message(ErrorCodes.forMessage(ErrorCodes.NO_ERRORS))
                    .build();
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
