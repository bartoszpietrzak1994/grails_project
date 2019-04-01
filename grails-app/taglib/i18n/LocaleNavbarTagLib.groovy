package i18n

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import org.springframework.context.MessageSource

class LocaleNavbarTagLib implements GrailsConfigurationAware {

    static namespace = 'navBar'

    static defaultEncodeAs = [taglib: 'none']

    MessageSource messageSource

    List<String> languages

    Map<String, String> flagsUris = new HashMap<>()

    LocaleNavbarTagLib()
    {
        flagsUris.put("en", "<img class=\"i18n\" src=\"https://upload.wikimedia.org/wikipedia/en/thumb/a/ae/Flag_of_the_United_Kingdom.svg/510px-Flag_of_the_United_Kingdom.svg.png\">")
        flagsUris.put("fr", "<img class=\"i18n\" src=\"https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/500px-Flag_of_France.svg.png\">")
        flagsUris.put("de", "<img class=\"i18n\" src=\"https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/510px-Flag_of_Germany.svg.png\">")
    }

    @Override
    void setConfiguration(Config co) {
        languages = co.getProperty('ticket_app.languages', List)
    }

    def localeDropdownListItems = { args ->
        String uri = args.uri

        for ( String lang : languages ) {
            out << "<a href='${uri}?lang=${lang}'>${flagsUris.get(lang)}</a>"
        }

    }

}
