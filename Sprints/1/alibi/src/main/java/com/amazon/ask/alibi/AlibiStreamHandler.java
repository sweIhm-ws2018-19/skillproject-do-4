package com.amazon.ask.alibi;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;

import com.amazon.ask.alibi.handlers.CancelandStopIntentHandler;
import com.amazon.ask.alibi.handlers.AlibiIntentHandler;
import com.amazon.ask.alibi.handlers.HelpIntentHandler;
import com.amazon.ask.alibi.handlers.LaunchRequestHandler;

public class AlibiStreamHandler extends SkillStreamHandler {
	
	private static Skill getSkill() {
		return Skills.standard()
				.addRequestHandlers(
						new CancelandStopIntentHandler(),
						new AlibiIntentHandler(),
						new HelpIntentHandler(),
						new LaunchRequestHandler())
				.build();
	}
	
	
	public AlibiStreamHandler() {
		super(getSkill());
	}

}
