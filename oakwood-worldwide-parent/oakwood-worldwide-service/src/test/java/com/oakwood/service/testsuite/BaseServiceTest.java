package com.oakwood.service.testsuite;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oakwood.service.ApplicationTest;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class BaseServiceTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

}
