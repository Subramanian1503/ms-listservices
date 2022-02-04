package com.upskillyourself.list.core.validation;

import com.upskillyourself.list.core.model.InputModel;
import com.upskillyourself.list.core.model.OutputModel;
import com.upskillyourself.list.core.service.TodoService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
public class ValidatorAspect {

    public static final String DEFAULT_ASPECT_AROUND_PACKAGE = "execution(* com.upskillyourself.list.core.service.TodoService+.process(..)))";

    @Around(DEFAULT_ASPECT_AROUND_PACKAGE)
    public Object validate(ProceedingJoinPoint jp) throws Throwable {
        TodoService todoService = (TodoService) jp.getThis();
        List validatorComponentList = todoService.getValidator();
        InputModel inputModel = (InputModel) jp.getArgs()[0];
        performPreProcess(validatorComponentList, inputModel);
        Object response = jp.proceed();
        performPostProcess(validatorComponentList, inputModel, (OutputModel) response);
        return response;
    }

    private void performPostProcess(List<ValidatorComponent> validatorComponentList, InputModel inputModel, OutputModel response) {
        validatorComponentList
                .forEach(validator -> validator.postProcess(inputModel, response));
    }

    private void performPreProcess(List<ValidatorComponent> validatorComponentList, InputModel inputModel) {
        validatorComponentList
                .forEach(validator -> validator.preProcess(inputModel));
    }
}
