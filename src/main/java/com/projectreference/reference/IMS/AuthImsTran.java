/*
package com.projectreference.reference.IMS;

import com.bnsf.rmt.constant.TrainImsConstants;
import com.bnsf.rmt.controller.MultiSegInputNatTran;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

*/
/**
 *
 *//*

public class AuthImsTran {
    private final MultiSegInputNatTran tran;
    private final AuthImsRequest req;
    private boolean error;
    private String errorMessage;

    */
/**
     * @param tran
     * @param req
     *//*

    public AuthImsTran(MultiSegInputNatTran tran,
                       AuthImsRequest req) {
        this.tran = tran;
        this.req = req;
    }

    */
/**
     * @return AuthImsResponse
     *//*

    public AuthImsResponse execute() throws Exception {
        String cutoffDetails = "";
        try {
            this.tran.submit(this.req);
            final byte[][] segs = this.tran.getSegs();
            if (this.tran.isError()) {
                this.error = true;

            } else if (segs != null) {
                for (final byte[] b1 : segs) {
                    try {
                        final String s1 = new String(b1, Charset.forName("UTF-8"));
                        if (TrainImsConstants.SUCCESS.equalsIgnoreCase(s1.substring(0, TrainImsConstants.SEGMENT_IDENTIFIER_LEN))) {
                            cutoffDetails = s1;
                            this.error = false;
                        } else {
                            this.error = true;
                        }
                    } catch (final Exception e) {
                        this.error = true;
                    }
                }
            }
        } catch (final Exception e) {
            this.error = true;
        }
        if (this.error) {
            return new AuthImsResponse(this.error, errorMessage.trim(), null);
        } else {
            List<AuthOutputParm> parseTrainId = parseActiveTrainIdAndRoute(cutoffDetails);
            return new AuthImsResponse(this.error, "", parseTrainId);
        }

    }

    */
/**
     * @param cutoffString
     * @return List<AuthOutputParm> cutoffDetails
     * @throws Exception
     *//*

    private List<AuthOutputParm> parseActiveTrainIdAndRoute(String cutoffString) throws Exception {
        int CarDetailsLength = 34;
        List<AuthOutputParm> cutoffDetails = new ArrayList<>();
        if (cutoffString.length() > 34) {
            for (int i = CarDetailsLength; i + 69 <= cutoffString.length(); i += 69) {
                AuthOutputParm parm = new AuthOutputParm();
                parm.setERR_CODE(cutoffString.substring(0, 4));
                parm.setLN_CNT(cutoffString.substring(4, 9));
                parm.setTOT_LN_CNT(cutoffString.substring(9, 14));
                parm.setCUST_9013(cutoffString.substring(14, 26));
                parm.setSTN_9013(cutoffString.substring(26, 32));
                parm.setSTN_ST_9013(cutoffString.substring(32, 34));
                String cutoffTrackDetails = cutoffString.substring(i, i + 69);
                if (cutoffTrackDetails.substring(0, 6).equalsIgnoreCase("      ")) {

                    for (int j = i; j >= CarDetailsLength; j -= 69) {
                        if (!cutoffString.substring(j - 69, (j - 69) + 6).equals("      ")) {
                            parm.setOUT_ZTS(cutoffString.substring(j - 69, (j - 69) + 6));
                            break;
                        }
                    }

                } else {
                    parm.setOUT_ZTS(cutoffTrackDetails.substring(0, 6));
                }
                parm.setOUT_DOW_MON(cutoffTrackDetails.substring(6, 7));
                parm.setOUT_SPOT_TIMES_MON(cutoffTrackDetails.substring(7, 11));
                parm.setOUT_PULL_TIMES_MON(cutoffTrackDetails.substring(11, 15));
                parm.setOUT_DOW_TUE(cutoffTrackDetails.substring(15, 16));
                parm.setOUT_SPOT_TIMES_TUE(cutoffTrackDetails.substring(16, 20));
                parm.setOUT_PULL_TIMES_TUE(cutoffTrackDetails.substring(20, 24));
                parm.setOUT_DOW_WED(cutoffTrackDetails.substring(24, 25));
                parm.setOUT_SPOT_TIMES_WED(cutoffTrackDetails.substring(25, 29));
                parm.setOUT_PULL_TIMES_WED(cutoffTrackDetails.substring(29, 33));
                parm.setOUT_DOW_THU(cutoffTrackDetails.substring(33, 34));
                parm.setOUT_SPOT_TIMES_THU(cutoffTrackDetails.substring(34, 38));
                parm.setOUT_PULL_TIMES_THU(cutoffTrackDetails.substring(38, 42));
                parm.setOUT_DOW_FRI(cutoffTrackDetails.substring(42, 43));
                parm.setOUT_SPOT_TIMES_FRI(cutoffTrackDetails.substring(43, 47));
                parm.setOUT_PULL_TIMES_FRI(cutoffTrackDetails.substring(47, 51));
                parm.setOUT_DOW_SAT(cutoffTrackDetails.substring(51, 52));
                parm.setOUT_SPOT_TIMES_SAT(cutoffTrackDetails.substring(52, 56));
                parm.setOUT_PULL_TIMES_SAT(cutoffTrackDetails.substring(56, 60));
                parm.setOUT_DOW_SUN(cutoffTrackDetails.substring(60, 61));
                parm.setOUT_SPOT_TIMES_SUN(cutoffTrackDetails.substring(61, 65));
                parm.setOUT_PULL_TIMES_SUN(cutoffTrackDetails.substring(65, 69));
                cutoffDetails.add(parm);
            }
        } else {
            cutoffDetails = null;
        }

        return cutoffDetails;
    }

}
*/
