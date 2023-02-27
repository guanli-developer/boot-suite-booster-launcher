package tech.guanli.boot.suite.booster.launcher.component.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;

import tech.guanli.boot.suite.booster.launcher.component.BasePackageGenerator;
import tech.guanli.boot.suite.booster.launcher.configuration.BoosterLaunchConfigurationProperty;

public abstract class BasicCreator {
	@Autowired
	protected BoosterLaunchConfigurationProperty configurationProperty;

	@Autowired
	protected BasePackageGenerator basePackageGenerator;

	@Autowired
	protected FreeMarkerConfigurationFactory configurationFactory;

	public abstract void create();
}
