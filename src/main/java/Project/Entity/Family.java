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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by .
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "family")
public class Family implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String login;

    @Column
    private String password;

    @OneToOne(mappedBy = "family",cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_id")
    private Budget budget;

//    private List<Budget> budgets = new ArrayList<>()
//    private Set<IncomeCategory> incomeCategories = new HashSet<>();
//    private Set<OutcomeCategory> outcomeCategories = new HashSet<>();
//    private List<Income> incomes = new ArrayList<>(); ???
//    private List<Outcome> outcomes = new ArrayList<>(); ???

}
