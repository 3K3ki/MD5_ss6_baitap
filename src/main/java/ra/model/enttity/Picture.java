package ra.model.enttity;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mark;
    private String author;
    private String feedback;

    public Picture() {
    }

    public Picture(int mark, String author, String feedback) {
        this.mark = mark;
        this.author = author;
        this.feedback = feedback;
    }

    public Picture(Long id, int mark, String author, String feedback) {
        this.id = id;
        this.mark = mark;
        this.author = author;
        this.feedback = feedback;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
