package io.github.syakuis;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-09-06
 */
@SpringBootTest
@Slf4j
class ApplicationTest {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private MessageSourceAccessor messageSourceAccessor;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    @DisplayName("스프링 빈 테스트")
    void spring_bean_test() {
        assertNotNull(applicationContext.getBean(MessageSource.class));
        assertNotNull(applicationContext.getBean(MessageSourceAccessor.class));
        assertNotNull(applicationContext.getBean(ObjectMapper.class));
    }

    @Test
    @DisplayName("메시지 테스트")
    void message_test() {
        assertNotNull(messageSource);
        assertNotNull(messageSourceAccessor);

        var actual = messageSourceAccessor.getMessage("author.name");
        var expected = "Seokkyun. Choi.";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("objectMapper 테스트")
    void object_mapper_test() throws Exception {
        assertNotNull(objectMapper);

        var data = "[1,2,3,4]";
        var actual = objectMapper.readValue(data, new TypeReference<List<Integer>>() {});
        var expected = List.of(1, 2, 3, 4);
        assertEquals(expected, actual);
    }
}