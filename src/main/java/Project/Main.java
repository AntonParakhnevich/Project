package Project;

import Project.Entity.Budget;
import Project.Entity.CategoryCost;
import Project.Entity.CategoryIncome;
import Project.Entity.Expenses;
import Project.Entity.Family;
import Project.Entity.Income;
import Project.Entity.Month;
import Project.Entity.Year;
import Project.Service.CategoryCostService;
import Project.Service.YearService;
import Project.Util.SessionUtil;
import org.hibernate.Session;

/**
 * Created by .
 */
public class Main {

    public static void main(String[] args) {
        Family family = Family.builder().login("para").password("1234").build();
        Budget budget = new Budget();
        Year year = Year.builder().year(2020).build();
        Year year1 = Year.builder().year(2021).build();
        Month april = Month.builder().name("april").build();
        Month may = Month.builder().name("may").build();
        CategoryCost komun = CategoryCost.builder().name("komun").price(100).binding(5).build();
        CategoryCost razvle = CategoryCost.builder().name("razvle").price(500).binding(3).build();
        CategoryIncome zp = CategoryIncome.builder().name("zp").value(1000).build();

        CategoryCost komunMay = CategoryCost.builder().name("komun").price(50).binding(5).build();
        CategoryCost razvleMay = CategoryCost.builder().name("razvle").price(400).binding(3).build();

        Expenses expensesApril = Expenses.builder().build();
        Income incomeApril = Income.builder().build();

        Expenses expensesMay = Expenses.builder().build();
        Income incomeMay = Income.builder().build();

        expensesApril.addCategory(komun);
        expensesApril.addCategory(razvle);

        expensesMay.addCategory(komunMay);
        expensesMay.addCategory(razvleMay);

        incomeApril.addCategory(zp);

        incomeMay.addCategory(zp);

        april.setExpenses(expensesApril);
        april.setIncome(incomeApril);
        april.setYear(year);

        may.setExpenses(expensesMay);
        may.setIncome(incomeMay);
        may.setYear(year);

        year.addMonth(april);
        year.addMonth(may);
        budget.addYear(year);
//        budget.addYear(year1);

        family.setBudget(budget);
        budget.setFamily(family);


//        Budget build = Budget.builder().build();
//        Year build1 = Year.builder().year(12).build();
//
//

//        Session session = SessionUtil.getSession();
//        session.getTransaction().begin();
//        Family family1 = session.get(Family.class, 1L);
//        family1.getBudget().addYear(year1);
//        session.update(family1);
//        session.getTransaction().commit();
//        session.close();
//
//        System.out.println(family1);
//
//        Session session1 = SessionUtil.getSession();
//        session1.getTransaction().begin();
//        Budget budget1 = session1.get(Budget.class, build.getId());
//        budget1.addYear(build1);
//        session1.update(budget1);
//        session1.getTransaction().commit();
//        session1.close();

//        YearService yearService = new YearService();
//        System.out.println(yearService.getAllYears("para"));

//        Session session = SessionUtil.getSession();
//        session.getTransaction().begin();
//        session.save(family);
//        session.getTransaction().commit();
//        SessionUtil.close();


//        ImplDaoFamily implDaoFamily = new ImplDaoFamily();
//        try {
//            Family family1 = implDaoFamily.get(1L);
//            System.out.println(family1.getName());
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

//        ImplIncomesDao implIncomesDao = new ImplIncomesDao();
//        try {
//            BigDecimal april1 = implIncomesDao.sumIncomes("april");
//            System.out.println(april1);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

//        ImplDaoYear implDaoYear = new ImplDaoYear();
//        List<Integer> parakhnevich = implDaoYear.getAllYear("para");
//        System.out.println(parakhnevich);
//        List<String> allMonth = implDaoYear.getAllMonth(2020);
//        System.out.println(allMonth);

//        ImplCategoryIncomeDao implCategoryIncomeDao = new ImplCategoryIncomeDao();
//        List<CategoryIncome> april1 = implCategoryIncomeDao.getAll("april");
//        CategoryIncome categoryIncome = april1.get(0);
//        System.out.println(categoryIncome);

//        YearService yearService = new YearService();
//        List<Month> allMonth = yearService.getAllMonth(2020);
//        System.out.println(allMonth);
//        ExpensesService expensesService = new ExpensesService();
//        expensesService.addCategoryCost(CategoryCost.builder().name("kino").price(150).binding(2).build(),1L);
//
//        CategoryCostService categoryCostService = new CategoryCostService();
//        categoryCostService.delete(3L);
    }
}
