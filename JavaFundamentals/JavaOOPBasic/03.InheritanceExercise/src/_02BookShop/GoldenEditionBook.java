package _02BookShop;

class GoldenEditionBook extends Book {
    GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    void setPrice(double price) {
        price = price + price * 0.3;
        super.setPrice(price);
    }
}
