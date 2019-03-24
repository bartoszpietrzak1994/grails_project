package user

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class UserUserRole implements Serializable {

	private static final long serialVersionUID = 1

	User user
	UserRole userRole

	@Override
	boolean equals(other) {
		if (other instanceof UserUserRole) {
			other.userId == user?.id && other.userRoleId == userRole?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (user) {
            hashCode = HashCodeHelper.updateHash(hashCode, user.id)
		}
		if (userRole) {
		    hashCode = HashCodeHelper.updateHash(hashCode, userRole.id)
		}
		hashCode
	}

	static UserUserRole get(long userId, long userRoleId) {
		criteriaFor(userId, userRoleId).get()
	}

	static boolean exists(long userId, long userRoleId) {
		criteriaFor(userId, userRoleId).count()
	}

	private static DetachedCriteria criteriaFor(long userId, long userRoleId) {
		UserUserRole.where {
			user == User.load(userId) &&
			userRole == UserRole.load(userRoleId)
		}
	}

	static UserUserRole create(User user, UserRole userRole, boolean flush = false) {
		def instance = new UserUserRole(user: user, userRole: userRole)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(User u, UserRole r) {
		if (u != null && r != null) {
			UserUserRole.where { user == u && userRole == r }.deleteAll()
		}
	}

	static int removeAll(User u) {
		u == null ? 0 : UserUserRole.where { user == u }.deleteAll() as int
	}

	static int removeAll(UserRole r) {
		r == null ? 0 : UserUserRole.where { userRole == r }.deleteAll() as int
	}

	static constraints = {
	    user nullable: false
		userRole nullable: false, validator: { UserRole r, UserUserRole ur ->
			if (ur.user?.id) {
				if (UserUserRole.exists(ur.user.id, r.id)) {
				    return ['userRole.exists']
				}
			}
		}
	}

	static mapping = {
		id composite: ['user', 'userRole']
		version false
	}
}
