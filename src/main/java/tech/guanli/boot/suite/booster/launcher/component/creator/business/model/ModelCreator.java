package tech.guanli.boot.suite.booster.launcher.component.creator.business.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.guanli.boot.suite.booster.launcher.component.creator.BasicBusinessCreator;

@Component
public class ModelCreator extends BasicBusinessCreator {

	@Autowired
	private PayloadCreator payloadCreator;

	@Autowired
	private ParameterCreator parameterCreator;

	@Autowired
	private PersistableCreator persistableCreator;

	@Autowired
	private ReturnableCreator returnableCreator;

	@Override
	public void create() {
		payloadCreator.setModel(model);
		payloadCreator.create();
		parameterCreator.setModel(model);
		parameterCreator.create();
		persistableCreator.setModel(model);
		persistableCreator.create();
		returnableCreator.setModel(model);
		returnableCreator.create();
	}

}
