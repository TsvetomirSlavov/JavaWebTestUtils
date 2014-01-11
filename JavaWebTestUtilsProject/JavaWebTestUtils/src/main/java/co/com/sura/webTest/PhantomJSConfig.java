package co.com.sura.webTest;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.web.selenium.ContextView;
import org.jbehave.web.selenium.LocalFrameContextView;
import org.jbehave.web.selenium.PerStoriesWebDriverSteps;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverSteps;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.util.concurrent.MoreExecutors;

public abstract class PhantomJSConfig extends JUnitStories{
	
	protected WebDriverProvider driverProvider = getWebDriver();
		
	protected WebDriverSteps lifecycleSteps = new PerStoriesWebDriverSteps(driverProvider);
	
	private SeleniumContext context = new SeleniumContext();
	
	private ContextView contextView = new LocalFrameContextView().sized(500,100);
	
	protected Configuration configuration = configuration();

	private String phantomJSDriverPath = "";

	
	public PhantomJSConfig() {		
		configuredEmbedder().useExecutorService(MoreExecutors.sameThreadExecutor());
	}
	
	protected WebDriverProvider getWebDriver()
	{
		PhantomJSDelegateWebDriverProvider driverProvider = PhantomJSDelegateWebDriverProvider.getDriverWithJsDirverOnPath();
		DesiredCapabilities capabilities = createDesiredCapabilites();
		driverProvider.setDesiredCapabilities(capabilities);
		return driverProvider;
	}
	
	
	protected abstract List<Object> getWebSteps();
	
	@Override
	public List<CandidateSteps> candidateSteps() {
				
		List<Object> steps = getWebSteps();
		steps.add(lifecycleSteps);
		steps.add(configuration.storyReporterBuilder());
		InstanceStepsFactory instanceStepFactory = new InstanceStepsFactory(configuration(), steps.toArray(new Object[steps.size()])); 
		return instanceStepFactory.createCandidateSteps();
	}
	
	@Override
	public List<String> storyPaths() {
		return new StoryFinder().findPaths(
				CodeLocations.codeLocationFromPath("src/test/resources"),
				"**/*.story", "");
	}
	
	@Override
	public Configuration configuration() {
		if (configuration == null) {
			Class<?> embeddableClass = this.getClass();

			return new SeleniumConfiguration()
					.useSeleniumContext(context)
					.useWebDriverProvider(driverProvider)
					.useStepMonitor(
							new SeleniumStepMonitor(contextView, context,
									new SilentStepMonitor()))
					.useStoryLoader(new LoadFromClasspath(embeddableClass))
					.useStoryReporterBuilder(
							new StoryReporterBuilder()
									.withCodeLocation(
											CodeLocations
													.codeLocationFromClass(embeddableClass))
									.withDefaultFormats()
									.withFormats(Format.CONSOLE, Format.TXT,
											Format.HTML, Format.XML));
		} else {
			return configuration;
		}
	}

	protected DesiredCapabilities createDesiredCapabilites() {
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("takesScreenshot", true);
		if (phantomJSDriverPath  != "") {
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
				phantomJSDriverPath);		
		}
		return capabilities;
		
		
	}

	

	
	
}
