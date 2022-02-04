package com.upskillyourself.list.core.validation;

import com.upskillyourself.list.core.model.InputModel;
import com.upskillyourself.list.core.model.OutputModel;

public interface ValidatorComponent {

    public void preProcess(InputModel inputModel);

    default void postProcess(InputModel model, OutputModel response) {
    }

}
