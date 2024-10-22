package com.sirwani.book.book;

import com.sirwani.book.common.BaseEntity;
import com.sirwani.book.feedback.FeedBack;
import com.sirwani.book.history.BookTransactionHistory;
import com.sirwani.book.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {

    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String bookCover;
    private boolean archived;
    private boolean shareable;

    /*
    Many Books to One owner(user)
     */
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "book")
    private List<FeedBack> feedBacks;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;

    @Transient
    public double getRatings() {
        if(this.feedBacks == null || this.feedBacks.isEmpty()) {
            return 0.0;
        }

        var ratings = this.feedBacks.stream()
                .mapToDouble(FeedBack::getNote)
                .average()
                .orElse(0.0);

        return ratings;
    }
}

    /*
    A book can have only one owner,
    A owner can have many books

    Rules to Determine the Owning and Inverse Sides:
    The side with the foreign key column in the database is the owning side.
    The side that uses mappedBy is the inverse side.

    In this case of User and Book:

    Book is the owning side because it has the owner field (the foreign key), which points to User.
    User is the inverse side because it is mapped by the owner field in the Book entity.

    Key takeaway: Use mappedBy in the class where the foreign key is not stored (inverse side)


    4. Which Table Will the Relationship Be Stored In?
    The relationship will be stored in the table where the foreign key is located. In this case:

    The foreign key (owner) will be stored in the Book table.
    Each Book will have a column that refers to the id of a User.
    Breakdown:
    Book has the owner field, which is a foreign key pointing to the User entity.
    Therefore, the relationship is stored in the Book table in the form of a foreign key.
    */
