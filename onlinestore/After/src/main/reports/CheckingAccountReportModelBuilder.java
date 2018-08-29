package reports;

public class CheckingAccountReportModelBuilder extends IAmReportModelBuilder<CheckingAccount> {

    protected IAmReportModelBuilder createHeader(CheckingAccount model) {
        return this;
    }

    protected IAmReportModelBuilder createBody(CheckingAccount model) {
        return this;
    }

    protected IAmReportModelBuilder createFooter(CheckingAccount model) {
        return this;
    }
}
