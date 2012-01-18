grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo "http://www.asual.com/maven/content/groups/public"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        runtime 'rhino:js:1.7R2'
        runtime 'com.asual.lesscss:lesscss-engine:1.1.4'

        test("org.codehaus.geb:geb-spock:0.6.2") {
            export = false
        }
        test ('org.gmock:gmock:0.8.2') {
            export = false
        }

        test("org.seleniumhq.selenium:selenium-firefox-driver:2.16.1") {
            export = false
        }

        provided("org.codehaus.groovy.modules.http-builder:http-builder:0.5.2"){
            export = false
            excludes 'nekohtml', "httpclient", "httpcore","xml-apis","groovy"
        }
        provided('net.sourceforge.nekohtml:nekohtml:1.9.15') {
            export = false
            excludes "xml-apis"
        }
    }

    plugins {
        build ":tomcat:${grailsVersion}"
        compile(":resources:1.1.6") { export = false }
        build(":release:1.0.1") {
            excludes 'http-builder', 'nekohtml', 'svn'
            export = false
        }

        test ":geb:0.6.2", ":spock:0.6-SNAPSHOT"
        build(":svn:1.0.2") { export = false }
    }
}
