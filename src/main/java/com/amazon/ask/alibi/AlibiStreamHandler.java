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
				.withSkillId("amzn1.ask.skill.d7b12298-5855-4a63-b7c3-1f39c767052d")
				.build();
	}
	
	
	public AlibiStreamHandler() {
		super(getSkill());
	}

}
