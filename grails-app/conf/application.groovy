// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'user.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'user.UserUserRole'
grails.plugin.springsecurity.authority.className = 'user.UserRole'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               		 access: ['permitAll']],
	[pattern: '/login/**',          	 access: ['permitAll']],
	[pattern: '/shop/register',  		 access: ['permitAll']],
	[pattern: '/admin/register', 		 access: ['permitAll']],
	[pattern: '/admin/**', 				 access: ['permitAll']],
	[pattern: '/shop/**', 				 access: ['permitAll']],
	[pattern: '/registrationConfirm/**', access: ['permitAll']],
	[pattern: '/error',          		 access: ['permitAll']],
	[pattern: '/assets/**',      		 access: ['permitAll']],
	[pattern: '/**/js/**',       		 access: ['permitAll']],
	[pattern: '/**/css/**',      		 access: ['permitAll']],
	[pattern: '/**/images/**',   		 access: ['permitAll']],
	[pattern: '/**/favicon.ico', 		 access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/shop/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'],
	[pattern: '/admin/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'],
	[pattern: '/registrationConfirm/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'],
	[pattern: '/login/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
]

grails.plugin.springsecurity.rejectIfNoRule = false
grails.plugin.springsecurity.fii.rejectPublicInvocations = false
grails.plugin.springsecurity.auth.loginFormUrl = "/login"
grails.plugin.springsecurity.useSecurityEventListener = true
grails.plugin.springsecurity.successHandler.defaultTargetUrl = "/"
grails.plugin.springsecurity.successHandler.alwaysUseDefault = false
grails.plugin.springsecurity.logout.afterLogoutUrl = "/"
grails.plugin.springsecurity.failureHandler.defaultFailureUrl = "/error"

google.recaptcha.key.site="6LeslJwUAAAAABEEPw7HUEYeZGAg0qnalQ-ksd-r"
google.recaptcha.key.secret="6LeslJwUAAAAABEEPw7HUEYeZGAg0qnalQ-ksd-r"
