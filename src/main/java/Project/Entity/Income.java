package Project.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by .
 */

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "incomes")
public class Income implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(name = "income_category_income",
            joinColumns = @JoinColumn(name = "In_ID"),
            inverseJoinColumns = @JoinColumn(name = "CI_ID"))
    @Builder.Default
    private Set<CategoryIncome> categoryIncomes = new HashSet<>();

    @Column
    private int totalIncome;

    public void addCategory(CategoryIncome income){
        categoryIncomes.add(income);
    }

    public int calculationTotalIncome() {
        int totalIncome = 0;
        for (CategoryIncome c : categoryIncomes) {
            totalIncome += c.getValue();
        }
        return totalIncome;
    }
}
