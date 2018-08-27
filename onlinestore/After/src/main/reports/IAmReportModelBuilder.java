package reports;

public abstract class IAmReportModelBuilder<T> {
    protected ReportModel<T> report;
    public ReportModel<T> create(T model) {
        report = new ReportModel<T>(model);

         this.Header(model)
              .Body(model)
              .Footer(model);
        return report;

    }
    protected abstract IAmReportModelBuilder Header( T model);
    protected abstract IAmReportModelBuilder Body(T model);
    protected abstract IAmReportModelBuilder Footer(T model);
}

