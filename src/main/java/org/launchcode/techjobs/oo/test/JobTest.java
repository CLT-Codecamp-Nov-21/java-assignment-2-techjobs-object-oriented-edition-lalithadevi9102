package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {


    //task 4
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobB = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(jobB.getName() instanceof String);
        assertTrue(jobB.getEmployer() instanceof Employer);
        assertTrue(jobB.getLocation() instanceof Location);
        assertTrue(jobB.getPositionType() instanceof PositionType);
        assertTrue(jobB.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", jobB.getName());
        assertEquals("ACME", jobB.getEmployer().getValue());
        assertEquals("Desert", jobB.getLocation().getValue());
        assertEquals("Quality control", jobB.getPositionType().getValue());
        assertEquals("Persistence", jobB.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobA = new Job("Front-End Developer", new Employer("LaunchCode"), new Location("Charlotte"), new PositionType("Full Time"), new CoreCompetency("JavaScript"));
        Job jobA1 = new Job("Front-End Developer", new Employer("LaunchCode"), new Location("Charlotte"), new PositionType("Full Time"), new CoreCompetency("JavaScript"));

        assertFalse(jobA.equals(jobA1));
    }
    //task 5
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobA = new Job("Front-End Developer", new Employer("LaunchCode"), new Location("Charlotte"), new PositionType("Full Time"), new CoreCompetency("JavaScript"));

        int length = jobA.toString().length();
        assertEquals('\n', jobA.toString().charAt(0));
        assertEquals('\n', jobA.toString().charAt(length - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobA = new Job("Front-End Developer", new Employer("LaunchCode"), new Location("Charlotte"), new PositionType("Full Time"), new CoreCompetency("JavaScript"));
        assertEquals("\nID: " + jobA.getId() + "" + "\nName: Front-End Developer\nEmployer: LaunchCode\nLocation: Charlotte\nPosition Type: Full Time\nCore Competency: JavaScript\n", jobA.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job jobA = new Job("", new Employer(""), new Location("Charlotte"), new PositionType("Full Time"), new CoreCompetency("JavaScript"));
        assertEquals("\nID: " + jobA.getId() + "" + "\nName: Data not available\nEmployer: Data not available\nLocation: Charlotte\nPosition Type: Full Time\nCore Competency: JavaScript\n", jobA.toString());

    }

}