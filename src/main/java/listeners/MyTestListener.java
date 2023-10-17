package listeners;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        String strDate = dateFormat.format(date);
        String filePath = "screenshots/screenshot-" + strDate + ".jpg";
        ITestContext context =  result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        try {
            Helper.takeScreenshot(driver, filePath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
