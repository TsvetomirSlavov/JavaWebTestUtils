package co.com.webtest.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class AbstractPage extends WebDriverPage {
	

	private static final int TIMEOUT = 15;
	private static final int POLLING_INTERVAL = 1;
	
	public AbstractPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}


	public void waitForId(final String id) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverProvider().get()).withTimeout(TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(POLLING_INTERVAL, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id(id));
			}
		});
	}
	
	public void waitForTagName(final String tagName){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverProvider().get()).withTimeout(TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(POLLING_INTERVAL, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.tagName(tagName));
			}
		});
	}
	
	public void waitForLinkText(final String linkText){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverProvider().get()).withTimeout(TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(POLLING_INTERVAL, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.linkText(linkText));
			}
		});
	}
	
	public void waitForName(final String name) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverProvider().get()).withTimeout(TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(POLLING_INTERVAL, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.name(name));
			}
		});
	}
	
	public void waitForXpath(final String xpath) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverProvider().get())
				.withTimeout(TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(POLLING_INTERVAL, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(xpath));
			}
		});
	}
	
	public void waitForCssSelector(final String selector) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverProvider().get())
				.withTimeout(TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(POLLING_INTERVAL, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector(selector));
			}
		});
	}
	
	public void waitForSelectToFillByName(final String selectName){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverProvider().get())
				.withTimeout(TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(POLLING_INTERVAL, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement select = driver.findElement(By.name(selectName));
				return select.findElement(By.xpath("//option[0]"));
			}
		});
	}
	
	public void waitUntil(int millis){
		Integer i = 0;
		Wait<Integer> wait = new FluentWait<Integer>(i)
				.withTimeout(millis, TimeUnit.MILLISECONDS)
				.pollingEvery(millis, TimeUnit.MILLISECONDS);
		try{
			wait.until(new Function<Integer, Boolean>() {
				public Boolean apply(Integer i) {
					
					return false;
				}
			});
		}catch(Exception e){
			//bien!
		}
	}
	
	public boolean pageContainsLink(String linkText){
		List<WebElement> elements = findElements(By.linkText(linkText));
		return !elements.isEmpty();
	}
	
	public void acceptAlert() {
	    try {
	        WebDriverWait wait = new WebDriverWait(getDriverProvider().get(), 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = switchTo().alert();
	        alert.accept();
	    } catch (Exception e) {
	        //exception handling
	    }
	}
	
	 /**
	  * Waits for a new window to open and then changes the driverprovider context
	  * to that new window
	  * @param popupURL
	  * @return
	  */
	 public boolean waitForPopUpAndChangeContext(final String popupURL){
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverProvider().get())
					.withTimeout(TIMEOUT, TimeUnit.SECONDS)
					.pollingEvery(POLLING_INTERVAL, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			
			String newWindowHandle = wait.until(new Function<WebDriver, String>() {
				public String apply(WebDriver driver) {
					Set<String> newHandles = driver.getWindowHandles();
					for(String handleName: newHandles){					
						switchTo().window(handleName);
						if(getCurrentUrl().startsWith(popupURL)){
							return handleName;										
						}
					}				
					return null;
				}
			});
			return newWindowHandle != null;
	 }
	 
	 
	 public boolean waitForPopUp(final int numberOfInitialWindows){
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverProvider().get())
					.withTimeout(TIMEOUT, TimeUnit.SECONDS)
					.pollingEvery(POLLING_INTERVAL, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			
			Boolean newWindowHandle = wait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					Set<String> newHandles = driver.getWindowHandles();
					if(newHandles.size() == numberOfInitialWindows+1){
						return new Boolean(true);
					}
					return new Boolean(false);
				}
			});
			return newWindowHandle.booleanValue();
	 }
	 
	 
	 public void acceptCertificateError(){		
		 get("javascript: if(document.getElementById('overridelink')){document.getElementById('overridelink').click();}");
	 }
	 
	 
	 public void clickLink(String linkText){
		 findElement(By.linkText(linkText)).click(); 
	 }
	 
	 public boolean validarElementoHabilitado(String id){
		 return findElement(By.id(id)).isEnabled(); 
	 }
	 
	 public boolean validarElementoVisibleById(String id){
		 boolean resultado;
		 try {
			resultado = findElement(By.id(id)).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			resultado = false;
		} 
		 return resultado;
	 }
	 
	 public boolean validarElementoVisibleByName(String name){
		 return findElement(By.name(name)).isDisplayed(); 
	 }
	 
	 public boolean validarElementoVisibleByLinkText(String linkText){
		 return findElement(By.linkText(linkText)).isDisplayed(); 
	 }
	 
	 public boolean validarElementoVisibleByPartialLinkText(String linkText){
		 return findElement(By.partialLinkText(linkText)).isDisplayed(); 
	 }
	 
	 public boolean validarElementoVisibleByCssSelector(String selector){
		 return findElement(By.cssSelector(selector)).isDisplayed();
	 }
	 
	 public String getTextoElementoByCssSelector(String selector){
		 WebElement element = findElement(By.cssSelector(selector));
		 return element.getText();
	 }
	 
	public boolean existsLinkWithText(String value) {
		boolean retorno = true;
		try {
			retorno = findElement(By.linkText(value)) != null;
		} catch(NoSuchElementException e) {
			retorno = false;
		}
		return retorno;
	}
	
	public void asignarValorInputByName(String name,String value){
		WebElement input = findElement(By.name(name));
		input.clear();
		input.sendKeys(value);
	}
	
	public String getValorInputByName(String name) {
		WebElement input = findElement(By.name(name));
		return input.getAttribute("value");
	}
	
	private void clickInputOptionByNameValue(String name, String value) {
		List<WebElement> inputOptionList = findElements(By.name(name));
		for (Iterator iterator = inputOptionList.iterator(); iterator.hasNext();) {
			WebElement element = (WebElement) iterator.next();
			if(element.getAttribute("value").equalsIgnoreCase(value)){
				element.click();
			}
			
		}
	}
	
	private boolean isOptionValueSelected(String name, String value) {
		List<WebElement> inputOptionList = findElements(By.name(name));
		for (Iterator iterator = inputOptionList.iterator(); iterator.hasNext();) {
			WebElement element = (WebElement) iterator.next();
			if(element.getAttribute("value").equals(value)){
				return element.isSelected();
			}
		}
		return false;
	}
	
	public void clickMultipleCheckBoxesByNameValues(String name,String[] values) {
		List<WebElement> checkboxList = findElements(By.name(name));
		String value="";
		for (Iterator iterator = checkboxList.iterator(); iterator.hasNext();) {
			WebElement element = (WebElement) iterator.next();
			value = element.getAttribute("value");
			if(Arrays.asList(values).contains(value)){
				element.click();
			}
		}
	}
	
	public void clickCheckBoxByNameValue(String name, String value) {
		clickInputOptionByNameValue(name, value);
	}
	
	public boolean isCheckboxValueSelected(String name, String value) {
		return isOptionValueSelected(name, value);
	}

	public void adicionarValorInputByName(String name, String value) {
		WebElement input = findElement(By.name(name));
		input.click();
		input.sendKeys(value);
	}
	
	public void clickRadioButtonByNameValue(String name, String value) {
		clickInputOptionByNameValue(name, value);
	}

	public boolean isRadioButtonValueSelected(String name, String value) {
		return isOptionValueSelected(name, value);
	}
	
	public void selectOptionByNameAndVisibleText(String name, String visibleText) {
		Select selectBox = new Select(findElement(By.name(name)));
		selectBox.selectByVisibleText(visibleText);
	}
	
	public String getSelectedOptionValueByName(String name) {
		Select selectBox = new Select(findElement(By.name(name)));
		return selectBox.getFirstSelectedOption().getText();
	}
	
	public String getSelectedOptionValueById(String id) {
		Select selectBox = new Select(findElement(By.id(id)));
		return selectBox.getFirstSelectedOption().getText();
	}
	
	public void selectOptionByNameAndValue(String name, String value) {
		Select selectBox = new Select(findElement(By.name(name)));
		selectBox.selectByValue(value);
	}
	
	public void clicButtonById(String id) {
		WebElement button = findElement(By.id(id));
		button.click();
	}
	
	public void clicButtonByName(String name) {
		WebElement button = findElement(By.name(name));
		button.click();
	}
	
	public void selectMultipleOptionsByNameAndVisibleText(String name,
			List<String> opts) {
		Select selectBox = new Select(findElement(By.name(name)));
		
		for (Iterator<String> iterator = opts.iterator(); iterator.hasNext();) {
			String value = (String) iterator.next();
			selectBox.selectByVisibleText(value);
		}
	}
	
	public List<String> getSelectedOptionsValueByName(String name) {
		Select selectBox = new Select(findElement(By.name(name)));
		List<WebElement> options = selectBox.getAllSelectedOptions();
		List<String> strOpts = new ArrayList<String>();
		for (Iterator<WebElement> iterator = options.iterator(); iterator.hasNext();) {
			WebElement option = (WebElement) iterator.next();
			strOpts.add(option.getText());
		}
		return strOpts;
	}
	
	public boolean validarOpcionesSeleccionadas(String name, List<String> opts){
		boolean selected=true;
		List<String> options = getSelectedOptionsValueByName(name);
		
		for (Iterator<String> iterator = opts.iterator(); iterator.hasNext();) {
			if(options.contains((String) iterator.next())){
				selected &= true; 
			}else{
				selected &= false;
			}
		}
		
		return selected;
	}
}
