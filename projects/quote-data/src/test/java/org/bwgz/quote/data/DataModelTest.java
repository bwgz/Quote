package org.bwgz.quote.data;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "/transaction-context.xml" })
@Transactional
abstract public class DataModelTest {
	protected final Logger logger = Logger.getLogger(this.getClass().getName());

    @PersistenceContext
    protected EntityManager entityManager;
    
    @Test
    public void checkStart() {
    	logger.finest("checkStart()");
        Assert.assertNotNull("Entity manager is null.", entityManager);
    }
}
