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
package io.micronaut.data.jdbc.sqlserver

import groovy.transform.Memoized
import io.micronaut.context.ApplicationContext
import io.micronaut.data.tck.repositories.BookRepository
import io.micronaut.data.tck.repositories.PersonRepository
import io.micronaut.data.tck.tests.AbstractPageSpec
import spock.lang.AutoCleanup
import spock.lang.Shared

class SqlServerPaginationSpec extends AbstractPageSpec implements MSSQLTestPropertyProvider {

    @Shared @AutoCleanup ApplicationContext context

    @Memoized
    @Override
    PersonRepository getPersonRepository() {
        return context.getBean(MSSQLPersonRepository)
    }

    @Memoized
    @Override
    BookRepository getBookRepository() {
        return context.getBean(MSBookRepository)
    }

    @Override
    void init() {
        context = ApplicationContext.run(properties)
    }
}
