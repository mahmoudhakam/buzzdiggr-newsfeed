package com.buzzdiggr.service.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.buzzdiggr.BuzzdiggrConstants;

@Service
public class WebDataStreamer
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${buzzdiggr.youmseven}")
	String youSevenSeed;
	@Value("${buzzdiggr.shrouk}")
	String shroukSeed;
	@Value("${buzzdiggr.yallakora}")
	String yallakoraSeed;

	JsoupParser parser;

	@Autowired
	public WebDataStreamer(JsoupParser parser)
	{
		super();
		this.parser = parser;
	}

	public void scrabYouSeven()
	{
		logger.info("Start scrabbing youmseven site");
		parser.parse(youSevenSeed, BuzzdiggrConstants.Sources.YOUM_SEVEN, youSevenSeed);
	}

	public void scrabShrouk()
	{
		logger.info("Start scrabbing shrouk site");
		parser.parse(shroukSeed, BuzzdiggrConstants.Sources.SHROUK, shroukSeed);
	}

	public void scrabYallaKora()
	{
		logger.info("Start scrabbing yallakora site");
		parser.parse(yallakoraSeed, BuzzdiggrConstants.Sources.YALLA_KORA, yallakoraSeed);
	}

}
