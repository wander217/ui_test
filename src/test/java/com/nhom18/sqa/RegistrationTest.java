package com.nhom18.sqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\TrinhThinh\\IdeaProjects\\" +
                "SQA\\ui-test\\src\\test\\driver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:3000/login");
        WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys("Teacher3");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("User_1234");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();
    }

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(10000);
        String title= driver.getTitle();
        Assertions.assertEquals("SQA-Đăng kí giảng dạy cho giảng viên",title);
        driver.close();
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(10000);
        List<WebElement> listItem = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElements(By.className("MuiListItem-root"));
        Assertions.assertEquals(listItem.size(),3);
        String content1 = listItem.get(0).findElement(By.className("MuiAccordionSummary-content")).getText();
        Assertions.assertEquals("Tên môn :Kiểm thử phần mềm",content1);
        String content2 = listItem.get(1).findElement(By.className("MuiAccordionSummary-content")).getText();
        Assertions.assertEquals("Tên môn :Lập trình C++",content2);
        String content3 = listItem.get(2).findElement(By.className("MuiAccordionSummary-content")).getText();
        Assertions.assertEquals("Tên môn :Lập trình Java",content3);
        driver.close();
    }

    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(10000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement expand = subject.findElement(By.className("MuiCollapse-entered"));
        Assertions.assertNotNull(expand);
        driver.close();
    }

    @Test
    public void test4() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        Assertions.assertFalse(viewButton.isEnabled());
        driver.close();
    }

    @Test
    public void test5() throws InterruptedException {
        Thread.sleep(5000);
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        searchBox.sendKeys("C");
        Thread.sleep(1000);
        WebElement searchButton = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/form/div/div/div/button"));
        searchButton.click();
        Thread.sleep(1000);
        List<WebElement> listItem = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElements(By.className("MuiListItem-root"));
        Assertions.assertEquals(listItem.size(),1);
        String content = listItem.get(0).findElement(By.className("MuiAccordionSummary-content")).getText();
        Assertions.assertTrue(content.contains("C"));
        driver.close();
    }

    @Test
    public void test6() throws InterruptedException {
        Thread.sleep(5000);
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        searchBox.sendKeys("W");
        Thread.sleep(1000);
        WebElement searchButton = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/form/div/div/div/button"));
        searchButton.click();
        Thread.sleep(1000);
        List<WebElement> listItem = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElements(By.className("MuiListItem-root"));
        Assertions.assertEquals(listItem.size(),1);
        String content1 = listItem.get(0).findElement(By.className("MuiTypography-root")).getText();
        Assertions.assertEquals("Không có dữ liệu cần tìm!",content1);
        driver.close();
    }

    @Test
    public void test7() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(2,row.size());
        driver.close();
    }

    @Test
    public void test8() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        WebElement searchBox = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/input"));
        searchBox.sendKeys("N7");
        WebElement searchButton = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/div/button"));
        searchButton.click();
        Thread.sleep(1000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(1,row.size());
        List<WebElement> cell = row.get(0).findElements(By.className("MuiTableCell-root"));
        Assertions.assertTrue(cell.get(0).getText().contains("N7"));
        driver.close();
    }

    @Test
    public void test9() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        WebElement searchBox = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/input"));
        searchBox.sendKeys("M7");
        WebElement searchButton = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/div/button"));
        searchButton.click();
        Thread.sleep(1000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(1,row.size());
        List<WebElement> cell = row.get(0).findElements(By.className("MuiTableCell-root"));
        Assertions.assertEquals("Không có dữ liệu",cell.get(0).getText());
        driver.close();
    }

    @Test
    public void test10() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        WebElement searchSelect = driver.findElement(By
                .xpath("//*[@id=\"search\"]"));
        Select select = new Select(searchSelect);
        select.selectByIndex(1);
        WebElement searchBox = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/input"));
        searchBox.sendKeys("Thứ b");
        WebElement searchButton = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/div/button"));
        searchButton.click();
        Thread.sleep(3000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(1,row.size());
        List<WebElement> cell = row.get(0).findElements(By.className("MuiTableCell-root"));
        Assertions.assertEquals("Thứ ba",cell.get(1).getText());
        driver.close();
    }

    @Test
    public void test11() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        WebElement searchSelect = driver.findElement(By
                .xpath("//*[@id=\"search\"]"));
        Select select = new Select(searchSelect);
        select.selectByIndex(1);
        WebElement searchBox = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/input"));
        searchBox.sendKeys("Thứ 8");
        WebElement searchButton = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/div/button"));
        searchButton.click();
        Thread.sleep(5000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(1,row.size());
        List<WebElement> cell = row.get(0).findElements(By.className("MuiTableCell-root"));
        Assertions.assertEquals("Không có dữ liệu",cell.get(0).getText());
        driver.close();
    }

    @Test
    public void test12() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        WebElement searchSelect = driver.findElement(By
                .xpath("//*[@id=\"search\"]"));
        Select select = new Select(searchSelect);
        select.selectByIndex(2);
        WebElement searchBox = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/input"));
        searchBox.sendKeys("Kíp 4");
        WebElement searchButton = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/div/button"));
        searchButton.click();
        Thread.sleep(3000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(2,row.size());
        for(WebElement r:row){
            List<WebElement> cell = r.findElements(By.className("MuiTableCell-root"));
            List<WebElement> shifts1 = cell.get(2).findElements(By.className("MuiTypography-root"));
            Assertions.assertTrue(()-> shifts1.get(0).getText().contains("Kíp 4")
                    ||shifts1.get(1).getText().contains("Kíp 4"));
        }
        driver.close();
    }

    @Test
    public void test13() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        WebElement searchSelect = driver.findElement(By
                .xpath("//*[@id=\"search\"]"));
        Select select = new Select(searchSelect);
        select.selectByIndex(2);
        WebElement searchBox = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/input"));
        searchBox.sendKeys("Kíp 10");
        WebElement searchButton = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/div/button"));
        searchButton.click();
        Thread.sleep(3000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(1,row.size());
        List<WebElement> cell = row.get(0).findElements(By.className("MuiTableCell-root"));
        Assertions.assertEquals("Không có dữ liệu",cell.get(0).getText());
        driver.close();
    }

    @Test
    public void test14() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(2,row.size());
        List<WebElement> cell1 = row.get(0).findElements(By.className("MuiTableCell-root"));
        List<WebElement> cell2 = row.get(1).findElements(By.className("MuiTableCell-root"));
        Assertions.assertTrue(cell1.get(0).getText().compareTo(cell2.get(0).getText())<=0);
        driver.close();
    }

    @Test
    public void test15() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        WebElement header = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/thead/tr/th[1]/span"));
        header.click();
        Thread.sleep(3000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(2,row.size());
        List<WebElement> cell1 = row.get(0).findElements(By.className("MuiTableCell-root"));
        List<WebElement> cell2 = row.get(1).findElements(By.className("MuiTableCell-root"));
        Assertions.assertTrue(cell1.get(0).getText().compareTo(cell2.get(0).getText())>=0);
        driver.close();
    }

    @Test
    public void test16() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        WebElement header = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/thead/tr/th[2]/span"));
        header.click();
        Thread.sleep(3000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(2,row.size());
        List<WebElement> cell1 = row.get(0).findElements(By.className("MuiTableCell-root"));
        List<WebElement> cell2 = row.get(1).findElements(By.className("MuiTableCell-root"));
        Assertions.assertTrue(cell1.get(1).getText().compareTo(cell2.get(1).getText())<=0);
        driver.close();
    }

    @Test
    public void test17() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        for(int i=0;i<2;i++){
            WebElement header = driver.findElement(By
                    .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/thead/tr/th[2]/span"));
            header.click();
            Thread.sleep(3000);
        }
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(2,row.size());
        List<WebElement> cell1 = row.get(0).findElements(By.className("MuiTableCell-root"));
        List<WebElement> cell2 = row.get(1).findElements(By.className("MuiTableCell-root"));
        Assertions.assertTrue(cell1.get(1).getText().compareTo(cell2.get(1).getText())>=0);
        driver.close();
    }

    @Test
    public void test18() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        WebElement header = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/thead/tr/th[3]/span"));
        header.click();
        Thread.sleep(3000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(2,row.size());
        List<WebElement> cell1 = row.get(0).findElements(By.className("MuiTableCell-root"));
        List<WebElement> shifts1 = cell1.get(2).findElements(By.className("MuiTypography-root"));
        List<WebElement> cell2 = row.get(1).findElements(By.className("MuiTableCell-root"));
        List<WebElement> shifts2 = cell2.get(2).findElements(By.className("MuiTypography-root"));
        Assertions.assertTrue(shifts1.get(0).getText().compareTo(shifts2.get(0).getText())<=0);
        driver.close();
    }

    @Test
    public void test19() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        for(int i=0;i<2;i++){
            WebElement header = driver.findElement(By
                    .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/thead/tr/th[3]/span"));
            header.click();
            Thread.sleep(3000);
        }
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(2,row.size());
        List<WebElement> cell1 = row.get(0).findElements(By.className("MuiTableCell-root"));
        List<WebElement> shifts1 = cell1.get(2).findElements(By.className("MuiTypography-root"));
        List<WebElement> cell2 = row.get(1).findElements(By.className("MuiTableCell-root"));
        List<WebElement> shifts2 = cell2.get(2).findElements(By.className("MuiTypography-root"));
        Assertions.assertTrue(shifts1.get(0).getText().compareTo(shifts2.get(0).getText())>=0);
        driver.close();
    }

    @Test
    public void test20() throws InterruptedException {
        Thread.sleep(5000);
        WebElement subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElement(By.className("MuiListItem-root"));
        subject.click();
        Thread.sleep(1000);
        WebElement viewButton = subject.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        List<WebElement> row =driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody"))
                .findElements(By.className("MuiTableRow-root"));
        Assertions.assertEquals(2,row.size());
        WebElement reg = row.get(0).findElement(By.tagName("input"));
        reg.click();
        Thread.sleep(3000);
        WebElement message = driver.findElement(By.className("MuiAlert-message"));
        Assertions.assertEquals("Đăng kí thành công",message.getText());
        WebElement remain = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[6]"));
        Assertions.assertEquals("0",remain.getText());
        driver.close();
    }

    @Test
    public void test21() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> subject= driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]"))
                .findElements(By.className("MuiListItem-root"));
        subject.get(2).click();
        Thread.sleep(1000);
        WebElement viewButton = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[4]/div/div[2]/div/div/div/div[2]/button"));
        viewButton.click();
        Thread.sleep(1000);
        WebElement reg1 = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[7]/label/span[1]/span/input"));
        reg1.click();
        Thread.sleep(8000);
        WebElement reg2 = driver.findElement(By
                .xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[2]/table/tbody/tr[2]/td[7]/label/span[1]/span/input"));
        Assertions.assertFalse(reg2.isEnabled());
        driver.close();
    }
}
