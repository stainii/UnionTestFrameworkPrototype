package be.stijnhooft.uniontestframeworkprototype;

import be.stijnhooft.uniontestframeworkprototype.flux.ResponseReceiverService;
import be.stijnhooft.uniontestframeworkprototype.flux.ResponseReceiverServiceService;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author stijnhooft
 */
@WebService
public class CalculatorService {
    
    @WebServiceRef(ResponseReceiverServiceService.class)
    private ResponseReceiverService responseReceiverService;
    
    @WebMethod
    public void sum(double a, double b) {
        String sum = String.valueOf(a + b);
        
        //send result back asynchronously
        responseReceiverService.receiveResponse(a + " + " + b + " = " + sum);
    }
}
