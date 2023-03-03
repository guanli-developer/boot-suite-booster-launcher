package tech.guanli.boot.suite.booster.launcher.component;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import tech.guanli.boot.suite.booster.launcher.component.creator.ApplicationCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.BusinessCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.CoreCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.PomCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.ProjectCreator;

@Component
@ConditionalOnMissingBean(value = { BoosterLauncher.class }, ignored = DefaultBoosterLauncher.class)
public class DefaultBoosterLauncher implements BoosterLauncher, InitializingBean {

	@Autowired
	private ProjectCreator projectCreator;

	@Autowired
	private PomCreator pomCreator;

	@Autowired
	private ApplicationCreator applicationCreator;

	@Autowired
	private CoreCreator coreCreator;

	@Autowired
	private BusinessCreator businessCreator;

	@Override
	public void afterPropertiesSet() throws Exception {
		projectCreator.create();
		pomCreator.create();
		applicationCreator.create();
		coreCreator.create();
		businessCreator.create();
	}

}
