package _02BookShop;

class Book {
    private String title;
    private String author;
    private double price;

    Book(String author, String title, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private void setAuthor(String author) {
        String[] names = author.split("\\s+");
        if (names.length == 2 && (names[1].charAt(0) + "").matches("\\d")) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    void setPrice(double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.title)
                .append(System.lineSeparator())
                .append("Author: ").append(this.author)
                .append(System.lineSeparator())
                .append("Price: ").append(this.price)
                .append(System.lineSeparator());
        return sb.toString();
    }
}
