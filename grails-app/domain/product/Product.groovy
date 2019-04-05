package product

class Product
{
    String name
    double price
    Date date

    Product(String name, String price, String date) {
        this.name = name
        this.price = Double.valueOf(price)
        this.date = Date.parse("yyyy-MM-dd", date)
    }

    static constraints = {
        name unique: true
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
