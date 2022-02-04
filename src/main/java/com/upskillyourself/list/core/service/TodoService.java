package com.upskillyourself.list.core.service;

import com.upskillyourself.list.core.validation.ValidatorComponent;

import java.util.ArrayList;
import java.util.List;

public interface TodoService<I, O> {

    default List<ValidatorComponent> getValidator() {
        return new ArrayList<>();
    }

    default List<ValidatorComponent> getValidator(I input) {
        return new ArrayList<>();
    }

    O process(I input);
}
