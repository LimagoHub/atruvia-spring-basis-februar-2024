package de.atruvia.firstspringboot.translator;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("upper")
//@Profile("dev")
public class ToUpperTranslator implements Translator{
    @Override
    public String translate(final String messageToTranslate) {
        return messageToTranslate.toUpperCase();
    }
}
