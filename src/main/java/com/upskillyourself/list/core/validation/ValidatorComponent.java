/*
 * *
 *  * *******************************************************************************
 *  * Copyright ©2022.
 *   Upskillyourself - All rights reserved.
 *  *
 *  * All information contained herein is, and remains the property of Upskillyourself.
 *  * Upskillyourself including, without limitation, all software and other elements thereof,
 *  * are owned or controlled exclusively by Upskillyourself and protected by copyright, patent
 *  * and other laws. Use without permission is prohibited.
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  *
 *  * For further information contact Upskillyourself at info@Upskillyourself.com.
 *  * *******************************************************************************
 *
 */

package com.upskillyourself.list.core.validation;

import com.upskillyourself.list.core.model.InputModel;
import com.upskillyourself.list.core.model.OutputModel;

public interface ValidatorComponent {

    void preProcess(InputModel inputModel);

    default void postProcess(InputModel model, OutputModel response) {
    }

}
