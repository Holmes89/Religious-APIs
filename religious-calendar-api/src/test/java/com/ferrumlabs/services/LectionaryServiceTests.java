package com.ferrumlabs.services;

import java.util.Set;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ferrumlabs.ReligiousCalendarApiApplication;
import com.ferrumlabs.exceptions.ServiceException;
import com.ferrumlabs.services.interfaces.ILectionaryService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ReligiousCalendarApiApplication.class)
public class LectionaryServiceTests {

	@Autowired
	ILectionaryService lectService;
	
	private DateTime testDate = new DateTime(2016, 7, 20, 0, 0, 0);
	private DateTime anotherTestDate = new DateTime(2016, 4, 30, 0, 0, 0);
	
	@Test
	public void testGetLectionaryVerse() throws ServiceException{
		Set<String> lectionaryVerses = lectService.getLectionaryVerses(testDate);
		Assert.assertNotNull(lectionaryVerses);
		Assert.assertEquals(6, lectionaryVerses.size());
		Assert.assertTrue(lectionaryVerses.contains("Amos 8:1-12"));
		Assert.assertTrue(lectionaryVerses.contains("Psalm 52"));
		Assert.assertTrue(lectionaryVerses.contains("Genesis 18:1-10"));
		Assert.assertTrue(lectionaryVerses.contains("Psalm 15"));
		Assert.assertTrue(lectionaryVerses.contains("Colossians 1:15-28"));
		Assert.assertTrue(lectionaryVerses.contains("Luke 10:38-42"));
	}
	
	@Test
	public void testGetLectionaryVerse2() throws ServiceException{
		Set<String> lectionaryVerses = lectService.getLectionaryVerses(anotherTestDate);
		Assert.assertNotNull(lectionaryVerses);
		Assert.assertEquals(4, lectionaryVerses.size());
		Assert.assertTrue(lectionaryVerses.contains("Acts 11:1-18"));
		Assert.assertTrue(lectionaryVerses.contains("Psalm 148"));
		Assert.assertTrue(lectionaryVerses.contains("Revelation 21:1-6"));
		Assert.assertTrue(lectionaryVerses.contains("John 13:31-35"));
	}
}
