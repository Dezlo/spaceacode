package ru.dezlo.room.courses.html;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dezlo.room.courses.Courses;
import ru.dezlo.room.courses.LevelCourses;
import ru.dezlo.room.courses.PayloadCourses;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ServiceHtml {

    public PayloadCourses getHtml() {
        log.debug(">>> ServiceCourses");
        PayloadCourses payloadCourses = new PayloadCourses();
        Courses courses = new Courses();
        List<LevelCourses> list = new ArrayList<>();

        list.add(LevelCourses.builder()
                .id(1)
                .name("Introduction")
                .build());
        list.add(LevelCourses.builder()
                .id(2)
                .name("How create web site")
                .build());
        list.add(LevelCourses.builder()
                .id(3)
                .name("Structure web pages")
                .build());
        list.add(LevelCourses.builder()
                .id(4)
                .name("Body head title")
                .build());
        list.add(LevelCourses.builder()
                .id(5)
                .name("Create webpage on pc")
                .build());
        list.add(LevelCourses.builder()
                .id(6)
                .name("Look how built other site")
                .build());

        courses.setBasic(list);
        list = new ArrayList<>();

        list.add(LevelCourses.builder()
                .id(7)
                .name("Headings")
                .build());
        list.add(LevelCourses.builder()
                .id(8)
                .name("Paragraph")
                .build());
        list.add(LevelCourses.builder()
                .id(9)
                .name("Bold italic tag")
                .build());
        list.add(LevelCourses.builder()
                .id(10)
                .name("Superscript and subscript tag")
                .build());
        list.add(LevelCourses.builder()
                .id(11)
                .name("Line breaks and horizontal rules")
                .build());
        list.add(LevelCourses.builder()
                .id(12)
                .name("Semantic markup")
                .build());
        list.add(LevelCourses.builder()
                .id(13)
                .name("Strong and emphasis")
                .build());
        list.add(LevelCourses.builder()
                .id(14)
                .name("Quotations")
                .build());
        list.add(LevelCourses.builder()
                .id(15)
                .name("Abbreviations and acronyms")
                .build());
        list.add(LevelCourses.builder()
                .id(16)
                .name("Citations and definitions")
                .build());
        list.add(LevelCourses.builder()
                .id(17)
                .name("Author details")
                .build());
        list.add(LevelCourses.builder()
                .id(18)
                .name("Changes content")
                .build());
        list.add(LevelCourses.builder()
                .id(19)
                .name("Lists")
                .build());
        list.add(LevelCourses.builder()
                .id(20)
                .name("Ordered lists")
                .build());
        list.add(LevelCourses.builder()
                .id(21)
                .name("Unordered lists")
                .build());
        list.add(LevelCourses.builder()
                .id(22)
                .name("Definition lists")
                .build());
        list.add(LevelCourses.builder()
                .id(23)
                .name("Nested lists")
                .build());
        list.add(LevelCourses.builder()
                .id(24)
                .name("Links")
                .build());
        list.add(LevelCourses.builder()
                .id(25)
                .name("Linking other site")
                .build());
        list.add(LevelCourses.builder()
                .id(26)
                .name("Linking to other pages")
                .build());
        list.add(LevelCourses.builder()
                .id(27)
                .name("Relative links")
                .build());
        list.add(LevelCourses.builder()
                .id(28)
                .name("Email links")
                .build());
        list.add(LevelCourses.builder()
                .id(29)
                .name("Links on new window")
                .build());
        list.add(LevelCourses.builder()
                .id(30)
                .name("Anchor links")
                .build());
        list.add(LevelCourses.builder()
                .id(31)
                .name("Anchor another page")
                .build());
        list.add(LevelCourses.builder()
                .id(32)
                .name("Images")
                .build());
        list.add(LevelCourses.builder()
                .id(33)
                .name("Storing images")
                .build());
        list.add(LevelCourses.builder()
                .id(34)
                .name("Adding images")
                .build());
        list.add(LevelCourses.builder()
                .id(35)
                .name("Height and width")
                .build());
        list.add(LevelCourses.builder()
                .id(36)
                .name("Place images in code")
                .build());
        list.add(LevelCourses.builder()
                .id(37)
                .name("Old align horizontal")
                .build());
        list.add(LevelCourses.builder()
                .id(38)
                .name("Old align vertical")
                .build());
        list.add(LevelCourses.builder()
                .id(39)
                .name("Rules create images")
                .build());
        list.add(LevelCourses.builder()
                .id(40)
                .name("Tools for edit images")
                .build());
        list.add(LevelCourses.builder()
                .id(41)
                .name("Images format")
                .build());
        list.add(LevelCourses.builder()
                .id(42)
                .name("Image dimensions")
                .build());
        list.add(LevelCourses.builder()
                .id(43)
                .name("Image resolution")
                .build());
        list.add(LevelCourses.builder()
                .id(44)
                .name("Svg")
                .build());
        list.add(LevelCourses.builder()
                .id(45)
                .name("Gif animation and transparency")
                .build());
        list.add(LevelCourses.builder()
                .id(46)
                .name("Check size image")
                .build());
        list.add(LevelCourses.builder()
                .id(47)
                .name("Figure and figcaption")
                .build());
        list.add(LevelCourses.builder()
                .id(48)
                .name("Tables")
                .build());
        list.add(LevelCourses.builder()
                .id(49)
                .name("Table structure")
                .build());
        list.add(LevelCourses.builder()
                .id(50)
                .name("Table heading")
                .build());
        list.add(LevelCourses.builder()
                .id(51)
                .name("Spanning columns")
                .build());
        list.add(LevelCourses.builder()
                .id(52)
                .name("Spanning rows")
                .build());
        list.add(LevelCourses.builder()
                .id(53)
                .name("Long tables")
                .build());
        list.add(LevelCourses.builder()
                .id(54)
                .name("Width and spacing")
                .build());
        list.add(LevelCourses.builder()
                .id(55)
                .name("Border and background")
                .build());
        list.add(LevelCourses.builder()
                .id(56)
                .name("Forms")
                .build());
        list.add(LevelCourses.builder()
                .id(57)
                .name("Form controls")
                .build());
        list.add(LevelCourses.builder()
                .id(58)
                .name("How work forms")
                .build());
        list.add(LevelCourses.builder()
                .id(59)
                .name("Form structure")
                .build());
        list.add(LevelCourses.builder()
                .id(60)
                .name("Text input")
                .build());
        list.add(LevelCourses.builder()
                .id(61)
                .name("Password input")
                .build());
        list.add(LevelCourses.builder()
                .id(62)
                .name("Textarea")
                .build());
        list.add(LevelCourses.builder()
                .id(63)
                .name("Radio button")
                .build());
        list.add(LevelCourses.builder()
                .id(64)
                .name("Checkbox button")
                .build());
        list.add(LevelCourses.builder()
                .id(65)
                .name("Select input")
                .build());
        list.add(LevelCourses.builder()
                .id(66)
                .name("File input")
                .build());
        list.add(LevelCourses.builder()
                .id(67)
                .name("Multiple select input")
                .build());
        list.add(LevelCourses.builder()
                .id(68)
                .name("Image button")
                .build());
        list.add(LevelCourses.builder()
                .id(69)
                .name("Submit button")
                .build());
        list.add(LevelCourses.builder()
                .id(70)
                .name("Button and hidden control")
                .build());
        list.add(LevelCourses.builder()
                .id(71)
                .name("Labeling form controls")
                .build());
        list.add(LevelCourses.builder()
                .id(72)
                .name("Grouping form elements")
                .build());
        list.add(LevelCourses.builder()
                .id(73)
                .name("HTML5 form validation")
                .build());
        list.add(LevelCourses.builder()
                .id(74)
                .name("HTML5 date input")
                .build());
        list.add(LevelCourses.builder()
                .id(75)
                .name("HTML5 email and url_input")
                .build());
        list.add(LevelCourses.builder()
                .id(76)
                .name("HTML5 search input")
                .build());

        courses.setMiddle(list);
        list = new ArrayList<>();

        list.add(LevelCourses.builder()
                .id(77)
                .name("Extra markup")
                .build());
        list.add(LevelCourses.builder()
                .id(78)
                .name("Evolution html")
                .build());
        list.add(LevelCourses.builder()
                .id(79)
                .name("Doctypes")
                .build());
        list.add(LevelCourses.builder()
                .id(80)
                .name("Comments html")
                .build());
        list.add(LevelCourses.builder()
                .id(81)
                .name("Id attribute")
                .build());
        list.add(LevelCourses.builder()
                .id(82)
                .name("Class attribute")
                .build());
        list.add(LevelCourses.builder()
                .id(83)
                .name("Block elements")
                .build());
        list.add(LevelCourses.builder()
                .id(84)
                .name("Inline elements")
                .build());
        list.add(LevelCourses.builder()
                .id(85)
                .name("Grouping text in a block")
                .build());
        list.add(LevelCourses.builder()
                .id(86)
                .name("Grouping text inline")
                .build());
        list.add(LevelCourses.builder()
                .id(87)
                .name("Iframes")
                .build());
        list.add(LevelCourses.builder()
                .id(88)
                .name("Info about your page")
                .build());
        list.add(LevelCourses.builder()
                .id(89)
                .name("Audio video")
                .build());
        list.add(LevelCourses.builder()
                .id(90)
                .name("How flash works")
                .build());
        list.add(LevelCourses.builder()
                .id(91)
                .name("Use flash")
                .build());
        list.add(LevelCourses.builder()
                .id(92)
                .name("Add flash on site")
                .build());
        list.add(LevelCourses.builder()
                .id(93)
                .name("Video format")
                .build());
        list.add(LevelCourses.builder()
                .id(94)
                .name("Using hosted")
                .build());
        list.add(LevelCourses.builder()
                .id(95)
                .name("Prepare video for site")
                .build());
        list.add(LevelCourses.builder()
                .id(96)
                .name("Adding flash on site")
                .build());
        list.add(LevelCourses.builder()
                .id(97)
                .name("HTML5 prepare video")
                .build());
        list.add(LevelCourses.builder()
                .id(98)
                .name("HTML5 adding video")
                .build());
        list.add(LevelCourses.builder()
                .id(99)
                .name("Multiple video source")
                .build());
        list.add(LevelCourses.builder()
                .id(100)
                .name("HTML5 combine flash HTML5")
                .build());
        list.add(LevelCourses.builder()
                .id(101)
                .name("Add audio on page")
                .build());
        list.add(LevelCourses.builder()
                .id(102)
                .name("Add flash mp3")
                .build());
        list.add(LevelCourses.builder()
                .id(103)
                .name("HTML5 audio")
                .build());
        list.add(LevelCourses.builder()
                .id(104)
                .name("HTML5 multiple audio")
                .build());

        courses.setExpert(list);
        payloadCourses.setCourse(courses);

        courses = new Courses();
        list = new ArrayList<>();

        list.add(LevelCourses.builder()
                .id(105)
                .name("First page")
                .build());
        list.add(LevelCourses.builder()
                .id(106)
                .name("Second page")
                .build());
        list.add(LevelCourses.builder()
                .id(107)
                .name("Third page")
                .build());

        courses.setBasic(list);
        list = new ArrayList<>();

        list.add(LevelCourses.builder()
                .id(108)
                .name("Text exam")
                .build());
        list.add(LevelCourses.builder()
                .id(109)
                .name("Lists exam")
                .build());
        list.add(LevelCourses.builder()
                .id(110)
                .name("Links exam")
                .build());
        list.add(LevelCourses.builder()
                .id(111)
                .name("Images exam")
                .build());
        list.add(LevelCourses.builder()
                .id(112)
                .name("Tables exam")
                .build());
        list.add(LevelCourses.builder()
                .id(113)
                .name("Forms exam")
                .build());

        courses.setMiddle(list);
        list = new ArrayList<>();

        list.add(LevelCourses.builder()
                .id(114)
                .name("Extra markup exam")
                .build());
        list.add(LevelCourses.builder()
                .id(115)
                .name("Flash audio video exam")
                .build());
        courses.setExpert(list);
        payloadCourses.setCourseExam(courses);

        log.debug("<<< ServiceCourses");
        return payloadCourses;
    }
}
