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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * Created by .
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "months")
public class Month implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "income_id")
    private Income income;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expenses_id")
    private Expenses expenses;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "year_id")
    private Year year;

//    @Column
//    private int accumulationInMonth ;

    public int calculationAccumulationInMonth() {
        return income.calculationTotalIncome() - expenses.calculationTotalExpenses();
    }

    @Override
    public String toString() {
        return "Month{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return Objects.equals(id, month.id) && Objects.equals(name, month.name) && Objects.equals(income, month.income) && Objects.equals(expenses, month.expenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, income, expenses);
    }
}
