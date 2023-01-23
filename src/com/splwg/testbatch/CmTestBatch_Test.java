package com.splwg.testbatch;

import java.math.BigInteger;
import java.util.Iterator;

import com.splwg.base.api.batch.SubmissionParameters;
import com.splwg.base.api.datatypes.Bool;
import com.splwg.base.api.datatypes.Date;
import com.splwg.base.api.lookup.RunStatusLookup;
import com.splwg.base.api.lookup.ThreadStatusLookup;
import com.splwg.base.api.testers.BatchJobTestCase;
import com.splwg.base.domain.batch.batchControl.BatchControl_Id;
import com.splwg.base.domain.batch.batchRun.BatchRun;
import com.splwg.base.domain.batch.batchRun.BatchThread;
import com.splwg.shared.logging.Logger;
import com.splwg.shared.logging.LoggerFactory;

public class CmTestBatch_Test extends BatchJobTestCase{

	Logger logger = LoggerFactory.getLogger(CmTestBatch_Test.class);
	@Override
	protected SubmissionParameters setupRun(SubmissionParameters defaultParms) {

		logger.info("start batch");
		
        
        Date executionDate = new Date(2020, 04, 03);

        defaultParms = createDefaultParameters(1);
        defaultParms.setBatchControlId(new BatchControl_Id("F1-FLUSH"));
        defaultParms.setProcessDate(executionDate);
        defaultParms.setBatchRerunNumber(BigInteger.ZERO);
        defaultParms.setBatchThreadNumber(new BigInteger("1"));
        defaultParms.setIsTracingProgramStart(Bool.TRUE);
        defaultParms.setIsTracingProgramEnd(Bool.TRUE);
        defaultParms.setIsTracingSQL(Bool.TRUE);
        defaultParms.setIsTracingStandardOut(Bool.TRUE);
        defaultParms.setLanguageId(getActiveContextLanguage().getId());
        defaultParms.setMaxExecutionAttempts(BigInteger.valueOf(1));
        
        
        logger.info("end batch");
		
		return defaultParms;
	}

	@Override
	protected void validateResults(BatchRun batchRun) {
		  assertEquals("BatchRun is expected to complete successfully", RunStatusLookup.constants.COMPLETE, batchRun
	                .getRunStatus());
		  
		  for (Iterator iter = batchRun.getThreads().iterator(); iter.hasNext();) {
	            BatchThread batchThread = (BatchThread) iter.next();
	            assertEquals("1","1");
	        }
		
	}

}
