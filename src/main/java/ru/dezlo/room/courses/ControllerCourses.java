package ru.dezlo.room.courses;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dezlo.room.core.responses.common.Result;
import ru.dezlo.room.courses.css.ServiceCss;
import ru.dezlo.room.courses.html.ServiceHtml;

@RestController
@Slf4j
@CrossOrigin
public class ControllerCourses {

    @Autowired
    ServiceHtml serviceHtml;

    @Autowired
    ServiceCss serviceCss;

    @GetMapping("/html")
    public ResponseCourses html() {
        log.debug(">>> html");
        ResponseCourses responseCourses;
        PayloadCourses payloadCourses = serviceHtml.getHtml();
        Result result;
        result = Result.builder()
                .code(0)
                .message("No error")
                .build();
        responseCourses = ResponseCourses.builder()
                .result(result)
                .payload(payloadCourses)
                .build();
        log.debug("<<< html");
        return responseCourses;
    }

    @GetMapping("/css")
    public ResponseCourses css() {
        ResponseCourses responseCourses;
        PayloadCourses payloadCourses = serviceCss.getCss();
        Result result;
        result = Result.builder()
                .code(0)
                .message("No error")
                .build();
        responseCourses = ResponseCourses.builder()
                .result(result)
                .payload(payloadCourses)
                .build();
        return responseCourses;
    }
}
