package by.loiko.filtersbackend.model;

import by.loiko.filtersbackend.StringConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "FILTERS")
public class Filter {
    @Id
    @GeneratedValue(generator = StringConstants.ID_GENERATOR)
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "CRITERIES", joinColumns = @JoinColumn(name = "FILTER_ID"))
    @org.hibernate.annotations.CollectionId(
            column = @Column(name = "ID"),
            type = @org.hibernate.annotations.Type(type = "long"),
            generator = StringConstants.ID_GENERATOR
    )
    private Collection<Criteria> criteries = new ArrayList<>();

    @Column(name = "SELECTION", nullable = false)
    private Byte selection;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Criteria> getCriteries() {
        return criteries;
    }

    public Byte getSelection() {
        return selection;
    }

    public void setSelection(Byte selection) {
        this.selection = selection;
    }
}
