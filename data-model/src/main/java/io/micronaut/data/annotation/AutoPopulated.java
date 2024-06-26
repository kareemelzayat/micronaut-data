/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.data.annotation;

import io.micronaut.context.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Meta annotation to identity annotations that are auto-populated by the Micronaut Data.
 *
 * @see DateCreated
 * @see DateUpdated
 * @author graemerocher
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Documented
public @interface AutoPopulated {
    /**
     * The annotation name.
     */
    String NAME = AutoPopulated.class.getName();

    /**
     * @deprecated Replaced by {@link #UPDATABLE}
     */
    @Deprecated(since = "4.8", forRemoval = true)
    String UPDATEABLE = "updateable";

    String UPDATABLE = "updatable";

    /**
     * @return Whether the property can be updated following an insert
     * @deprecated Replaced by {@link #updatable()}
     */
    @Deprecated(since = "4.8", forRemoval = true)
    boolean updateable() default true;

    /**
     * @return Whether the property can be updated following an insert
     */
    @AliasFor(member = UPDATEABLE)
    boolean updatable() default true;
}
