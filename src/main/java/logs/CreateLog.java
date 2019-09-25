package logs;

import org.apache.log4j.Logger;

public class CreateLog {

	public void writeLog(String testname,String methodname,String result) {
		Logger log;
		log=Logger.getLogger("devpinoyLogger");
		log.info("====================================================================================");
		log.info("----------------------------------"+methodname+"------------------------------------------");
		log.info("====================================================================================");
		log.info("Result : "+result);


	}
}
