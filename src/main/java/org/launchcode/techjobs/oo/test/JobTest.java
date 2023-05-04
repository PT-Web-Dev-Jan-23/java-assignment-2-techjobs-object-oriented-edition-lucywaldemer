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
@Test
    public void testSettingJobId() {
    Job newJobOne = new Job() ;
    Job newJobTwo = new Job() ;
    assertNotEquals (newJobOne.getId(), newJobTwo.getId());
}

@Test
    public void testJobConstructorSetsAllFields(){
   Job newJobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
 // testing name
   assertTrue(newJobThree.getName() instanceof String);
   assertEquals("Product tester", newJobThree.getName());
// testing employer
    assertTrue(newJobThree.getEmployer() instanceof Employer);
    assertEquals("ACME", newJobThree.getEmployer().getValue());
// testing location
    assertTrue(newJobThree.getLocation() instanceof Location);
    assertEquals("Desert", newJobThree.getLocation().getValue());
// testing position
    assertTrue(newJobThree.getPositionType() instanceof PositionType);
    assertEquals("Quality control", newJobThree.getPositionType().getValue());
// testing coreCompetency
    assertTrue(newJobThree.getCoreCompetency() instanceof CoreCompetency);
    assertEquals("Persistence", newJobThree.getCoreCompetency().getValue());
}

@Test
    public void testJobsForEquality(){
    Job newJobFour = new Job("Developer", new Employer("AT&T"), new Location("St. Louis"), new PositionType("Full Stack"), new CoreCompetency("Coding"));
    Job newJobFive = new Job("Developer", new Employer("AT&T"), new Location("St. Louis"), new PositionType("Full Stack"), new CoreCompetency("Coding"));
    System.out.println((newJobFive.getId() == newJobFour.getId()));
}

//Building The toString Method
@Test
    public void testToStringStartsAndEndsWithNewLine(){
    Job newJobSix = new Job();
 assertEquals( '\n', newJobSix.toString().charAt(0));
    assertEquals( '\n', newJobSix.toString().charAt(newJobSix.toString().length() - 1));
}

@Test
    public void testToStringContainsCorrectLabelsAndData(){
    //ID:  _______
    //Name: _______
    //Employer: _______
    //Location: _______
    //Position Type: _______
    //Core Competency: _______
    Job newJobSeven = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(newJobSeven.toString().contains("ID: "));
    assertTrue(newJobSeven.toString().contains("Name: "));
    assertTrue(newJobSeven.toString().contains("Employer: "));
    assertTrue(newJobSeven.toString().contains("Location: "));
    assertTrue(newJobSeven.toString().contains("Position Type: "));
    assertTrue(newJobSeven.toString().contains("Core Competency: "));

// testing name
    assertTrue(newJobSeven.getName() == ("Product tester"));
    assertEquals("Product tester", newJobSeven.getName());
// testing employer
    assertTrue(newJobSeven.getEmployer().getValue() == ("ACME"));
    assertEquals("ACME", newJobSeven.getEmployer().getValue());
// testing location
    assertTrue(newJobSeven.getLocation().getValue() == ("Desert"));
    assertEquals("Desert", newJobSeven.getLocation().getValue());
// testing position
    assertTrue(newJobSeven.getPositionType().getValue() == ("Quality control"));
    assertEquals("Quality control", newJobSeven.getPositionType().getValue());
// testing coreCompetency
    assertTrue(newJobSeven.getCoreCompetency().getValue() == ("Persistence"));
    assertEquals("Persistence", newJobSeven.getCoreCompetency().getValue());
}

@Test
    public void testToStringHandlesEmptyField(){
    Job newJobEight = new Job(null , new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(newJobEight.toString().contains("Data not available"));
    Job newJobNine = new Job("Product tester", null , new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(newJobEight.toString().contains("Data not available"));
    Job newJobTen = new Job("Product tester", new Employer("ACME"),null , new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(newJobEight.toString().contains("Data not available"));
    Job newJobEleven = new Job("Product tester", new Employer("ACME"), new Location("Desert"), null, new CoreCompetency("Persistence"));
    assertTrue(newJobEight.toString().contains("Data not available"));
    Job newJobTwelve = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), null);
    assertTrue(newJobEight.toString().contains("Data not available"));
}

}
