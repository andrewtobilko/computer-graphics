package com.tobilko.graphics;

import com.tobilko.graphics.config.CurrentLab;
import com.tobilko.graphics.config.Lab;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import static org.springframework.util.ClassUtils.resolveClassName;

/**
 *
 * Created by Andrew Tobilko on 18/09/16.
 *
 */
public class Runner {

    public static void main(String[] args) throws ClassNotFoundException {
        performMyCurrentLab();
    }

    private static void performMyCurrentLab() throws ClassNotFoundException {
        String packageForScanning = Runner.class.getPackage().getName();
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(packageForScanning);
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(CurrentLab.class));

        scanner.findCandidateComponents(packageForScanning).forEach(d ->
                new Thread(() -> ((Lab)context.getBean(resolveClassName(d.getBeanClassName(), null))).perform()).start());
    }

    // too scruffy, but the lambda is clean enough ;)
    private static Class<?> forName(String className) throws IllegalArgumentException {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

}
