/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.stijnhooft.uniontestframeworkprototype;

import be.stijnhooft.uniontestframeworkprototype.flux.ResponseReceiverService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author stijnhooft
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {
    
    @InjectMocks
    private CalculatorService calculatorService;
    
    @Mock
    private ResponseReceiverService responseReceiverService;

    @Test
    public void testSum() {
        calculatorService.sum(2, 3);
        
        verify(responseReceiverService).receiveResponse("2.0 + 3.0 = 5.0");
        verifyNoMoreInteractions(responseReceiverService);        
    }
}
