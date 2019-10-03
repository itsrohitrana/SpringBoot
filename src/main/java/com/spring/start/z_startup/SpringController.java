package com.spring.start.z_startup;

import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpringController {



	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
	@RequestMapping(value = "/user-login",
			method = RequestMethod.GET,
			produces = MediaType.TEXT_HTML_VALUE)
    
	public ResponseEntity<?> getlogin(){
		return new ResponseEntity("<!doctype html>\n" +
				"<html style=\"background: gray\" id=\"mainHtml\" >\n" + 
				"<body><!-- #######  YAY, I AM THE SOURCE EDITOR! #########-->\n"+
				 "<form name=\"loginForm\" method=\"get\" action=\"/api/user-data\">\n" + 
				 "<table width=\"20%\" bgcolor=\"0099CC\" align=\"center\">\n" + 
				 "\n" + 
				 "<tr>\n" + 
				 "<td colspan=2><center><font size=4><b>Login</b></font></center></td>\n" + 
				 "</tr>\n" + 
				 "\n" + 
				 "<tr>\n" + 
				 "<td>Username:</td>\n" + 
				 "<td><input type=\"text\" size=25 name=\"userid\"></td>\n" + 
				 "</tr>\n" + 
				 "\n" + 
				 "<tr>\n" + 
				 "<td>Password:</td>\n" + 
				 "<td><input type=\"Password\" size=25 name=\"pwd\"></td>\n" + 
				 "</tr>\n" + 
				 "\n" + 
				 "<tr>\n" + 
				 "<td ><input type=\"Reset\"></td>\n" + 
				 "<td><input type=\"submit\" onclick=\"return check(this.form;location.reload(forceGet)\n" + 
				 ")\" value=\"Login\"></td>\n" + 
				 "</tr>\n" + 
				 "\n" + 
				 "</table>\n" + 
				 "</form></body></html" , HttpStatus.OK);
	}
    
    
    @RequestMapping(value = "/user-data",
			method = RequestMethod.GET,
			produces = MediaType.TEXT_HTML_VALUE)
    
	public ResponseEntity<?> getuserData()
			throws URISyntaxException {
    	
    	Udata b = new Udata();
    	b.setId("02");
    	b.setName("New USER123");
		return new ResponseEntity("<!doctype html>\n" + 
				"<html style=\"background: gray\" id=\"mainHtml\" >\n" + 
"<body><!-- #######  YAY, I AM THE SOURCE EDITOR! #########-->\n" + 
"<h1 style=\"color: #5e9ca0;\">You can edit <span style=\"color: #2b2301;\">this demo</span> text!</h1>\n" + 
"<h2 style=\"color: #2e6c80;\">How to use the editor:</h2>\n" + 
"<p>Paste your documents in the visual editor on the left or your HTML code in the source editor in the right. <br />Edit any of the two areas and see the other changing in real time.&nbsp;</p>\n" + 
"<p>Click the <span style=\"background-color: #2b2301; color: #fff; display: inline-block; padding: 3px 10px; font-weight: bold; border-radius: 5px;\">Clean</span> button to clean your source code.</p>\n" + 
"<h2 style=\"color: #2e6c80;\">Some useful features:</h2>\n" + 
"<ol style=\"list-style: none; font-size: 14px; line-height: 32px; font-weight: bold;\">\n" + 
"<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/01-interactive-connection.png\" alt=\"interactive connection\" width=\"45\" /> Interactive source editor</li>\n" + 
"<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/02-html-clean.png\" alt=\"html cleaner\" width=\"45\" /> HTML Cleaning</li>\n" + 
"<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/03-docs-to-html.png\" alt=\"Word to html\" width=\"45\" /> Word to HTML conversion</li>\n" + 
"<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/04-replace.png\" alt=\"replace text\" width=\"45\" /> Find and Replace</li>\n" + 
"<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/05-gibberish.png\" alt=\"gibberish\" width=\"45\" /> Lorem-Ipsum generator</li>\n" + 
"<li style=\"clear: both;\"><img style=\"float: left;\" src=\"https://html-online.com/img/6-table-div-html.png\" alt=\"html table div\" width=\"45\" /> Table to DIV conversion</li>\n" + 
"</ol>\n" + 
"<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>\n" + 
"<h2 style=\"color: #2e6c80;\">Cleaning options:</h2>\n" + 
"<table class=\"editorDemoTable\">\n" + 
"<thead>\n" + 
"<tr>\n" + 
"<td>Name of the feature</td>\n" + 
"<td>Example</td>\n" + 
"<td>Default</td>\n" + 
"</tr>\n" + 
"</thead>\n" + 
"<tbody>\n" + 
"<tr>\n" + 
"<td>Remove tag attributes</td>\n" + 
"<td><img style=\"margin: 1px 15px;\" src=\"images/smiley.png\" alt=\"laughing\" width=\"40\" height=\"16\" /> (except <strong>img</strong>-<em>src</em> and <strong>a</strong>-<em>href</em>)</td>\n" + 
"<td>&nbsp;</td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Remove inline styles</td>\n" + 
"<td><span style=\"color: green; font-size: 13px;\">You <strong style=\"color: blue; text-decoration: underline;\">should never</strong>&nbsp;use inline styles!</span></td>\n" + 
"<td><strong style=\"font-size: 17px; color: #2b2301;\">x</strong></td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Remove classes and IDs</td>\n" + 
"<td><span id=\"demoId\">Use classes to <strong class=\"demoClass\">style everything</strong>.</span></td>\n" + 
"<td><strong style=\"font-size: 17px; color: #2b2301;\">x</strong></td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Remove all tags</td>\n" + 
"<td>This leaves <strong style=\"color: blue;\">only the plain</strong> <em>text</em>. <img style=\"margin: 1px;\" src=\"images/smiley.png\" alt=\"laughing\" width=\"16\" height=\"16\" /></td>\n" + 
"<td>&nbsp;</td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Remove successive &amp;nbsp;s</td>\n" + 
"<td>Never use non-breaking spaces&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;to set margins.</td>\n" + 
"<td><strong style=\"font-size: 17px; color: #2b2301;\">x</strong></td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Remove empty tags</td>\n" + 
"<td>Empty tags should go!</td>\n" + 
"<td>&nbsp;</td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Remove tags with one &amp;nbsp;</td>\n" + 
"<td>This makes&nbsp;no sense!</td>\n" + 
"<td><strong style=\"font-size: 17px; color: #2b2301;\">x</strong></td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Remove span tags</td>\n" + 
"<td>Span tags with <span style=\"color: green; font-size: 13px;\">all styles</span></td>\n" + 
"<td><strong style=\"font-size: 17px; color: #2b2301;\">x</strong></td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Remove images</td>\n" + 
"<td>I am an image: <img src=\"images/smiley.png\" alt=\"laughing\" /></td>\n" + 
"<td>&nbsp;</td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Remove links</td>\n" + 
"<td><a href=\"https://html-online.com\">This is</a> a link.</td>\n" + 
"<td>&nbsp;</td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Remove tables</td>\n" + 
"<td>Takes everything out of the table.</td>\n" + 
"<td>&nbsp;</td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Replace table tags with structured divs</td>\n" + 
"<td>This text is inside a table.</td>\n" + 
"<td>&nbsp;</td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Remove comments</td>\n" + 
"<td>This is only visible in the source editor <!-- HELLO! --></td>\n" + 
"<td><strong style=\"font-size: 17px; color: #2b2301;\">x</strong></td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Encode special characters</td>\n" + 
"<td><span style=\"color: red; font-size: 17px;\">&hearts;</span> <strong style=\"font-size: 20px;\">☺ ★</strong> &gt;&lt;</td>\n" + 
"<td><strong style=\"font-size: 17px; color: #2b2301;\">x</strong></td>\n" + 
"</tr>\n" + 
"<tr>\n" + 
"<td>Set new lines and text indents</td>\n" + 
"<td>Organize the tags in a nice tree view.</td>\n" + 
"<td>&nbsp;</td>\n" + 
"</tr>\n" + 
"</tbody>\n" + 
"</table>\n" + 
"<p><strong>&nbsp;</strong></p>\n" + 
"<p><strong>Save this link into your bookmarks and share it with your friends. It is all FREE! </strong><br /><strong>Enjoy!</strong></p>\n" + 
"<p><strong>&nbsp;</strong></p> </body>",HttpStatus.OK);
	}
    
    
    
}

class Udata{
	String id;
	String name;
	Udata(){}
	
	Udata(String id ,String Name){
		this.id = id;
		this.name = Name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}