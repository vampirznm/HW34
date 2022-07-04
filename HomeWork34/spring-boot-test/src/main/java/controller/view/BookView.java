package controller.view;

import lombok.Data;

@Data
public class BookView {

    private Long id;
    private String bookName;
    private String authorName;
    private double cost;
}