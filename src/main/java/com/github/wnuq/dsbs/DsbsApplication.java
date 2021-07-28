package com.github.wnuq.dsbs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DsbsApplication {

    private final Logger logger = LoggerFactory.getLogger(DsbsApplication.class);

    private final CourseRepository courseRepository;

    public DsbsApplication(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(DsbsApplication.class, args);
	}

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List allCourses = courseRepository.findAll();
        logger.info("Number of courses: " + allCourses.size());

        Course course = new Course();
        course.setTitle("MMA for beginners");
        course.setDescription("Easy crush course");
        course.setUrlToCover("/mma-beginners.png");
        logger.info("Saving new course...");
        courseRepository.save(course);

        allCourses = courseRepository.findAll();
        logger.info("Number of courses: " + allCourses.size());
    }
}
