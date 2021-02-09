package ru.dezlo.room.courses.css;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dezlo.room.courses.Courses;
import ru.dezlo.room.courses.LevelCourses;
import ru.dezlo.room.courses.PayloadCourses;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ServiceCss {

    public PayloadCourses getCss(){

        PayloadCourses payloadCourses = new PayloadCourses();
        Courses courses = new Courses();
        List<LevelCourses> list = new ArrayList<>();

        list.add(LevelCourses.builder()
                .id(1)
                .name("Intro css")
                .build());
        list.add(LevelCourses.builder()
                .id(2)
                .name("Understand css")
                .build());
        list.add(LevelCourses.builder()
                .id(3)
                .name("Associates style rules")
                .build());
        list.add(LevelCourses.builder()
                .id(4)
                .name("Example css")
                .build());
        list.add(LevelCourses.builder()
                .id(5)
                .name("Internal css")
                .build());
        list.add(LevelCourses.builder()
                .id(6)
                .name("Css selectors")
                .build());
        list.add(LevelCourses.builder()
                .id(7)
                .name("Cascade css")
                .build());
        list.add(LevelCourses.builder()
                .id(8)
                .name("Inheritance css")
                .build());
        list.add(LevelCourses.builder()
                .id(9)
                .name("Why use internal css")
                .build());
        list.add(LevelCourses.builder()
                .id(10)
                .name("Css versions")
                .build());
        courses.setBasic(list);
        list = new ArrayList<>();

        list.add(LevelCourses.builder()
                .id(11)
                .name("Color")
                .build());
        list.add(LevelCourses.builder()
                .id(12)
                .name("Foreground color")
                .build());

        list.add(LevelCourses.builder()
                .id(13)
                .name("Background color")
                .build());
        list.add(LevelCourses.builder()
                .id(14)
                .name("Understanding colors")
                .build());
        list.add(LevelCourses.builder()
                .id(15)
                .name("Contrast")
                .build());
        list.add(LevelCourses.builder()
                .id(16)
                .name("CSS3 opacity and rgba")
                .build());
        list.add(LevelCourses.builder()
                .id(17)
                .name("CSS3 hsl hsla colors")
                .build());
        list.add(LevelCourses.builder()
                .id(18)
                .name("Text")
                .build());
        list.add(LevelCourses.builder()
                .id(19)
                .name("Typeface")
                .build());
        list.add(LevelCourses.builder()
                .id(20)
                .name("Font family")
                .build());
        list.add(LevelCourses.builder()
                .id(21)
                .name("Font size")
                .build());
        list.add(LevelCourses.builder()
                .id(22)
                .name("Scales type")
                .build());
        list.add(LevelCourses.builder()
                .id(23)
                .name("Units type size")
                .build());
        list.add(LevelCourses.builder()
                .id(24)
                .name("Font face")
                .build());
        list.add(LevelCourses.builder()
                .id(25)
                .name("Font formats")
                .build());
        list.add(LevelCourses.builder()
                .id(26)
                .name("Font weight")
                .build());
        list.add(LevelCourses.builder()
                .id(27)
                .name("Font style")
                .build());
        list.add(LevelCourses.builder()
                .id(28)
                .name("Lower upper case")
                .build());
        list.add(LevelCourses.builder()
                .id(29)
                .name("Underline strike")
                .build());
        list.add(LevelCourses.builder()
                .id(30)
                .name("Line height")
                .build());
        list.add(LevelCourses.builder()
                .id(31)
                .name("Letter word spacing")
                .build());
        list.add(LevelCourses.builder()
                .id(32)
                .name("Text align")
                .build());
        list.add(LevelCourses.builder()
                .id(33)
                .name("Vertical align")
                .build());
        list.add(LevelCourses.builder()
                .id(34)
                .name("Text indent")
                .build());
        list.add(LevelCourses.builder()
                .id(35)
                .name("CSS3 text shadow")
                .build());
        list.add(LevelCourses.builder()
                .id(36)
                .name("First letter line")
                .build());
        list.add(LevelCourses.builder()
                .id(37)
                .name("Styling links")
                .build());
        list.add(LevelCourses.builder()
                .id(38)
                .name("Responding to users")
                .build());
        list.add(LevelCourses.builder()
                .id(39)
                .name("Selectors attributes")
                .build());
        list.add(LevelCourses.builder()
                .id(40)
                .name("Box")
                .build());
        list.add(LevelCourses.builder()
                .id(41)
                .name("Box dimensions")
                .build());
        list.add(LevelCourses.builder()
                .id(42)
                .name("Limiting width")
                .build());
        list.add(LevelCourses.builder()
                .id(43)
                .name("Limiting height")
                .build());
        list.add(LevelCourses.builder()
                .id(44)
                .name("Overflowing content")
                .build());
        list.add(LevelCourses.builder()
                .id(45)
                .name("Border margin padding")
                .build());
        list.add(LevelCourses.builder()
                .id(46)
                .name("Border width")
                .build());
        list.add(LevelCourses.builder()
                .id(47)
                .name("Border style")
                .build());
        list.add(LevelCourses.builder()
                .id(48)
                .name("Border color")
                .build());
        list.add(LevelCourses.builder()
                .id(49)
                .name("Shorthand")
                .build());
        list.add(LevelCourses.builder()
                .id(50)
                .name("Padding")
                .build());
        list.add(LevelCourses.builder()
                .id(51)
                .name("Margin")
                .build());
        list.add(LevelCourses.builder()
                .id(52)
                .name("Centering content")
                .build());
        list.add(LevelCourses.builder()
                .id(53)
                .name("IE6 box model")
                .build());
        list.add(LevelCourses.builder()
                .id(54)
                .name("Display property")
                .build());
        list.add(LevelCourses.builder()
                .id(55)
                .name("Hiding boxes")
                .build());
        list.add(LevelCourses.builder()
                .id(56)
                .name("CSS3 border images")
                .build());
        list.add(LevelCourses.builder()
                .id(57)
                .name("CSS3 box shadow")
                .build());
        list.add(LevelCourses.builder()
                .id(58)
                .name("CSS3 rounded corners")
                .build());
        list.add(LevelCourses.builder()
                .id(59)
                .name("CSS3 elliptical shapes")
                .build());
        list.add(LevelCourses.builder()
                .id(60)
                .name("List tables forms")
                .build());
        list.add(LevelCourses.builder()
                .id(61)
                .name("List style type")
                .build());
        list.add(LevelCourses.builder()
                .id(62)
                .name("List style image")
                .build());
        list.add(LevelCourses.builder()
                .id(63)
                .name("List style position")
                .build());
        list.add(LevelCourses.builder()
                .id(64)
                .name("List shorthand")
                .build());
        list.add(LevelCourses.builder()
                .id(65)
                .name("Table properties")
                .build());
        list.add(LevelCourses.builder()
                .id(66)
                .name("Empty cells")
                .build());
        list.add(LevelCourses.builder()
                .id(67)
                .name("Gaps between cells")
                .build());
        list.add(LevelCourses.builder()
                .id(68)
                .name("Styling forms")
                .build());
        list.add(LevelCourses.builder()
                .id(69)
                .name("Styling text inputs")
                .build());
        list.add(LevelCourses.builder()
                .id(70)
                .name("Styling submit buttons")
                .build());
        list.add(LevelCourses.builder()
                .id(71)
                .name("Styling fieldset legends")
                .build());
        list.add(LevelCourses.builder()
                .id(72)
                .name("Problem")
                .build());
        list.add(LevelCourses.builder()
                .id(73)
                .name("Solution")
                .build());
        list.add(LevelCourses.builder()
                .id(74)
                .name("Cursor styles")
                .build());
        list.add(LevelCourses.builder()
                .id(75)
                .name("Devtools first step")
                .build());

        courses.setMiddle(list);
        list = new ArrayList<>();

        list.add(LevelCourses.builder()
                .id(76)
                .name("Layout")
                .build());
        list.add(LevelCourses.builder()
                .id(77)
                .name("Positioning elements")
                .build());
        list.add(LevelCourses.builder()
                .id(78)
                .name("Controlling position elements")
                .build());
        list.add(LevelCourses.builder()
                .id(79)
                .name("Position static")
                .build());
        list.add(LevelCourses.builder()
                .id(80)
                .name("Relative positioning")
                .build());
        list.add(LevelCourses.builder()
                .id(81)
                .name("Absolute positioning")
                .build());
        list.add(LevelCourses.builder()
                .id(82)
                .name("Fixed positioning")
                .build());
        list.add(LevelCourses.builder()
                .id(83)
                .name("Overlapping elements")
                .build());
        list.add(LevelCourses.builder()
                .id(84)
                .name("Floating elements")
                .build());
        list.add(LevelCourses.builder()
                .id(85)
                .name("Using float for blocks")
                .build());
        list.add(LevelCourses.builder()
                .id(86)
                .name("Clearing floats")
                .build());
        list.add(LevelCourses.builder()
                .id(87)
                .name("Problem parents floated elements")
                .build());
        list.add(LevelCourses.builder()
                .id(88)
                .name("Solution parents floated elements")
                .build());
        list.add(LevelCourses.builder()
                .id(89)
                .name("Create multi column layout")
                .build());
        list.add(LevelCourses.builder()
                .id(90)
                .name("Screen sizes")
                .build());
        list.add(LevelCourses.builder()
                .id(91)
                .name("Page size")
                .build());
        list.add(LevelCourses.builder()
                .id(92)
                .name("Fixed width layouts")
                .build());
        list.add(LevelCourses.builder()
                .id(93)
                .name("Liquid layouts")
                .build());
        list.add(LevelCourses.builder()
                .id(94)
                .name("Fixed width layout")
                .build());
        list.add(LevelCourses.builder()
                .id(95)
                .name("Liquid layout")
                .build());
        list.add(LevelCourses.builder()
                .id(96)
                .name("Layout grid")
                .build());
        list.add(LevelCourses.builder()
                .id(97)
                .name("Possible layouts")
                .build());
        list.add(LevelCourses.builder()
                .id(98)
                .name("Multiple stylesheets")
                .build());
        list.add(LevelCourses.builder()
                .id(99)
                .name("Multiple link stylesheets")
                .build());
        list.add(LevelCourses.builder()
                .id(100)
                .name("Images")
                .build());
        list.add(LevelCourses.builder()
                .id(101)
                .name("Controlling sizes")
                .build());
        list.add(LevelCourses.builder()
                .id(102)
                .name("Aligning images")
                .build());
        list.add(LevelCourses.builder()
                .id(103)
                .name("Centering images")
                .build());
        list.add(LevelCourses.builder()
                .id(104)
                .name("Background images")
                .build());
        list.add(LevelCourses.builder()
                .id(105)
                .name("Repeating images")
                .build());
        list.add(LevelCourses.builder()
                .id(106)
                .name("Background position")
                .build());
        list.add(LevelCourses.builder()
                .id(107)
                .name("Shorthand")
                .build());
        list.add(LevelCourses.builder()
                .id(108)
                .name("Image rollovers sprites")
                .build());
        list.add(LevelCourses.builder()
                .id(109)
                .name("CSS3 gradients")
                .build());
        list.add(LevelCourses.builder()
                .id(110)
                .name("HTML5 layout")
                .build());
        list.add(LevelCourses.builder()
                .id(111)
                .name("Traditional layout")
                .build());
        list.add(LevelCourses.builder()
                .id(112)
                .name("New HTML layouts")
                .build());
        list.add(LevelCourses.builder()
                .id(113)
                .name("Header footer")
                .build());
        list.add(LevelCourses.builder()
                .id(114)
                .name("Navigation")
                .build());
        list.add(LevelCourses.builder()
                .id(115)
                .name("Articles")
                .build());
        list.add(LevelCourses.builder()
                .id(116)
                .name("Asides")
                .build());
        list.add(LevelCourses.builder()
                .id(117)
                .name("Section")
                .build());
        list.add(LevelCourses.builder()
                .id(118)
                .name("Heading group")
                .build());
        list.add(LevelCourses.builder()
                .id(119)
                .name("Figures")
                .build());
        list.add(LevelCourses.builder()
                .id(120)
                .name("Sectioning element")
                .build());
        list.add(LevelCourses.builder()
                .id(121)
                .name("Linking around")
                .build());
        list.add(LevelCourses.builder()
                .id(122)
                .name("Help older browser")
                .build());
        courses.setExpert(list);
        payloadCourses.setCourse(courses);
        courses = new Courses();

        list = new ArrayList<>();

        list.add(LevelCourses.builder()
                .id(123)
                .name("Intro CSS")
                .build());
        list.add(LevelCourses.builder()
                .id(124)
                .name("Second page")
                .build());
        list.add(LevelCourses.builder()
                .id(125)
                .name("Third page")
                .build());
        courses.setBasic(list);
        list = new ArrayList<>();

        list.add(LevelCourses.builder()
                .id(126)
                .name("Color exam")
                .build());
        list.add(LevelCourses.builder()
                .id(127)
                .name("Text exam")
                .build());
        list.add(LevelCourses.builder()
                .id(128)
                .name("Boxes exam")
                .build());
        list.add(LevelCourses.builder()
                .id(129)
                .name("List table form exam")
                .build());
        courses.setMiddle(list);

        list = new ArrayList<>();
        list.add(LevelCourses.builder()
                .id(130)
                .name("Layouts exam")
                .build());
        list.add(LevelCourses.builder()
                .id(131)
                .name("Image exam")
                .build());
        list.add(LevelCourses.builder()
                .id(132)
                .name("HTML5 layout")
                .build());
        courses.setExpert(list);
        payloadCourses.setCourseExam(courses);

        return payloadCourses;
    }
}
