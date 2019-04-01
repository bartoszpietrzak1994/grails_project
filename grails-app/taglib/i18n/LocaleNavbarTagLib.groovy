package i18n

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import org.springframework.context.MessageSource
import org.springframework.web.servlet.support.RequestContextUtils

class LocaleNavbarTagLib implements GrailsConfigurationAware {

    static namespace = 'navBar'

    static defaultEncodeAs = [taglib: 'none']

    MessageSource messageSource

    List<String> languages

    @Override
    void setConfiguration(Config co) {
        languages = co.getProperty('ticket_app.languages', List)
    }

    def localeDropdownListItems = { args ->
        String uri = args.uri

        for ( String lang : languages ) {
            String languageCode = "language.$lang"
            def locale = RequestContextUtils.getLocale(request)
            def msg = messageSource.getMessage(languageCode, [] as Object[], null, locale)
            out << "<li><a href='${uri}?lang=${lang}'>${msg}</a></li>"
        }

    }

}
