package data_provider;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "non-existing-user")
    public static Object [] [] dataProviderMethod () {

        return new Object[][] { { "non-existing-user@gmal.com", "password123" }};
    }

    @DataProvider(name = "invalid-password-admin-user")
    public static Object [] [] dataPInvalidPasswordAdminMethod () {
                                // {{String email, String password}}
        return new Object[][] { { "admin@admin.com", "password123" }};
    }

    @DataProvider(name = "valid-user")
    public static Object [] [] dataPValidUserMethod () {
                                // {{String email, String password}}
        return new Object[][] { { "admin@admin.com", "12345" }, { "user@user.com", "12345" }};
    }

}
