package tech.guanli.boot.suite.booster.launcher.component.creator;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.guanli.boot.suite.booster.launcher.component.creator.core.BasicCoreControllerCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.core.BasicCoreManagerCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.core.BasicCoreServiceCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.core.CoreMapperCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.core.CoreServiceCreator;
import tech.guanli.boot.suite.booster.launcher.component.creator.core.CoreStructCreator;

@Component
public class CoreCreator extends BasicCreator {

	@Autowired
	private CoreStructCreator coreStructCreator;

	@Autowired
	private CoreMapperCreator coreMapperCreator;

	@Autowired
	private CoreServiceCreator coreServiceCreator;

	@Autowired
	private BasicCoreManagerCreator basicCoreManagerCreator;

	@Autowired
	private BasicCoreServiceCreator basicCoreServiceCreator;

	@Autowired
	private BasicCoreControllerCreator basicCoreControllerCreator;

	@Override
	public void create() {
		new File(basePackageGenerator.getBasePackage() + File.separator + "core").mkdirs();
		coreStructCreator.create();
		coreMapperCreator.create();
		coreServiceCreator.create();
		basicCoreManagerCreator.create();
		basicCoreServiceCreator.create();
		basicCoreControllerCreator.create();
	}

}
