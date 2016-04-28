import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Create Your Contacts");
  }

  @Test
  public void contactIsDisplayed() {
    goTo("http://localhost:4567/");
    fill("#firstName").with("Harry");
    fill("#lastName").with("Potter");
    submit(".btn");
    assertThat(pageSource()).contains("Harry Potter");
  }

  @Test
  public void contactDisplayPage() {
    goTo("http://localhost:4567/");
    fill("#firstName").with("Harry");
    fill("#lastName").with("Potter");
    submit(".btn");
    click("a", withText("Harry Potter"));
    assertThat(pageSource()).contains("Enter The Area Code");
  }

}
