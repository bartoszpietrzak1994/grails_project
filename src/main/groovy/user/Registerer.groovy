package user


import org.springframework.transaction.annotation.Transactional

class Registerer
{
    @Transactional
    User register(String email, String password, String roleName, boolean isEnabled)
    {
        def user = new User(
                username: email,
                email: email,
                password: password,
                accountExpired: false,
                accountLocked: false,
                passwordExpired: false,
                enabled: isEnabled
        ).save(flush: true, failOnError: true)

        def userUserRole = new UserUserRole(
                user: User.findByEmail(email),
                userRole: UserRole.findByAuthority(roleName)
        ).save(flush: true, failOnError: true)

        return user
    }
}
