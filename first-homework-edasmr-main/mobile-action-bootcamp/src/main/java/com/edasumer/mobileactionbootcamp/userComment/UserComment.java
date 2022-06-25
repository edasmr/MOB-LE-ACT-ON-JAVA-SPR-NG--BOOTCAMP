package com.edasumer.mobileactionbootcamp.userComment;

import com.edasumer.mobileactionbootcamp.User.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "UserComment")
public class UserComment {
    @Id
    private long id;

    @Column(name = "Comment", length = 500)
    private String comment;

    @Temporal(TemporalType.DATE)
    private Date commentDate;

    @Column(name = "ProductID")
    private long productId;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "FK_ID")
    private User user;
}
