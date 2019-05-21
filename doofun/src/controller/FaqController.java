package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FaqController {
	
	@RequestMapping("/faq")
	public String faq() throws Exception{				
		
		return "faq/faq";		
	}
	@RequestMapping("/faq1")
	public String faq1() throws Exception{				
		
		return "faq/faq1";		
	}
	@RequestMapping("/faq2")
	public String faq2() throws Exception{				
		
		return "faq/faq2";		
	}
	@RequestMapping("/faq3")
	public String faq3() throws Exception{				
		
		return "faq/faq3";		
	}
	@RequestMapping("/faq4")
	public String faq4() throws Exception{				
		
		return "faq/faq4";		
	}
	@RequestMapping("/faq5")
	public String faq5() throws Exception{				
		
		return "faq/faq5";		
	}
	@RequestMapping("/faq6")
	public String faq6() throws Exception{				
		
		return "faq/faq6";		
	}
	@RequestMapping("/faq7")
	public String faq7() throws Exception{				
		
		return "faq/faq7";		
	}
	@RequestMapping("/faq8")
	public String faq8() throws Exception{				
		
		return "faq/faq8";		
	}
	
}
