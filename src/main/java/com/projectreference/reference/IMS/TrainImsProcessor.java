/*
package com.projectreference.reference.IMS;

import com.bnsf.rmt.constant.TrainImsConstants;
import com.bnsf.rmt.controller.MultiSegInputNatTran;
import com.bnsf.sms.common.ims.IMSNatSpec;


public class TrainImsProcessor {

    String[] ims;

    public TrainImsProcessor(String[] ims) {
        this.ims = ims;
    }

    public AuthImsResponse executeActiveTrainRequest(AuthInputParm parm) throws Exception{

        final AuthImsRequest req = new AuthImsRequest(parm);
        final MultiSegInputNatTran natTran = new MultiSegInputNatTran(false,
                new IMSNatSpec(this.ims[0],
                        this.ims[1],
                        TrainImsConstants.NAT_TRAN_BASE,
                        TrainImsConstants.IMS_TIMEOUT ,
                        TrainImsConstants.IMS_PORT ,
                        "        ",
                        TrainImsConstants.NAT_TRAN_BASE,
                        TrainImsConstants.NAT_LIBRARY_OY_DEM,
                        TrainImsConstants.NAT_PROGRAM_DMIP9012));

        final AuthImsTran authImsTran = new AuthImsTran(natTran, req);
        return authImsTran.execute();
    }

}
*/
