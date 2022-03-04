package by.loiko.filtersbackend.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Criteria {
    @Column(name = "TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private CriteriaType type;

    @Column(name = "CONDITION", nullable = false)
    @Enumerated(EnumType.STRING)
    private ComparingCondition condition;

    @Column(name = "VALUE", nullable = false)
    private String value;

    public CriteriaType getType() {
        return type;
    }

    public void setType(CriteriaType type) {
        this.type = type;
    }

    public ComparingCondition getCondition() {
        return condition;
    }

    public void setCondition(ComparingCondition condition) {
        this.condition = condition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
