package user

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.web.DefaultRedirectStrategy
import org.springframework.security.web.RedirectStrategy
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TicketAppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy()

    @Override
    void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {
        if (response.isCommitted())
        {
            return
        }

        String targetUrl = determineTargetUrl(authentication)
        redirectStrategy.sendRedirect(request, response, targetUrl)
    }

    String determineTargetUrl(Authentication authentication)
    {
        boolean isUser = false
        boolean isAdmin = false

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities()

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
            return "/shop/index"
        }
        else if (isAdmin)
        {
            return "/admin/index"
        }

        throw new IllegalStateException()
    }
}
