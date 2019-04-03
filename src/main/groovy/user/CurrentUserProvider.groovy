package user

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

class CurrentUserProvider
{
    String getCurrentlyLoggedUsersEmail()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication()
        UserDetails principal = (UserDetails) authentication.getPrincipal()

        return principal.getUsername()
    }
}
