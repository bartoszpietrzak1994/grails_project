package user

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic
import order.Order

@GrailsCompileStatic
@EqualsAndHashCode(includes='email')
@ToString(includes='email', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String email
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static hasMany = [orders: Order]

    Set<UserRole> getAuthorities() {
        (UserUserRole.findAllByUser(this) as List<UserUserRole>)*.userRole as Set<UserRole>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        email nullable: false, blank: false, unique: true
    }

    static mapping = {
	    password column: '`password`'
    }
}
