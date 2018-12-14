package com.amazon.ask.alibi;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import com.amazon.ask.alibi.handlers.*;


public class AlibiStreamHandler extends SkillStreamHandler {
	
	
	private static Skill getSkill() {
		return Skills.standard()
				.addRequestHandlers(
						new StopIntentHandler(),
						new DateIntentHandler(),
						new HelpIntentHandler(),
						new LaunchRequestHandler(),
						new SessionEndedRequestHandler(),
						new LocationIntentHandler(),
						new WhatsMyAlibiIntentHandler())
				.withSkillId("amzn1.ask.skill.0b6f254b-b6b8-49c0-a2ec-5585cfcb9c89")
				.build();
	}
	
	
	public AlibiStreamHandler() {
		super(getSkill());
	}

}
