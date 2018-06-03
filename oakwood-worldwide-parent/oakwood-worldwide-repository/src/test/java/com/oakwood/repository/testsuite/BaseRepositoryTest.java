package com.oakwood.repository.testsuite;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oakwood.repository.ApplicationTest;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest(classes = ApplicationTest.class)
public class BaseRepositoryTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

}
