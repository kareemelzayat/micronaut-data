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
package io.micronaut.data.processor.mappers.jpa.jx.event;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.data.annotation.event.PostRemove;
import io.micronaut.inject.annotation.NamedAnnotationMapper;
import io.micronaut.inject.visitor.VisitorContext;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

/**
 * Maps JPA's {@code PostRemove} annotation to Micronaut's.
 *
 * @author Denis Stepanov
 * @since 2.3.0
 */
public class PostRemoveAnnotationMapper implements NamedAnnotationMapper {

    @NonNull
    @Override
    public String getName() {
        return "javax.persistence.PostRemove";
    }

    @Override
    public List<AnnotationValue<?>> map(AnnotationValue<Annotation> annotation, VisitorContext visitorContext) {
        return Collections.singletonList(
                AnnotationValue.builder(PostRemove.class)
                        .build()
        );
    }
}
