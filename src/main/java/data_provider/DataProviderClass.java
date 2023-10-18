package data_provider;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "non-existing-user")
    public static Object [] [] dataProviderMethod () {

        return new Object[][] { { "non-existing-user@gmal.com", "password123" }};
    }

}