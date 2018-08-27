package reports;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;

public class ReportModelBuilderFactory {

    public static <T> IAmReportModelBuilder<T> create(T account){
        try {
            Class<? extends IAmReportModelBuilder<T>> clz = load(account);
            Constructor<? extends IAmReportModelBuilder<T>> ctor = clz.getConstructor();
            IAmReportModelBuilder<T> builder = ctor.newInstance();
            return builder;
        }
        catch(Exception e){
            return null;
        }

    }

    private static <T> Class<? extends IAmReportModelBuilder<T>> load(T type)
            throws ClassNotFoundException
    {
        Class<?> any = Class.forName(type.getClass().getName() + "ReportModelBuilder");
        Class<? extends IAmReportModelBuilder<T>> creator = (Class<? extends IAmReportModelBuilder<T>>) any;
        return creator;
    }
}
