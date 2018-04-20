package org.grails

import grails.persistence.Entity
import grails.validation.Validateable
import spock.lang.Specification

class ShipperCommandSpec extends Specification {

    void "passes validation"() {
        when:
        boolean isValid = new ShipperCommand().validate()

        then:
        isValid
    }

}

@Entity
class Shipper {
    String trackingUrl

    static constraints = {
        trackingUrl nullable: true, url: true
    }
}

class ShipperCommand implements Validateable {
    String trackingUrl

    static constraints = {
        importFrom(Shipper)
    }
}