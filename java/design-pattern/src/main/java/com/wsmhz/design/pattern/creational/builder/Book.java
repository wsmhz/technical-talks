package com.wsmhz.design.pattern.creational.builder;

/**
 * Created By tangbj On 2019/7/9
 * Description: 建造者模式
 */
public class Book {

    private String name;

    private String img;

    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Book(BookBuilder bookBuilder) {
        this.name = bookBuilder.name;
        this.img = bookBuilder.img;
        this.author = bookBuilder.author;
    }

    public static class BookBuilder{
        private String name;

        private String img;

        private String author;

        public BookBuilder builderName(String name){
            this.name = name;
            return this;
        }

        public BookBuilder builderImg(String img){
            this.img = img;
            return this;
        }

        public BookBuilder builderAuthor(String author){
            this.author = author;
            return this;
        }

        public Book build(){
            return new Book(this);
        }

    }
}
