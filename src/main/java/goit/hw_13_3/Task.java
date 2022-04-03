package goit.hw_13_3;

import lombok.Data;

@Data
public class Task {
    private int id;
    private int userId;
    private String title;
    private boolean completed;
}
