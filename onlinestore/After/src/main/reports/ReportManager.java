package reports;

public class ReportManager {
    public <T> ReportModel<T> GenerateReport(T account) {
        IAmReportModelBuilder<T> builder =  ReportModelBuilderFactory.create(account);
        return builder.create(account);
    }
}
