package example

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest(transactional = false)
class ProductManagerSpec extends Specification {

    @Inject
    @Shared
    ProductManager productManager

    @Inject
    @Shared
    ProductRepository productRepository

    @Inject
    @Shared
    ManufacturerRepository manufacturerRepository

    void setupSpec() {
        productRepository.deleteAll()
        manufacturerRepository.deleteAll()
    }

    void "test product manager"() {
        given:
            Manufacturer apple = manufacturerRepository.save("Apple")

        when:
            productManager.save("VR", apple)

        then:
            def vr = productManager.find("VR")
            vr.name == "VR"
    }

    void "test product manager using repo"() {
        given:
        Manufacturer intel = manufacturerRepository.save("Intel")

        when:
        productManager.save("Processor", intel)

        then:
        def product = productManager.findUsingRepo("Processor")
        product.name == "Processor"

        when:
        product = productManager.findUsingRepo("NonExistingProduct")

        then:
        !product
    }

}
