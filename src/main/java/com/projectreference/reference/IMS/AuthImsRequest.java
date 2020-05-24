/*
package com.projectreference.reference.IMS;

import com.bnsf.sms.common.ims.MultiSegInputIMSRequest;
import net.sf.jsefa.Serializer;
import net.sf.jsefa.flr.FlrIOFactory;

import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class AuthImsRequest implements MultiSegInputIMSRequest {
    private AuthInputParm parm;


    AuthImsRequest(AuthInputParm parm) {
        super();
        this.parm = parm;
    }

    @Override
    public byte[][] getMsg() {

        final List<String> list = new ArrayList<String>();
        list.add("        ");
        list.add(getFtctInputParmString(this.parm));

        final byte[][] baa = new byte[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            baa[i] = list.get(i).getBytes(Charset.forName("UTF-8"));
        }

        return baa;
    }

    private String getFtctInputParmString(AuthInputParm parm) {
        final Serializer serializer = FlrIOFactory.createFactory(AuthInputParm.class)
                .createSerializer();
        final StringWriter writer = new StringWriter();
        serializer.open(writer);
        serializer.write(parm);
        serializer.close(true);
        final String value = writer.toString().replaceAll("(\r\n|\n)", "");
        return value;
    }

}
*/
