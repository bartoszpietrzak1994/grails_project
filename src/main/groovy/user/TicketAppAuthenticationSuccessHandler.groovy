package user

import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.web.DefaultRedirectStrategy
import org.springframework.security.web.RedirectStrategy
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TicketAppAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
    SpringSecurityService springSecurityService
    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy()

    @Override
    void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws ServletException, IOException {
        def targetUrl = this.determineTargetUrl(request, response)
        redirectStrategy.sendRedirect(request, response, targetUrl)
    }

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response)
    {
        def returnUrl = request.getSession().getAttribute('returnUrl')

        boolean isUser = false
        boolean isAdmin = false

        Collection<? extends GrantedAuthority> authorities = springSecurityService.getAuthentication().getAuthorities()

        for (GrantedAuthority grantedAuthority : authorities)
        {
            if (grantedAuthority.getAuthority() == "ROLE_USER")
            {
                isUser = true
                break
            }
            else if (grantedAuthority.getAuthority() == "ROLE_ADMIN")
            {
                isAdmin = true
                break
            }
        }

        if (isUser)
        {
            returnUrl = "/shop/index"
        }
        else if (isAdmin)
        {
            returnUrl = "/admin/index"
        }

        request.getSession().removeAttribute('returnUrl')

        return returnUrl
    }

    void setSpringSecurityService(SpringSecurityService springSecurityService)
    {
        this.springSecurityService = springSecurityService
    }
}
