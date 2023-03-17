package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.*;

public class CarbCalculatorSteps {
    WebDriver driver = null;
    String calculator_url = "https://www.calculator.net/carbohydrate-calculator.html";

    @Given("browser is open")
    public void browser_is_open() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Given("user has navigated to carbohydrate calculator website")
    public void user_has_navigated_to_https_calculator_net_carbohydrate_calculator() {
        driver.navigate().to(calculator_url);
    }

    @When("user enters {int} in the Age field")
    public void user_enters_in_the_age_field(Integer int1) {
        WebElement ageField = driver.findElement(By.id("cage"));
        ageField.clear();
        ageField.sendKeys(int1.toString());

        assertEquals(ageField.getAttribute("value"), int1.toString());
    }

    @When("user selects Male in the Gender options")
    public void user_selects_male_in_the_gender_options() {
        WebElement maleGenderField = driver.findElement(By.xpath("//*[@id=\"calinputtable\"]/tbody/tr[2]/td[2]/label[1]"));

        if (maleGenderField.getAttribute("checked") == null) {
            maleGenderField.click();
        }

        WebElement maleGenderRadio = driver.findElement(By.id("csex1"));

        assertNotEquals(maleGenderRadio.getAttribute("checked"), null);
    }

    @When("user enters {int} in Height field's feet text box")
    public void user_enters_in_height_field_s_feet_text_box(Integer int1) {
        WebElement heightFeetField = driver.findElement(By.id("cheightfeet"));
        heightFeetField.clear();
        heightFeetField.sendKeys(int1.toString());

        assertEquals(heightFeetField.getAttribute("value"), int1.toString());
    }

    @When("user enters {int} in Height field's inches text box")
    public void user_enters_in_height_field_s_inches_text_box(Integer int1) {
        WebElement heightInchField = driver.findElement(By.id("cheightinch"));
        heightInchField.clear();
        heightInchField.sendKeys(int1.toString());

        assertEquals(heightInchField.getAttribute("value"), int1.toString());
    }

    @When("user enters {int} in Weight field")
    public void user_enters_in_weight_field(Integer int1) {
        WebElement weightField = driver.findElement(By.id("cpound"));
        weightField.clear();
        weightField.sendKeys(int1.toString());

        assertEquals(weightField.getAttribute("value"), int1.toString());
    }

    @When("user selects {string} as activity level")
    public void user_selects_light_as_activity_level(String optionText) {
        Select activitySelectField = new Select(driver.findElement(By.id("cactivity")));

        activitySelectField.selectByVisibleText(optionText);

        assertEquals(activitySelectField.getFirstSelectedOption().getAttribute("innerText"), optionText);
    }

    @When("user clicks on Calculate button")
    public void user_clicks_on_calculate_button() {
        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[5]/table[4]/tbody/tr[3]/td[2]/input[2]"));

        calculateButton.click();
    }

    @When("user opens the settings block")
    public void user_opens_the_settings_block() {
        WebElement settingsButton = driver.findElement(By.xpath("//*[@id=\"ccsettingtitle\"]/b/a"));

        settingsButton.click();
    }

    @When("user selects Mifflin St Jeor as the BMR estimation formula")
    public void user_selects_mifflin_st_jeor_formula() {
        WebElement mifflinStJeorFormulaRadio = driver.findElement(By.xpath("//*[@id=\"ccsettingcontent\"]/div[2]/div[2]/label"));

        mifflinStJeorFormulaRadio.click();
    }

    @Then("user is shown results for their input")
    public void user_is_shown_results_for_their_input() {
        WebElement resultTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));

        assertEquals(resultTitle.getText(), "Result");
    }

    @Then("the daily calorie allowance for weight maintenance is {string}")
    public void weight_maintenance_allowance_is_valid(String result_value) {
        WebElement weightMaintenanceCalorieAllowanceElement = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/td[2]"));

        assertEquals(weightMaintenanceCalorieAllowanceElement.getText(), result_value);
    }

    @Then("the daily calorie allowance for losing 1 pound per week is {string}")
    public void weight_loss_1_pound_is_valid(String result_value) {
        WebElement weightLossCalorieAllowanceElement = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[3]/td[2]"));

        assertEquals(weightLossCalorieAllowanceElement.getText(), result_value);
    }

    @Then("the daily calorie allowance for losing 2 pounds per week is {string}")
    public void weight_loss_2_pounds_is_valid(String result_value) {
        WebElement weightLossCalorieAllowanceElement = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[4]/td[2]"));

        assertEquals(weightLossCalorieAllowanceElement.getText(), result_value);
    }

    @Then("the daily calorie allowance for gaining 1 pound per week is {string}")
    public void weight_gain_1_pound_is_valid(String result_value) {
        WebElement weightGainCalorieAllowanceElement = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[5]/td[2]"));

        assertEquals(weightGainCalorieAllowanceElement.getText(), result_value);
    }

    @Then("the daily calorie allowance for gaining 2 pounds per week is {string}")
    public void weight_gain_2_pounds_is_valid(String result_value) {
        WebElement weightGainCalorieAllowanceElement = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[6]/td[2]"));

        assertEquals(weightGainCalorieAllowanceElement.getText(), result_value);
    }

    @Then("successfully close the browser")
    public void close_browser() {
        driver.close();
    }
}
