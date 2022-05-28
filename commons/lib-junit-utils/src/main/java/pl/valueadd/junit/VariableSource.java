package pl.valueadd.junit;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(pl.valueadd.junit.VariableArgumentsProvider.class)
public @interface VariableSource {
    String value();
}