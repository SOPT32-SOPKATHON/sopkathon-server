package sopt.org.sopkathon.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "`kill`")
public class Kill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String image;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    @ColumnDefault("0")
    private Integer likeCount;

    @Column
    @ColumnDefault("0")
    private Integer dislikeCount;

    @Column
    @ColumnDefault("0")
    private Integer rankScore;

    private Kill(String image, String title, String content) {
        this.image = image;
        this.title = title;
        this.content = content;
        this.likeCount = 0;
        this.dislikeCount = 0;
        this.rankScore = 0;
    }

    public static Kill newInstance(String image, String title, String content) {
        return new Kill(image, title, content);
    }

    public void addLike() {
        this.likeCount += 1;
        this.rankScore += 1;
    }

    public void addDislike() {
        this.dislikeCount += 1;
        this.rankScore -= 1;
    }

}