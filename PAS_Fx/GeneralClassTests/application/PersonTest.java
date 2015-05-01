package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito

public class PersonTest {

	@Before
	public void setUp() throws Exception {
	
		@Test
		public void testPersonDefaultConstructor{
			Person 
		}
		
		
		@Test
		public void testUsingMockitoSpy() {
		    // given
		    Person sut = Mockito.spy(AbstractCase1.class);
		    // when
		    String result = sut.methodToBeTested();
		    // then
		    Assert.assertEquals("CASE-1", result);
		}
		
		
				
	}

	@Test
	public void testPersonStringStringStringChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGender() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetGender() {
		fail("Not yet implemented");
	}

}
