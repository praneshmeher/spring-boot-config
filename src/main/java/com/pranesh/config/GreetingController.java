package com.pranesh.config;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Value("${my.greeting: default value}")
	private String greetingMessage;
	
	@Value("${my.list.values}")
	private List<String> list;
	
	@Value("#{${my.obj}}")
	private Map<String, String> obj;
	
	@Autowired
	private DBConfig dbconfig;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/greeting")
	public String greeting() {
		return greetingMessage;
	}
	
	@RequestMapping("/list")
	public List<String> getList(){
		return list;
	}
	
	@RequestMapping("/getobj")
	public Map<String, String> getObj(){
		return obj;
	}
	
	@RequestMapping("/getdbconfig")
	public String getDBConfig() {
		return dbconfig.getConnection() + dbconfig.getHost() + dbconfig.getPort();
	}
	
	@RequestMapping("/getenv")
	public String getEnvDetails() {
		return env.toString();
	}
	
}
