package com.github.wnuq.dsbs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CourseTest {

    @Test
    void check_path_separator() {
        Course course = new Course();

        course.setId(1);
        course.setUrlToCover("/mma-try-harder.png");

        assertThat(course.getUrlToCover()).isEqualTo("1/mma-try-harder.png");
    }
}
