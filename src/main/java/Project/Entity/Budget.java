package Project.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by .
 */

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "budget")
public class Budget implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "budget_year",
            joinColumns = @JoinColumn(name = "B_ID"),
            inverseJoinColumns = @JoinColumn(name = "Y_ID"))
    @Builder.Default
    private Set<Year> years = new HashSet<>();

//    private Family family;
//    private String year;
//    private String month;
//    private BigDecimal total;

    @OneToOne(cascade = CascadeType.ALL)
    private Family family;

    public void addYear(Year year) {
        years.add(year);
    }

    @Column
    public int totalAccumulation;

    public int calculationTotalAccumulation() {
        int total = 0;
        for (Year y : years) {
            Set<Month> months = y.getMonths();
            for (Month m : months) {
                total += m.calculationAccumulationInMonth();
                System.out.println(total);
            }
        }
        return total;
    }

    public void updateYear(Year year) {
        Iterator<Year> iterator = years.iterator();

        if (iterator.hasNext()) {
            Year next = iterator.next();
            if (next.getId().equals(year.getId())) {
                years.remove(next);
                years.add(year);
            }
        }
    }


}
