import geb.spock.GebReportingSpec
/**
 * @author Paul Fairless
 *
 */

class LesscssBundleSpec extends GebReportingSpec {
    def setupSpec() {
//        browser.getDriver().setJavascriptEnabled(true)
    }
    def "check lesscss rules rendered"(){
        when:
            go('')
        then:
        $('h1').text() == 'Less Test'
        $('h1').jquery.css('color') == 'rgb(34, 34, 251)'
        $('h2').jquery.css('color') == 'rgb(132, 34, 16)'
        $('h3').jquery.css('color') == 'rgb(34, 251, 34)'
    }

    def "ensure that less files are bundled"() {
    when:
        go('')
    then:
        $('link').size() == 1
        $('link').@href =~ /core/
    }
}
