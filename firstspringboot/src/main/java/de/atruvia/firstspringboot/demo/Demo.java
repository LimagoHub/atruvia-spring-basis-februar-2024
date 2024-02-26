package de.atruvia.firstspringboot.demo;


import de.atruvia.firstspringboot.translator.Translator;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Lazy(value = false)

@RequiredArgsConstructor
public class Demo {

    @Value("${Demo.message}")
    private String message = "Hallo";


    @Qualifier("upper")
    private final Translator translator;


//    //@Autowired
//    public Demo( @Qualifier("upper") final Translator translator) {
//        this.translator = translator;
//        System.out.println(message);
//    }

    //    public Demo() {
//        System.out.println("Ctor Demo");
//        System.out.println(message);
//    }

    @PostConstruct
    public void init() {
        System.out.println("Postconstruct");
        System.out.println(translator.translate(message));
    }

    @PreDestroy
    public void dispose() {
        System.out.println("predestroy");
    }
}
