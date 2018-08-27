package reports;

import org.junit.*;

import static org.hamcrest.CoreMatchers.instanceOf;

public class reportBuilderTests {

    private ReportManager manager;

    @Before
    public  void setup(){
        manager = new ReportManager();
    }

    @Test
    public void shouldCreateReportBuilder(){

        CheckingAccount account= new CheckingAccount();
        IAmReportModelBuilder<CheckingAccount> builder = ReportModelBuilderFactory.create(account);
        Assert.assertNotNull("builder es nulo",builder);
        Assert.assertThat(builder, instanceOf(CheckingAccountReportModelBuilder.class));

    }
    @Test
    public void shouldReturnProFutureAccountReportModel(){
        IAmReportModelBuilder<ProFutureAccount> builder = ReportModelBuilderFactory.create(new ProFutureAccount());
        Assert.assertNotNull(builder);
        Assert.assertThat(builder, instanceOf(ProFutureAccountReportModelBuilder.class) );
    }



    @Test
    public void shouldReturnCheckingAccountReportModel(){
        ReportModel<CheckingAccount> report = manager.GenerateReport(new CheckingAccount());
        Assert.assertNotNull(report);
        Assert.assertThat(report.getDetail(), instanceOf(CheckingAccount.class) );

    }

    @Test
    public void shouldReturnModel (){
        Object model = manager.GenerateReport(new ProFutureAccount());
        Assert.assertNotNull(model);
        Assert.assertThat(model, instanceOf(ReportModel.class) );
        Assert.assertThat(((ReportModel<ProFutureAccount>)model).getDetail(), instanceOf(ProFutureAccount.class) );

    }

}
