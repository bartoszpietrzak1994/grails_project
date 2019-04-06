package product

class Product
{
    String name
    double price
    Date date

    static constraints = {
        name unique: true, blank: false
        date min: (new Date().minus(1)), nullable: false
        price min: 0d
    }

    static mapping = {
        id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator')
    }

    String getName() {
        return name
    }

    double getPrice() {
        return price
    }

    Date getDate() {
        return date
    }
}
